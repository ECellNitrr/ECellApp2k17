package com.example.iket.ecellapp2k17.login.model;

/**
 * Created by samveg on 30/7/17.
 */

public class LoginDataResponse {

    private boolean success;
    private String message,access_token;
    public LoginDataResponse(boolean success, String message, String access_token)
    {
        this.message=message;
        this.success=success;
        this.access_token = access_token;
    }


    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
    public String getAccess_token(){
        return access_token;
    }
}
