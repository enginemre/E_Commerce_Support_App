package com.engin.eticaretkontrol.Activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.engin.eticaretkontrol.Adapters.DetailsAdapter;
import com.engin.eticaretkontrol.ConfigData;
import com.engin.eticaretkontrol.NetProgress.Models.Order;
import com.engin.eticaretkontrol.NetProgress.Models.OrderItem;
import com.engin.eticaretkontrol.R;

import java.text.ParseException;
import java.util.List;

public class DetailsActivity extends AppCompatActivity {
    private static final String TAG = "DetailsActivity";
    TextView costumerName,date;
    ImageView scan;
    RecyclerView detailsRV;
    List<OrderItem> productsList;
    DetailsAdapter detailsAdapter;
    SharedPreferences listPreferences;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        initVariable();
        //Getting order from OrdersTabActivity and local list from memory
        Order order = (Order) getIntent().getParcelableExtra("Order");
        List<Order> localList=ConfigData.getList(listPreferences,"localList");
        //finding Orginal order
        int index = Order.findItem(order,localList);
        //chagecing collected state in local list
        Log.i(TAG, "Changing collected state");
        order.collectedState = 1;
        localList.set(index,order);
        ConfigData.setList(listPreferences,"localList",localList);
        Log.i(TAG, "Local list changed");
        // order information showing...
        costumerName.setText(order.getCustomerFirstname().toUpperCase()+" "+order.getCustomerSurname().toUpperCase());
        date.setText(order.getCreatedAt());
        // setting RV
        productsList =order.getOrderItems();
        detailsRV.setHasFixedSize(true);
        detailsRV.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        detailsAdapter = new DetailsAdapter(productsList,getApplicationContext());
        detailsRV.setAdapter(detailsAdapter);

    }

    public void initVariable(){
        costumerName = findViewById(R.id.detailsName);
        date = findViewById(R.id.detailsDate);
        scan = findViewById(R.id.productScan);
        detailsRV = findViewById(R.id.detailsRV);
        listPreferences = getSharedPreferences("list",0);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(DetailsActivity.this,OrdersTabActivity.class));

    }
}