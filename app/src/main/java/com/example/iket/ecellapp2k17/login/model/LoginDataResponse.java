package com.example.iket.ecellapp2k17.login.model;

/**
 * Created by samveg on 30/7/17.
 */

public class LoginDataResponse {

    private boolean success;
    private String message;
    public LoginDataResponse(boolean success, String message)
    {
        this.message=message;
        this.success=success;
    }


    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
