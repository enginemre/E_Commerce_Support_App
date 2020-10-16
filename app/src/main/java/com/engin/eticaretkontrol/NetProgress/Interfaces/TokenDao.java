package com.engin.eticaretkontrol.NetProgress.Interfaces;

import com.engin.eticaretkontrol.NetProgress.Models.Token;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface TokenDao {

    @POST("oauth/v2/token")
    @FormUrlEncoded
    Call<Token> getAT(@Field("grant_type") String grant_type,
                         @Field("client_id") String client_id,
                         @Field("client_secret") String client_secret,
                         @Field("code") String code,
                         @Field("redirect_uri") String redirect_uri);


    @POST("oauth/v2/token")
    @FormUrlEncoded
    Call<Token> getATwRefreshT(@Field("grant_type") String grant_type,
                             @Field("client_id") String client_id,
                             @Field("client_secret") String client_secret,
                             @Field("refresh_token") String refresh_token);


}
