package com.example.iket.ecellapp2k17.about_us.presenter;

import com.example.iket.ecellapp2k17.about_us.model.ContactUsProvider;
import com.example.iket.ecellapp2k17.about_us.model.data.ContactUsData;
import com.example.iket.ecellapp2k17.about_us.view.ContactUsCallback;
import com.example.iket.ecellapp2k17.about_us.view.ContactUsView;

/**
 * Created by vrihas on 14/8/17.
 */

public class ContactUsPresenterImpl implements ContactUsPresenter {

    private ContactUsProvider contactUsProvider;
    private ContactUsView contactUsView;

    public ContactUsPresenterImpl(ContactUsView contactUsView, ContactUsProvider contactUsProvider){
        this.contactUsView = contactUsView;
        this.contactUsProvider = contactUsProvider;
    }

    @Override
    public void getContactData(String name, String email, String body) {
        contactUsView.showProgressBar(true);
        contactUsProvider.contactUsResponse(name, email, body, new ContactUsCallback() {
            @Override
            public void onMessageSuccess(ContactUsData contactUsData) {
                if (contactUsData.isSuccess()){
                    contactUsView.showProgressBar(false);
                    contactUsView.showStatus(true);
                }
            }

            @Override
            public void onMessageFailure(String error) {
                contactUsView.showError("Sorry! Something went wrong");
                contactUsView.showProgressBar(false);
                contactUsView.showStatus(false);
//                contactUsView.checkNetwork();

            }
        });
    }
}
