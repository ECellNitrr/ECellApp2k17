package com.example.iket.ecellapp2k17.otp_verify.model;

/**
 * Created by samveg on 30/7/17.
 */

public class OtpData {

    private String message;
    private String access_token;
    private boolean success;
    public OtpData(String message, String access_token, boolean success)
    {
        this.message=message;
        this.success=success;

        this.access_token=access_token;
    }

    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return success;
    }



    public String getAccess_token() {
        return access_token;
    }
}
