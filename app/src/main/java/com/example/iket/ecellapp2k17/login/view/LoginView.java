package com.example.iket.ecellapp2k17.login.view;

import com.example.iket.ecellapp2k17.login.model.LoginDataResponse;

/**
 * Created by samveg on 30/7/17.
 */

public interface LoginView {

    void showProgressBar(boolean show);
    void showLoginStatus(LoginDataResponse loginDataResponse);
    void showError(String message);
    void checkNetwork();
}
