package com.engin.eticaretkontrol;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import com.engin.eticaretkontrol.Activities.SplashActivity;
import com.engin.eticaretkontrol.NetProgress.ApiInitialize;
import com.engin.eticaretkontrol.NetProgress.Interfaces.TokenDao;
import com.engin.eticaretkontrol.NetProgress.Models.Token;
import com.engin.eticaretkontrol.NetProgress.Models.TokenError;
import com.engin.eticaretkontrol.NetProgress.RetrofitClient;

import java.io.IOException;
import java.lang.annotation.Annotation;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Response;

public class ErrorHandling  {

    private static final String TAG = "ErrorHandling";
    SharedPreferences preferences;

    // parse response to TokenError
    public static TokenError parseError(Response<?> response){
        Converter<ResponseBody, TokenError> converter =
               RetrofitClient.getClient().responseBodyConverter(TokenError.class, new Annotation[0]);
        TokenError error;
        try{
            assert response.errorBody() != null;
            error = converter.convert(response.errorBody());
        } catch (IOException e) {
            return  new TokenError();
        }
        return error;
    }

    // Handled Error
    public static void recognizeError(Response<?> response, Context context,SharedPreferences preferences){
        String refresh_token =preferences.getString("refresh_token","none");
        TokenError error;
        switch (response.code()){
            case 404:
                Log.w(TAG, "404 Not Found  " );
                Toast.makeText(context,"404 Not Found",Toast.LENGTH_LONG).show();
            case 500:
                Log.w(TAG, "500 Server Error");
                Toast.makeText(context,"500 Server Error",Toast.LENGTH_LONG).show();
            case 401:
                Log.w(TAG, "401 Unauthorized");
                error = ErrorHandling.parseError(response);
                Toast.makeText(context,"Tekrar Deneyiniz\n"+error.getErrorDescription(),Toast.LENGTH_LONG).show();
                TokenDao tokenDao = ApiInitialize.getTokenDao();
                //refreshing Token...
                tokenDao.getATwRefreshT(ConfigData.REFRESH_GRANT_TYPE,ConfigData.CLIENT_ID,ConfigData.CLIENT_SECRET,refresh_token).enqueue(new Callback<Token>() {
                    @Override
                    public void onResponse(Call<Token> call, Response<Token> response) {
                        // saving tokens...
                        if (response.isSuccessful() && response != null){
                        Log.w(TAG, "Response is successful refreshing token" );
                        Token.saveTokens(response.body(),preferences);
                        Log.w(TAG, "Token refreshing Successfully" );
                        }
                        else {
                            Log.w(TAG, "Response is failed Error Handling running..." );
                            ErrorHandling.recognizeError(response, context,preferences);
                        }
                    }

                    @Override
                    public void onFailure(Call<Token> call, Throwable t) {

                    }
                });

            default:
                Log.w(TAG, "Default error running" );
                error = ErrorHandling.parseError(response);
                if (error != null){
                }
                else {
                    Toast.makeText(context,"Bilinmeyen Hata",Toast.LENGTH_LONG).show();
                }

        }
    }
}
