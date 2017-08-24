package com.bquiz.raipur.ecellapp2k17.about_us.view;

import com.bquiz.raipur.ecellapp2k17.about_us.model.data.ContactUsData;

/**
 * Created by vrihas on 14/8/17.
 */

public interface ContactUsCallback {
    void onMessageSuccess(ContactUsData contactUsData);
    void onMessageFailure(String error);
}
