package com.engin.eticaretkontrol.Adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.engin.eticaretkontrol.Activities.DetailsActivity;
import com.engin.eticaretkontrol.NetProgress.Models.Order;
import com.engin.eticaretkontrol.R;

import java.text.ParseException;
import java.util.List;

public class OrdersAdapter extends RecyclerView.Adapter<OrdersAdapter.OrdersViewHolder> {

    private Context context;
    Activity activity;
    private List<Order> orders;

    public OrdersAdapter(Context context,Activity activity, List<Order> orders) {
        this.context = context;
        this.orders = orders;
        this.activity = activity;
    }

    public void setOrdersList(List<Order> ordersList){
        this.orders = ordersList;
    }

    public List<Order> getOrdersList(){ return this.orders;}

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
        holder.ordersDate.setText(order.getCreatedAt());
        holder.orderName.setText(order.getCustomerFirstname() +" "+order.getCustomerSurname());
        // changing ımageview by collected state
        if(order.getCollectedState() == 2){
            holder.ordersIV.setImageDrawable(ContextCompat.getDrawable(activity, R.drawable.collected));
        }
        holder.ordersCV.setOnClickListener(view -> {

            AlertDialog.Builder alertDialog=new AlertDialog.Builder(activity);

            alertDialog.setMessage("Siparişi Toplamaya Başlamak İstiyor musunuz ?");
            alertDialog.setIcon(R.drawable.ic_baseline_warning_24);
            alertDialog.setTitle("Sipariş Topla");
            alertDialog.setPositiveButton("Evet", (dialogInterface, i) -> {
                Intent intent = new Intent(context, DetailsActivity.class);
                intent.putExtra("Order",order);
                activity.startActivity(intent);
                activity.overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
                activity.finish();
            });
            alertDialog.setNegativeButton("Vazgeç", (dialogInterface, i) -> {
                Toast.makeText(context,"Vazgeçildi",Toast.LENGTH_SHORT).show();
                dialogInterface.cancel();
            });
           AlertDialog alertDialog1 = alertDialog.create();
           alertDialog1.show();


        });

    }


    @Override
    public int getItemCount() {
        return orders.size();
    }

    public static class OrdersViewHolder extends  RecyclerView.ViewHolder {
        TextView orderIdTV, orderName,ordersDate;
        CardView ordersCV;
        ImageView ordersIV;
        public OrdersViewHolder(@NonNull View itemView) {
            super(itemView);
            orderIdTV =itemView.findViewById(R.id.orderId);
            orderName = itemView.findViewById(R.id.ordersRowName);
            ordersDate = itemView.findViewById(R.id.dateTV);
            ordersCV = itemView.findViewById(R.id.orderListCV);
            ordersIV =itemView.findViewById(R.id.ordersRowIV);
        }
    }
}
