package com.engin.eticaretkontrol.Fragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.engin.eticaretkontrol.Adapters.OrdersAdapter;
import com.engin.eticaretkontrol.ConfigData;
import com.engin.eticaretkontrol.NetProgress.Models.Order;
import com.engin.eticaretkontrol.R;

import java.util.ArrayList;
import java.util.List;

public class ApprovedOrders extends Fragment {
    static final String TAG = "ApprovedOrdersProcess";
    RecyclerView approvedOrderRV;
    OrdersAdapter ordersAdapter;
    SwipeRefreshLayout approvedSwipeRefreshLayout;
    SharedPreferences listPreferences;
    List<Order> approvedList = new ArrayList<>();
    List<Order> temp = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //initilazing variable
        View root = inflater.inflate(R.layout.fragment_approved_orders,container,false);
        approvedOrderRV = root.findViewById(R.id.approvedOrdersRV);
        approvedSwipeRefreshLayout = root.findViewById(R.id.approvedOrdersSwipeRefreshLayout);
        approvedOrderRV.setHasFixedSize(true);
        approvedOrderRV.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        // getting list from memory
        listPreferences = getActivity().getSharedPreferences("list",0);
        if (ConfigData.getList(listPreferences,"localList") != null){
            // list debuging and cleaning by collecting state
            approvedList = ConfigData.getList(listPreferences,"localList");
            for (Order o:approvedList){
                if (o.getCollectedState() != 0){
                    temp.add(o);
                }
            }
           approvedList= Order.deleteItems(approvedList,temp);
        }
        ordersAdapter =new OrdersAdapter(getActivity().getApplicationContext(),getActivity(),approvedList);
        approvedOrderRV.setAdapter(ordersAdapter);

        //refresh icon config
        approvedSwipeRefreshLayout.setColorSchemeResources(android.R.color.holo_green_light,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
        // while refreshing activity recreate
        approvedSwipeRefreshLayout.setOnRefreshListener(() -> {
            ordersAdapter.clear();
            getActivity().finish();
            getActivity().startActivity(getActivity().getIntent());
            ordersAdapter.notifyDataSetChanged();
            approvedSwipeRefreshLayout.setRefreshing(false);
        });

        return root;
    }


}
