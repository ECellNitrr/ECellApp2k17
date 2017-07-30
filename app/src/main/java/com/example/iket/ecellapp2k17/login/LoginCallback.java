package com.example.iket.ecellapp2k17.login;

import com.example.iket.ecellapp2k17.login.model.LoginDataResponse;

/**
 * Created by samveg on 30/7/17.
 */

public interface LoginCallback {

    void onLoginSuccess(LoginDataResponse loginResponse);
    void onLoginFailure(String error);
}
