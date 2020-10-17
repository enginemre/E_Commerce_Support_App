package com.engin.eticaretkontrol;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.engin.eticaretkontrol.NetProgress.Models.TokenError;
import com.engin.eticaretkontrol.NetProgress.RetrofitClient;

import java.io.IOException;
import java.lang.annotation.Annotation;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Response;

public class ErrorHandling  {

    private static final String TAG = "ErrorHandling";

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

    public static void recognizeError(Response<?> response, Context context){
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
                Toast.makeText(context,error.getErrorDescription(),Toast.LENGTH_LONG).show();
            default:
                Log.w(TAG, "Default error running" );
                error = ErrorHandling.parseError(response);
                Toast.makeText(context,error.getErrorDescription(),Toast.LENGTH_LONG).show();
        }
    }
}
