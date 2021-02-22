package com.engin.eticaretkontrol;

import android.content.SharedPreferences;

import com.engin.eticaretkontrol.NetProgress.Models.Order;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public  class ConfigData {
    public static final String  CLIENT_ID ="bu8_4jpv8zhavp4wgso08g04csdeneme408k0wcksw4ccsowsg0o4cooks0o";
    public static final String CLIENT_SECRET = "bu1io8il2swexwgizli8wkk4s0swwcosko04ws8gk4ccsw8sosco8gk4s";
    public static final String REDIRECT_URI = "http://www.hakmarexpress.com/api-key-hakmar2.php";
    public static final String RESPONSE_TYPE = "code";
    public static final String STATE="1233fdd45jbevd6nam";
    public static final String GRANT_TYPE = "authorization_code";
    public static final String REFRESH_GRANT_TYPE ="refresh_token";
    public static final int APPROVED =0;
    public static final int COLLECTING =1;
    public static final int COLLECTED =2;

    // setting list in memory
    public static void setList(SharedPreferences preferences, String key, List<Order> orderList){
        Gson gson = new Gson();
        String json = gson.toJson(orderList);
        preferences.edit().remove(key).apply();
        preferences.edit().putString(key,json).apply();
    }


    // getting list from memory
    public static List<Order> getList(SharedPreferences preferences,String key){
        List<Order> items;
        String object = preferences.getString(key,null);
        if (object != null){
            Gson gson = new Gson();
            Type type = new TypeToken<List<Order>>(){}.getType();
            items = gson.fromJson(object,type);
            return items;
        }
        return null;
    }



}
