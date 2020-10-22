package com.engin.eticaretkontrol.Fragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.airbnb.lottie.LottieAnimationView;
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
    LottieAnimationView lottieAnimationView;
    TextView notFoundTV;
    SwipeRefreshLayout collectingSwipeRefreshLayout;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // initliaze Variable
        View root = inflater.inflate(R.layout.fragment_collecting_orders,container,false);
        collectingOrderRV = root.findViewById(R.id.collectingOrdersRV);
        collectingSwipeRefreshLayout = root.findViewById(R.id.collectingOrdersSwipeRefreshLayout);
        lottieAnimationView = root.findViewById(R.id.animationViewCollectingOrders);
        notFoundTV = root.findViewById(R.id.notFoundTVCollecting);
        collectingOrderRV.setHasFixedSize(true);
        collectingOrderRV.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        listPreferences = getActivity().getSharedPreferences("list",0);
        // getting list from memory
        if (ConfigData.getList(listPreferences,"localList") != null){
            // list debuging and cleaning by collecting state
            collectingOrderList = ConfigData.getList(listPreferences,"localList");
            collectingOrderList.removeIf((Order o) -> o.getCollectedState() != 1);
        }
        // checking size and giving information
        if (collectingOrderList.size() == 0){
            lottieAnimationView.setVisibility(View.VISIBLE);
            notFoundTV.setVisibility(View.VISIBLE);
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
            getActivity().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            collectingSwipeRefreshLayout.setRefreshing(false);
        });

        return root;
    }
}
