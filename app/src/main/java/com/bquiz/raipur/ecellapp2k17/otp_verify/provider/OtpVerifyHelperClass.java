package com.bquiz.raipur.ecellapp2k17.otp_verify.provider;

import com.bquiz.raipur.ecellapp2k17.otp_verify.OtpVerificationCallback;

/**
 * Created by samveg on 30/7/17.
 */

public interface OtpVerifyHelperClass {

    void getOtpResponse(String otp, String mobile, String access_token, OtpVerificationCallback otpVerificationCallback);
    void onDestroy();
}
