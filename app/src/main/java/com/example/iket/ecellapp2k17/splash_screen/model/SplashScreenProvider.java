package com.example.iket.ecellapp2k17.splash_screen.model;

import com.example.iket.ecellapp2k17.splash_screen.model.data.SplashScreenData;

import rx.Observable;

/**
 * Created by vrihas on 20/8/17.
 */

public interface SplashScreenProvider {
    Observable<SplashScreenData> insertFcm(String fcm,String access_token);
}
