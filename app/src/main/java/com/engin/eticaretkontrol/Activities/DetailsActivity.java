package com.engin.eticaretkontrol.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import com.engin.eticaretkontrol.NetProgress.Models.Order;
import com.engin.eticaretkontrol.R;

public class DetailsActivity extends AppCompatActivity {
    TextView textView;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        textView = findViewById(R.id.testTV);
        Order order = (Order) getIntent().getSerializableExtra("Order");
        textView.setText(order.getId().toString()+"   "+order.getBankName()+"  "+order.getCustomerFirstname()+"       "+order.getCustomerPhone()+"       "+order.getTaxAmount().toString());

    }
}