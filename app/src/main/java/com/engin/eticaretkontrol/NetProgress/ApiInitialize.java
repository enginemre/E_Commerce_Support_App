package com.engin.eticaretkontrol.NetProgress;

import com.engin.eticaretkontrol.NetProgress.Interfaces.OrdersDao;
import com.engin.eticaretkontrol.NetProgress.Interfaces.TokenDao;

public class ApiInitialize {

    public static final  String BASE_URL ="http://hakmarmagazacilik.myideasoft.com/";

    public static TokenDao getTokenDao(){
        return RetrofitClient.getClient(BASE_URL).create(TokenDao.class);
    }

    public static OrdersDao getOrdersDao(){
        return RetrofitClient.getClient(BASE_URL).create(OrdersDao.class);
    }
}
