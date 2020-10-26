package com.engin.eticaretkontrol.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.engin.eticaretkontrol.ConfigData;
import com.engin.eticaretkontrol.ErrorHandling;
import com.engin.eticaretkontrol.NetProgress.ApiInitialize;
import com.engin.eticaretkontrol.NetProgress.Interfaces.TokenDao;
import com.engin.eticaretkontrol.NetProgress.Models.Token;
import com.engin.eticaretkontrol.R;

import java.util.Calendar;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashActivity extends AppCompatActivity {
    private static final String TAG = "SplashActivity";
    SharedPreferences preferences;
    ImageView logoIV;
    TextView titleTV;
    Animation logoAnimation,textAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        logoIV = findViewById(R.id.logoSplash);
        titleTV = findViewById(R.id.titleSplash);
        // runAnimation
        runAnimation();
        // Getting refresh token from SharedPreferences
        preferences = getSharedPreferences("Tokens",MODE_PRIVATE);
        String refresh_token = preferences.getString("refresh_token","NONE");
        // Getting last login date and if SharedPreference hasn't got
        Date date = new Date();
        long lastLogin=preferences.getLong("LastLogin",date.getTime());
        // adding six hours to last login
        Calendar cal = Calendar.getInstance();
        Date lastLoginDate = new Date(lastLogin);
        cal.setTime(lastLoginDate);
        cal.add(Calendar.HOUR, +6);
        lastLoginDate =cal.getTime();
        // compare last login + 6  and current date
        if(date.after(lastLoginDate)){
            // Refreshing Token because of Access Token Invalid
            Log.w(TAG, "Access token invalid refreshing Token" );
            TokenDao tokenDao = ApiInitialize.getTokenDao();
            tokenDao.getATwRefreshT(ConfigData.REFRESH_GRANT_TYPE,ConfigData.CLIENT_ID,ConfigData.CLIENT_SECRET,refresh_token).enqueue(new Callback<Token>() {
                @Override
                public void onResponse(Call<Token> call, Response<Token> response) {
                    //Checking whether response is successful or failed
                    if (response.isSuccessful() && response.body() !=null){
                        Log.w(TAG, "Response is successful refreshing token" );
                        Token.saveTokens(response.body(),preferences);
                        Log.w(TAG, "Token refreshing Successfully" );
                    }
                    // error handling and Making toast message
                    else{
                        Log.w(TAG, "Response is failed Error Handling running..." );
                       ErrorHandling.recognizeError(response,SplashActivity.this,preferences);
                    }
                }
                @Override
                public void onFailure(Call<Token> call, Throwable t) {
                    Log.w(TAG, "Request failed ",t);
                    Toast.makeText(SplashActivity.this,t.toString(),Toast.LENGTH_LONG).show();
                }
            });
        }
        else{
            Log.i(TAG, "Access token already active");
        }
        // Threading
        new SplashThread().start();

    }

    private void runAnimation() {
        logoAnimation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.splash_screen_logo);
        logoIV.startAnimation(logoAnimation);
        textAnimation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.splash_screen_text);
        titleTV.startAnimation(textAnimation);
    }

    class SplashThread extends Thread   {
        @Override
        public void run() {
            try {
                Thread.sleep(3000);
                Intent intent = new Intent(SplashActivity.this,MainActivity.class);
                startActivity(intent);
                //transation
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                finish();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}