package com.esummit.nitrr.ecellapp2k17.otp_verify.model;

/**
 * Created by samveg on 30/7/17.
 */

public class OtpData {

    private String message;
    private boolean success;
    public OtpData(String message, boolean success)
    {
        this.message=message;
        this.success=success;
    }

    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return success;
    }
}
