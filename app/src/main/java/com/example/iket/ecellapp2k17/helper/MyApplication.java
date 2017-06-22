package com.example.iket.ecellapp2k17.helper;

import android.content.Context;

import com.facebook.FacebookSdk;

import static com.facebook.FacebookSdk.getApplicationContext;


/**
 * Created by vrihas on 6/21/2017.
 */

public class MyApplication {

    public static String fcm_token;
    private static Context context;
    /*
    @Override
    public void onCreate() {

        super.onCreate();
        context=this;
        Fabric.with(this, new Crashlytics());


        FacebookSdk.sdkInitialize(getApplicationContext());
        fcm_token = FirebaseInstanceId.getInstance().getToken();

    }
    */
    public static Context getContext() {
        return context;
    }
}
