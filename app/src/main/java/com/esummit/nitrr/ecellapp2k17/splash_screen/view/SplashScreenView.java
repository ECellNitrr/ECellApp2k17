package com.esummit.nitrr.ecellapp2k17.splash_screen.view;

import com.esummit.nitrr.ecellapp2k17.splash_screen.model.data.SplashScreenData;

/**
 * Created by vrihas on 20/8/17.
 */

public interface SplashScreenView {

    void showMessage(String message);

    void fcmInsertStatus(SplashScreenData splashScreenData);

    void showProgressBar(boolean show);
}
