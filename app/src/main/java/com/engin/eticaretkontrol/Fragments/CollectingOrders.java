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

public class CollectingOrders extends Fragment {
    private static final String TAG = "CollectingOrdersProcess";
    RecyclerView collectingOrderRV;
    OrdersAdapter ordersAdapter;
    List<Order> collectingOrderList = new ArrayList<>();
    SharedPreferences listPreferences;
    SwipeRefreshLayout collectingSwipeRefreshLayout;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // initliaze Variable
        View root = inflater.inflate(R.layout.fragment_collecting_orders,container,false);
        collectingOrderRV = root.findViewById(R.id.collectingOrdersRV);
        collectingSwipeRefreshLayout = root.findViewById(R.id.collectingOrdersSwipeRefreshLayout);
        collectingOrderRV.setHasFixedSize(true);
        collectingOrderRV.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        listPreferences = getActivity().getSharedPreferences("list",0);
        // getting list from memory
        if (ConfigData.getList(listPreferences,"localList") != null){
            // list debuging and cleaning by collecting state
            collectingOrderList = ConfigData.getList(listPreferences,"localList");
            collectingOrderList.removeIf((Order o) -> o.collectedState != 1);
        }
        ordersAdapter =new OrdersAdapter(getActivity().getApplicationContext(),getActivity(),collectingOrderList);
        collectingOrderRV.setAdapter(ordersAdapter);
        // refresh icon congig
        collectingSwipeRefreshLayout.setColorSchemeResources(android.R.color.holo_green_light,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
        // while refreshing activity recreate
        collectingSwipeRefreshLayout.setOnRefreshListener(() -> {
            ordersAdapter.clear();
            getActivity().finish();
            getActivity().startActivity(getActivity().getIntent());
            collectingSwipeRefreshLayout.setRefreshing(false);
        });

        return root;
    }
}
