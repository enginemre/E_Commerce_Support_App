package com.engin.eticaretkontrol.Activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.engin.eticaretkontrol.ConfigData;
import com.engin.eticaretkontrol.ErrorHandling;
import com.engin.eticaretkontrol.NetProgress.ApiInitialize;
import com.engin.eticaretkontrol.NetProgress.Interfaces.TokenDao;
import com.engin.eticaretkontrol.NetProgress.Models.Token;
import com.engin.eticaretkontrol.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    static final String TAG = "MainActivityTokenProgress";
    SharedPreferences preferences;
    Animation left2right,right2left;
    CardView orderListCV,storeListCV;
    TextView appTitleTV,messsageTV;
    ImageView logoIV;
    @SuppressLint("CommitPrefEdits")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initVariable();
        // Blocking New token request in onResume and  Sending requests for get Authentication
        if(preferences.getBoolean("Control",true)){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://hakmarmagazacilik.myideasoft.com/admin/user/auth"+"?client_id="+ConfigData.CLIENT_ID +"&response_type="+ConfigData.RESPONSE_TYPE+"&state="+ConfigData.STATE+"&redirect_uri=" + ConfigData.REDIRECT_URI));
            startActivity(intent);
            Log.i(TAG, " Request is sent");
            preferences.edit().putBoolean("Control",false).apply();
        }
        Toast.makeText(this,preferences.getString("access_token","NONE"),Toast.LENGTH_SHORT).show();
        orderListCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, OrdersTabActivity.class));
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
            }
        });
    }

    public void initVariable(){
        logoIV = findViewById(R.id.circle_logo);
        appTitleTV = findViewById(R.id.appTitle);
        messsageTV = findViewById(R.id.welcomeMessage);
        orderListCV = findViewById(R.id.orderListCV);
        storeListCV = findViewById(R.id.storeListCV);
        left2right = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.left2right);
        right2left = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.right2left);
        logoIV.startAnimation(right2left);
        storeListCV.startAnimation(right2left);
        orderListCV.startAnimation(left2right);
        messsageTV.startAnimation(left2right);
        appTitleTV.startAnimation(left2right);
        // Creating SharedPreferences for Access Token in Storage.
        preferences = getSharedPreferences("Tokens",MODE_PRIVATE);
        // Blocking New token request in onResume
        preferences.edit().putBoolean("ControlOnResume",true).apply();
    }

    @Override
    protected void onResume() {
        super.onResume();
        // getting and parsing Uri
        Uri uri = getIntent().getData();
        if (uri != null && uri.toString().startsWith(ConfigData.REDIRECT_URI)  && preferences.getBoolean("ControlOnResume",true)) {
            Log.i(TAG, "Uri is received");
            String code = uri.getQueryParameter("code");
            Log.w(TAG, "Code is received :"+code );
            TokenDao tokenDao = ApiInitialize.getTokenDao();
            // Sending requests for Token with code which parsed and separated uri
            tokenDao.getAT(ConfigData.GRANT_TYPE,ConfigData.CLIENT_ID,ConfigData.CLIENT_SECRET,code,ConfigData.REDIRECT_URI).enqueue(new Callback<Token>() {
                @Override
                public void onResponse(Call<Token> call, Response<Token> response) {
                    // Getting and writing access and refresh token...
                    if (response.isSuccessful() && response.body()!=null){
                        Log.w(TAG, "Response is Successful, processing ");
                        Token.saveTokens(response.body(),preferences);
                        Log.i(TAG, "Access Token : "+response.body().getAccessToken()+"Response Token : "+response.body().getRefreshToken());
                        Log.i(TAG, "Processes is Successful");
                    }
                    else{
                        ErrorHandling.recognizeError(response,MainActivity.this);
                        Log.e(TAG, "onResponse: Process is Failed" );

                    }
                }

                @Override
                public void onFailure(Call<Token> call, Throwable t) {
                    Toast.makeText(MainActivity.this,"Authentication Failed",Toast.LENGTH_LONG).show();
                }
            });


        }

    }


}