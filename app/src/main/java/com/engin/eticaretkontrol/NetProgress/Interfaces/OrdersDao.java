package com.engin.eticaretkontrol.NetProgress.Interfaces;

import com.engin.eticaretkontrol.NetProgress.Models.Order;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface OrdersDao {

    @GET("api/orders")
    Call<List<Order>> getOrders(@Header("Authorization") String auth);

    @GET("api/orders/")
    Call<Order> getOrder(@Path("id") int id);
}
