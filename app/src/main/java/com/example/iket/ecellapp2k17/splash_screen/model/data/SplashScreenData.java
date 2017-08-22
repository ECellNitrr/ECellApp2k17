package com.example.iket.ecellapp2k17.splash_screen.model.data;

/**
 * Created by vrihas on 20/8/17.
 */

public class SplashScreenData {

    private boolean success;
    private String message;
    private float version;
//    private int compulsory_update;

    public SplashScreenData(boolean success, String message, float version/*, int compulsory_update*/) {
        this.success = success;
        this.message = message;
        this.version = version;
        /*this.compulsory_update = compulsory_update;*/
    }
//
//    public int getCompulsory_update() {
//        return compulsory_update;
//    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public float getVersion() {
        return version;
    }
}
