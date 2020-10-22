package com.engin.eticaretkontrol.Fragments;

import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.airbnb.lottie.LottieAnimationView;
import com.engin.eticaretkontrol.Adapters.OrdersAdapter;
import com.engin.eticaretkontrol.ConfigData;
import com.engin.eticaretkontrol.NetProgress.Models.Order;
import com.engin.eticaretkontrol.R;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import it.xabaras.android.recyclerview.swipedecorator.RecyclerViewSwipeDecorator;

public class CollectOrders extends Fragment{
    static final String TAG = "CollectOrdersProcess";
    RecyclerView collectOrderRV;
    OrdersAdapter ordersAdapter;
    SwipeRefreshLayout collectSwipeRefreshLayout;
    SharedPreferences listPreferences;
    LottieAnimationView lottieAnimationView;
    TextView notFoundTV;
    List<Order> collectOrderList =new ArrayList<>();
    Order temp= null;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //initilazing variable
        View root = inflater.inflate(R.layout.fragment_collect_ordres,container,false);
        collectOrderRV = root.findViewById(R.id.collectOrdersRV);
        collectSwipeRefreshLayout = root.findViewById(R.id.collectOrdersSwipeRefreshLayout);
        lottieAnimationView = root.findViewById(R.id.animationViewCollectedOrders);
        notFoundTV = root.findViewById(R.id.notFoundTVCollected);
        collectOrderRV.setHasFixedSize(true);
        collectOrderRV.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        listPreferences = getActivity().getSharedPreferences("list",0);
        // getting list from memory
        if (ConfigData.getList(listPreferences,"localList") != null){
            // list debuging and cleaning by collecting state
            collectOrderList = ConfigData.getList(listPreferences,"localList");
            collectOrderList.removeIf((Order o) -> o.getCollectedState() != 2);
        }
        // checking size and giving information
        if (collectOrderList.size() == 0){
            lottieAnimationView.setVisibility(View.VISIBLE);
            notFoundTV.setVisibility(View.VISIBLE);
        }
        ordersAdapter =new OrdersAdapter(getActivity().getApplicationContext(),getActivity(),collectOrderList);
        collectOrderRV.setAdapter(ordersAdapter);
        //refresh icon config
        collectSwipeRefreshLayout.setColorSchemeResources(android.R.color.holo_green_light,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
        // while refreshing activity recreate
        collectSwipeRefreshLayout.setOnRefreshListener(() -> {
            ordersAdapter.clear();
            getActivity().finish();
            getActivity().startActivity(getActivity().getIntent());
            getActivity().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            collectSwipeRefreshLayout.setRefreshing(false);
        });
        // for swipe delete creating function
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(collectOrderRV);
        return root;
    }

    ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            int position=((OrdersAdapter.OrdersViewHolder) viewHolder).getAdapterPosition();
            // swipping left
            if (direction == ItemTouchHelper.LEFT){
                // order keep in memory
                temp = collectOrderList.get(position);
                collectOrderList.remove(temp);
                // finding item in local list and chancing collected state
                List<Order> localList= ConfigData.getList(listPreferences,"localList");
                int index = Order.findItem(temp,localList);
                temp.collectedState =3;
                ordersAdapter.notifyItemRemoved(position);
                localList.set(index,temp);
                ConfigData.setList(listPreferences,"localList",localList);
                Snackbar.make(collectOrderRV,temp.getId().toString(),Snackbar.LENGTH_LONG).setAction("Geri Al", view -> {
                    // getting item in memory and adding local list
                    collectOrderList.add(position,temp);
                    temp.collectedState = 2;
                    ordersAdapter.notifyItemInserted(position);
                    localList.set(index,temp);
                    ConfigData.setList(listPreferences,"localList",localList);

                }).show();
            }

        }

        @Override
        public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
            // setting delete icon while swiping left
            new RecyclerViewSwipeDecorator.Builder(getActivity().getApplicationContext(),c,recyclerView,viewHolder,dX,dY,actionState,isCurrentlyActive)
                    .addSwipeLeftBackgroundColor(ContextCompat.getColor(getActivity().getApplicationContext(),R.color.Red))
                    .addSwipeLeftActionIcon(R.drawable.ic_delete)
                    .create()
                    .decorate();
            super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
        }
    };


}
