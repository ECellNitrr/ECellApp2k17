package com.example.iket.ecellapp2k17.about_us.model;

import com.example.iket.ecellapp2k17.about_us.view.ContactUsCallback;

/**
 * Created by vrihas on 14/8/17.
 */

public interface ContactUsProvider {
    void contactUsResponse(String name, String email, String body, ContactUsCallback contactUsCallback);
}
