package com.esummit.nitrr.ecellapp2k17.otp_verify.presenter;

/**
 * Created by samveg on 30/7/17.
 */

public interface OtpVerifyPresenter {

    void otpData(String otp, String mobile, String access_token);
    void onDestroy();
}
