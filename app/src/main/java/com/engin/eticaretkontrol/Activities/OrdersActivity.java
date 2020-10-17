package com.engin.eticaretkontrol.Activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.engin.eticaretkontrol.Adapters.OrdersAdapter;
import com.engin.eticaretkontrol.ConfigData;
import com.engin.eticaretkontrol.NetProgress.ApiInitialize;
import com.engin.eticaretkontrol.NetProgress.Interfaces.OrdersDao;
import com.engin.eticaretkontrol.NetProgress.Interfaces.TokenDao;
import com.engin.eticaretkontrol.NetProgress.Models.Order;
import com.engin.eticaretkontrol.NetProgress.Models.Token;
import com.engin.eticaretkontrol.NetProgress.Models.TokenError;
import com.engin.eticaretkontrol.R;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class OrdersActivity extends AppCompatActivity {
    private static final String TAG = "OrdersProcess";
    RecyclerView orderRV;
    Toolbar orderTB;
    SharedPreferences preferences;
    OrdersAdapter ordersAdapter;
    List<Order> orderList;
    SwipeRefreshLayout swipeRefreshLayout;
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);
        orderRV = findViewById(R.id.ordersRV);
        orderTB = findViewById(R.id.ordersTB);
        swipeRefreshLayout = findViewById(R.id.ordersSwipeRefreshLayout);
        preferences = getSharedPreferences("Tokens",0);
        // saving last login
        Date date = new Date();
        preferences.edit().putLong("LastLogin",date.getTime()).apply();
        String token = preferences.getString("access_token","NONE");
        //Toolbar configuration
        setSupportActionBar(orderTB);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        //RecycleView configuration
        orderRV.setHasFixedSize(true);
        orderRV.setLayoutManager(new LinearLayoutManager(this));
        orderList = new ArrayList<>();
        ordersAdapter =new OrdersAdapter(OrdersActivity.this,orderList);
        orderRV.setAdapter(ordersAdapter);
        Log.w(TAG, "Getting Data " );
        getData(token);

        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_green_light,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);

        swipeRefreshLayout.setOnRefreshListener(() -> {
            ordersAdapter.clear();
            getData(token);
            swipeRefreshLayout.setRefreshing(false);
        });


    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            // BackPress progress
            case android.R.id.home:
                onBackPressed();
                preferences.edit().putBoolean("ControlOnResume",false).apply();
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void getData(String token){
        Log.w(TAG, "getData: method running..." );
        OrdersDao ordersDao = ApiInitialize.getOrdersDao();
        ordersDao.getOrders("Bearer "+token ,"approved","-id").enqueue(new Callback<List<Order>>() {
            @Override
            public void onResponse(Call<List<Order>> call, Response<List<Order>> response) {
                if (response.isSuccessful() && response.body() != null){
                    Log.w(TAG, "Response is successful adding list" );
                    orderList = response.body();
                    ordersAdapter.setOrdersList(orderList);
                    ordersAdapter.notifyDataSetChanged();
                }
                else{
                    // Specific error handling
                    try {
                        assert response.errorBody() != null;
                        String body = response.errorBody().string();
                        Gson gson =new Gson();
                        TokenError tokenError = gson.fromJson(body,TokenError.class);
                        if (tokenError.getErrorDescription().equals("The access token provided has expired.")){
                            TokenDao tokenDao = ApiInitialize.getTokenDao();
                            String refresh_token = preferences.getString("refresh_token","NONE");
                            tokenDao.getATwRefreshT(ConfigData.REFRESH_GRANT_TYPE,ConfigData.CLIENT_ID,ConfigData.CLIENT_SECRET,refresh_token).enqueue(new Callback<Token>() {
                                @Override
                                public void onResponse(Call<Token> call, Response<Token> response) {
                                    if (response.isSuccessful() && response.body() != null){
                                        Token.saveTokens(response.body(),preferences);
                                        Intent intent = getIntent();
                                        finish();
                                        startActivity(intent);
                                    }
                                    else{
                                        assert response.errorBody() != null;
                                        String body = null;
                                        try {
                                            body = response.errorBody().string();
                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        }
                                        Gson gson =new Gson();
                                        TokenError tokenError = gson.fromJson(body,TokenError.class);
                                        Toast.makeText(OrdersActivity.this,tokenError.getError(),Toast.LENGTH_LONG).show();
                                    }
                                }

                                @Override
                                public void onFailure(Call<Token> call, Throwable t) {

                                }
                            });
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }


            }

            @Override
            public void onFailure(Call<List<Order>> call, Throwable t) {
                Log.w(TAG, "Response Failed ",t );
                Toast.makeText(OrdersActivity.this,t.toString(),Toast.LENGTH_SHORT).show();
            }
        });
    }

}