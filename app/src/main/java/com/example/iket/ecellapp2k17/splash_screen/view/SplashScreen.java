package com.example.iket.ecellapp2k17.splash_screen.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.iket.ecellapp2k17.helper.SharedPrefs;
import com.example.iket.ecellapp2k17.home.Home;
import com.example.iket.ecellapp2k17.R;
import com.example.iket.ecellapp2k17.login.view.LoginActivity;

public class SplashScreen extends Activity {

    SharedPrefs sharedPrefs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        sharedPrefs = new SharedPrefs(this);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
               if(sharedPrefs.isLoggedIn()){
                    Intent intent = new Intent(SplashScreen.this,Home.class);
                    startActivity(intent);
                   finish();
                }
                else{
                   Intent intent = new Intent(SplashScreen.this,LoginActivity.class);
                   startActivity(intent);
                   finish();
               }
                finish();
            }
        },2500);

    }
}


