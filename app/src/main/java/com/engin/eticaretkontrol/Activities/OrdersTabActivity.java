package com.engin.eticaretkontrol.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.engin.eticaretkontrol.Adapters.ViewPagerAdapter;
import com.engin.eticaretkontrol.ConfigData;
import com.engin.eticaretkontrol.ErrorHandling;
import com.engin.eticaretkontrol.Fragments.ApprovedOrders;
import com.engin.eticaretkontrol.Fragments.CollectOrders;
import com.engin.eticaretkontrol.Fragments.CollectingOrders;
import com.engin.eticaretkontrol.NetProgress.ApiInitialize;
import com.engin.eticaretkontrol.NetProgress.Interfaces.OrdersDao;
import com.engin.eticaretkontrol.NetProgress.Models.Order;
import com.engin.eticaretkontrol.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrdersTabActivity extends AppCompatActivity {
    static final String TAG = "OrdersProcess";
    TabLayout ordersTabLayout;
    ViewPager2 viewPager;
    SharedPreferences preferences,listPreferences;
    RecyclerView orderRV;
    Toolbar orderTB;
    ArrayList<Fragment> fragmentsList = new ArrayList<>();
    ArrayList<String> fragmentsTitle = new ArrayList<>();
    List<Order> dynamicList = new ArrayList<>();
    List<Order> localList = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders_tab);
        //variables initializing
        initVariable();
        // Data receiving
        String token = preferences.getString("access_token","NONE");
        getData(token);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            // BackPress progress
            case android.R.id.home:
                onBackPressed();
                finish();
                return true;
            // cleaning preferences
            case R.id.clearCache:
                listPreferences.edit().clear().apply();
                startActivity(new Intent(OrdersTabActivity.this,MainActivity.class));
                finish();

            default:
                return super.onOptionsItemSelected(item);
        }
    }


    public void initVariable(){
        ordersTabLayout = findViewById(R.id.ordersTabLayout);
        orderTB = findViewById(R.id.ordersTB);
        listPreferences = getSharedPreferences("list",0);
        preferences = getSharedPreferences("Tokens",0);
        // Storage date
        Date date = new Date();
        preferences.edit().putLong("LastLogin",date.getTime()).apply();
        //Toolbar configuration
        setSupportActionBar(orderTB);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    public void getData(String token){
        Log.i(TAG, "Getting data from Api..." );
        OrdersDao ordersDao = ApiInitialize.getOrdersDao();
        ordersDao.getOrders("Bearer "+token /*,"approved","-id"*/).enqueue(new Callback<List<Order>>() {
            @Override
            public void onResponse(Call<List<Order>> call, Response<List<Order>> response) {
                if (response.isSuccessful() && response.body() != null){
                    Log.w(TAG, "Response is successful, adding list" );
                    dynamicList= response.body();
                    // fragments creating
                    ApprovedOrders approvedOrders = new ApprovedOrders();
                    CollectOrders collectOrders = new CollectOrders();
                    CollectingOrders collectingOrders = new CollectingOrders();
                    // Checking  list which stored in memory
                    if (ConfigData.getList(listPreferences,"localList") != null){
                        localList=ConfigData.getList(listPreferences,"localList");
                        //  updating list by fetching data
                        List<Order> temp = Order.compareList(dynamicList,localList);
                        if (dynamicList.size()>localList.size()){
                            localList =  Order.addItems(localList,temp);
                        }
                        else if(localList.size()>dynamicList.size()){
                            localList=  Order.deleteItems(localList,temp);
                        }
                        else{
                            ;
                        }
                    }
                    // cloning list and setting collected state
                    if(ConfigData.getList(listPreferences,"localList") == null){
                        for(Order o:dynamicList){
                            o.getCollectedState();
                            localList.add(o);
                        }
                    }
                    // saving list in mem
                    ConfigData.setList(listPreferences,"localList",localList);
                    // Adapter configuration
                    viewPager = findViewById(R.id.ordersViewPager);
                    fragmentsList.add(approvedOrders);
                    fragmentsList.add(collectingOrders);
                    fragmentsList.add(collectOrders);
                    fragmentsTitle.add("Sipariş Listesi");
                    fragmentsTitle.add("Toplanan Sipariş Listesi");
                    fragmentsTitle.add("Toplanmış Siparişler");
                    ViewPagerAdapter viewPagerAdapter =new ViewPagerAdapter(OrdersTabActivity.this,fragmentsList);
                    viewPager.setAdapter(viewPagerAdapter);
                    new TabLayoutMediator(ordersTabLayout,viewPager,(tab,position) -> tab.setText(fragmentsTitle.get(position))).attach();
                }
                else{
                    Log.w(TAG, "Response is failed recognize error");
                    ErrorHandling.recognizeError(response,OrdersTabActivity.this);
                }
            }
            @Override
            public void onFailure(Call<List<Order>> call, Throwable t) {
                Log.e(TAG, "Response Failed ",t );
                Toast.makeText(OrdersTabActivity.this,t.toString(),Toast.LENGTH_SHORT).show();
            }
        });

    }
}