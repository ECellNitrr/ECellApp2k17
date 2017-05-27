package com.example.iket.ecellapp2k17.splash_screen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.iket.ecellapp2k17.home.view.Home;
import com.example.iket.ecellapp2k17.R;
import com.example.iket.ecellapp2k17.fb.fb_login;
import com.facebook.AccessToken;

public class SplashScreen extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                updateWithToken(AccessToken.getCurrentAccessToken());
                finish();
            }
        },3000);

    }

    private void updateWithToken(AccessToken currentAccessToken) {

        if (currentAccessToken != null) {

                    Intent intent = new Intent(SplashScreen.this, Home.class);
                    startActivity(intent);
        }
        else {

                    Intent intent = new Intent(SplashScreen.this, fb_login.class);
                    startActivity(intent);
             }

        }

}


