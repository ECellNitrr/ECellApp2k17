package com.bquiz.raipur.ecellapp2k17.otp_verify.presenter;

import com.bquiz.raipur.ecellapp2k17.otp_verify.OtpVerificationCallback;
import com.bquiz.raipur.ecellapp2k17.otp_verify.model.OtpData;
import com.bquiz.raipur.ecellapp2k17.otp_verify.provider.OtpVerifyHelperClass;
import com.bquiz.raipur.ecellapp2k17.otp_verify.view.OtpView;

/**
 * Created by samveg on 30/7/17.
 */

public class OtpVerifyPresenterImp implements OtpVerifyPresenter{

    private OtpView otpView;
    private OtpVerifyHelperClass otpVerifyHelperClass;

    public OtpVerifyPresenterImp(OtpView otpView, OtpVerifyHelperClass otpVerifyHelperClass) {
        this.otpView = otpView;
        this.otpVerifyHelperClass = otpVerifyHelperClass;
    }

    @Override
    public void otpData(final String otp, String mobile, String access_token) {
        otpView.showProgressBar(true);
        otpVerifyHelperClass.getOtpResponse(otp, mobile,access_token,new OtpVerificationCallback() {
            @Override
            public void onOtpVerified(OtpData otpData) {

                if (otpData.isSuccess()) {
                    otpView.OtpStatus(otpData);

                } else {
                    otpView.showMessage(otpData.getMessage());
                    otpView.verify_bttn_clickable();
                }
                otpView.showProgressBar(false);
            }

            @Override
            public void onFailure(String error) {
                otpView.showProgressBar(false);
                otpView.showMessage("Sorry!!Something went wrong");
                otpView.checkNetwork();
            }
        });

    }

    @Override
    public void onDestroy() {
        if(otpVerifyHelperClass!=null){
            otpVerifyHelperClass.onDestroy();
        }
    }
}
