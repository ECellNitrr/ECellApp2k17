package com.bquiz.raipur.ecellapp2k17.splash_screen.api;

import com.bquiz.raipur.ecellapp2k17.helper.Urls;
import com.bquiz.raipur.ecellapp2k17.splash_screen.model.data.SplashScreenData;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by vrihas on 20/8/17.
 */

public interface SplashScreenRequestApi {
    @FormUrlEncoded
    @POST(Urls.REQUEST_SPLASH_SCREEN)
    Observable<SplashScreenData> insertFcm(@Field("fcm") String fcm, @Field("token") String access_token);

}
