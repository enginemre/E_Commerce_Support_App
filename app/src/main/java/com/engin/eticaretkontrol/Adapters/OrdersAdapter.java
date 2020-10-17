package com.engin.eticaretkontrol.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.engin.eticaretkontrol.Activities.DetailsActivity;
import com.engin.eticaretkontrol.NetProgress.Models.Order;
import com.engin.eticaretkontrol.R;

import java.text.ParseException;
import java.util.List;

public class OrdersAdapter extends RecyclerView.Adapter<OrdersAdapter.OrdersViewHolder> {

    private Context context;
    private List<Order> orders;

    public OrdersAdapter(Context context, List<Order> orders) {
        this.context = context;
        this.orders = orders;
    }

    public void setOrdersList(List<Order> ordersList){
        this.orders = ordersList;
    }

    public void clear(){
        orders.clear();
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public OrdersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.orders_row,parent,false);
        return new OrdersViewHolder(itemView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull OrdersViewHolder holder, int position) {
        final Order order = orders.get(position);
        holder.orderIdTV.setText(Integer.toString(order.getId()));
        try {
            holder.ordersDate.setText(order.getCreatedAt());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        holder.orderName.setText(order.getCustomerFirstname() +" "+order.getCustomerSurname());
        holder.ordersCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailsActivity.class);
                intent.putExtra("Order",order);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return orders.size();
    }

    public static class OrdersViewHolder extends  RecyclerView.ViewHolder {
        TextView orderIdTV, orderName,ordersDate;
        CardView ordersCV;


        public OrdersViewHolder(@NonNull View itemView) {
            super(itemView);
            orderIdTV =itemView.findViewById(R.id.orderId);
            orderName = itemView.findViewById(R.id.descriptionOfOrder);
            ordersDate = itemView.findViewById(R.id.dateTV);
            ordersCV = itemView.findViewById(R.id.orderListCV);
        }
    }
}
