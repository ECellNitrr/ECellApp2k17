package com.example.iket.ecellapp2k17.login.presenter;

import com.example.iket.ecellapp2k17.login.LoginCallback;
import com.example.iket.ecellapp2k17.login.model.LoginDataResponse;
import com.example.iket.ecellapp2k17.login.provider.LoginBaseClassHelper;
import com.example.iket.ecellapp2k17.login.view.LoginView;

/**
 * Created by samveg on 30/7/17.
 */

public class LoginDataImp implements LoginData {

    private LoginBaseClassHelper loginBaseClassHelper;
    private LoginView login;

    public LoginDataImp(LoginView login, LoginBaseClassHelper loginBaseClassHelper) {
        this.login = login;
        this.loginBaseClassHelper = loginBaseClassHelper;
    }


    @Override
    public void getLoginData(String mobile) {
        login.showProgressBar(true);
        loginBaseClassHelper.loginData(mobile,new LoginCallback() {
            @Override
            public void onLoginSuccess(LoginDataResponse loginResponse) {
                if(loginResponse.isSuccess()) {
                    login.showProgressBar(false);
                    login.showLoginStatus(true);
                }
            }

            @Override
            public void onLoginFailure(String error) {
                login.showError("Sorry!!Something went wrong");
                login.showLoginStatus(false);
                login.showProgressBar(false);
            }
        });
    }
}
