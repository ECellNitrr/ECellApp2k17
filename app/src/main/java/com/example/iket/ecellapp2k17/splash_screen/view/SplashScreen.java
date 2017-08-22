package com.example.iket.ecellapp2k17.splash_screen.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.iket.ecellapp2k17.BuildConfig;
import com.example.iket.ecellapp2k17.helper.MyApplication;
import com.example.iket.ecellapp2k17.helper.SharedPrefs;
import com.example.iket.ecellapp2k17.home.Home;
import com.example.iket.ecellapp2k17.R;
import com.example.iket.ecellapp2k17.login.view.LoginActivity;
import com.example.iket.ecellapp2k17.splash_screen.model.RetrofitSplashScreenProvider;
import com.example.iket.ecellapp2k17.splash_screen.model.data.SplashScreenData;
import com.example.iket.ecellapp2k17.splash_screen.presenter.SplashScreenPresenter;
import com.example.iket.ecellapp2k17.splash_screen.presenter.SplashScreenPresenterImpl;

public class SplashScreen extends Activity {

    SharedPrefs sharedPrefs;
    MyApplication myApplication;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        sharedPrefs = new SharedPrefs(this);
    //    SplashScreenPresenter splashScreenPresenter = new SplashScreenPresenterImpl(this, new RetrofitSplashScreenProvider());
    //    splashScreenPresenter.insertFcm(MyApplication.fcm_token,sharedPrefs.getAccessToken());

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
/*

    @Override
    public void showMessage(String message) {
        Toast.makeText(SplashScreen.this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void fcmInsertStatus(SplashScreenData splashScreenData) {

        float i = splashScreenData.getVersion();

        if (i > BuildConfig.VERSION_CODE) {
            final Dialog dialog = new Dialog(SplashScreen.this);
            dialog.setContentView(R.layout.activity_rules__dialog_box);
            Button btn = (Button) dialog.findViewById(R.id.dialog_button);
            progressBar = (ProgressBar) dialog.findViewById(R.id.progress_bar_dialog);
            TextView rules = (TextView) dialog.findViewById(R.id.rules5);
            */
/*
            if (splashScreenData.getCompulsory_update() == 1) {
                rules.setText("We've found some major improvements in our app . To enjoy ECellApp Please Update it");
                dialog.setCancelable(false);
            }*//*

            */
/*else {
                rules.setText("Please Update the app for Better experience");
                dialog.setCancelable(false);
            }
            *//*

            rules.setText("Please Update the app for Better experience");
            dialog.setCancelable(false);
            dialog.setTitle("App Update");
            btn.setText("Update");
            dialog.show();
            btn.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    final String appPackageName = getPackageName(); // getPackageName() from Context or Activity object
                    try {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
                    } catch (android.content.ActivityNotFoundException anfe) {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
                    }
                }
            });
        }
        else if (splashScreenData.isSuccess()) {
            sharedPrefs.setFCM(MyApplication.fcm_token);
            if (sharedPrefs.isLoggedIn()) {
                Intent in = new Intent(SplashScreen.this, Home.class);
                startActivity(in);
                finish();
            } else {
                Intent signIn = new Intent(SplashScreen.this, LoginActivity.class);
                startActivity(signIn);
                finish();
            }

        }
    }

    @Override
    public void showProgressBar(boolean show) {
        if (show) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
        }
    }
*/

}


