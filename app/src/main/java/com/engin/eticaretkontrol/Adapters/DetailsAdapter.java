package com.engin.eticaretkontrol.Adapters;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.engin.eticaretkontrol.NetProgress.Models.OrderItem;
import com.engin.eticaretkontrol.R;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class DetailsAdapter extends RecyclerView.Adapter<DetailsAdapter.DetailsViewHolder> {

    private List<OrderItem> orderItems;
    private Context context;

    public DetailsAdapter(List<OrderItem> orderItems, Context context) {
        this.orderItems = orderItems;
        this.context = context;
    }

    @NonNull
    @Override
    public DetailsAdapter.DetailsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DetailsViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.product_row,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull DetailsAdapter.DetailsViewHolder holder, int position) {
        OrderItem orderItem=orderItems.get(position);
        holder.productName.setText(orderItem.getProductName());
        holder.productCount.setText(String.valueOf(orderItem.getProductQuantity()));
        holder.productPrice.setText(NumberFormat.getCurrencyInstance(new Locale("tr","TR")).format(orderItem.getProductPrice()));
        if(orderItem.getCollectedState()){
            holder.productName.setPaintFlags(holder.productName.getPaintFlags()| Paint.STRIKE_THRU_TEXT_FLAG);
            holder.productCount.setPaintFlags(holder.productCount.getPaintFlags()| Paint.STRIKE_THRU_TEXT_FLAG);
            holder.productPrice.setPaintFlags(holder.productPrice.getPaintFlags()| Paint.STRIKE_THRU_TEXT_FLAG);
        }
    }

    @Override
    public int getItemCount() {
        return orderItems.size();
    }

    public static class DetailsViewHolder  extends RecyclerView.ViewHolder{
        TextView productName,productCount,productPrice;
        public DetailsViewHolder(@NonNull View itemView) {
            super(itemView);
            productName=itemView.findViewById(R.id.productName);
            productCount = itemView.findViewById(R.id.productCount);
            productPrice = itemView.findViewById(R.id.productPrice);
        }
    }

    public void layoutAnimation(RecyclerView recyclerView){
        Context context = recyclerView.getContext();
        LayoutAnimationController layoutAnimationController = AnimationUtils.loadLayoutAnimation(context,R.anim.layout_fall_down);
        recyclerView.setLayoutAnimation(layoutAnimationController);
        recyclerView.getAdapter().notifyDataSetChanged();
        recyclerView.scheduleLayoutAnimation();
    }
}
