package com.example.iket.ecellapp2k17.login.view;

/**
 * Created by samveg on 30/7/17.
 */

public interface LoginView {

    void showProgressBar(boolean show);
    void showLoginStatus(boolean login);
    void showError(String message);
}
