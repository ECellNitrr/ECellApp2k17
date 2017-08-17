package com.example.iket.ecellapp2k17.about_us.model.data;

import java.util.List;

/**
 * Created by vrihas on 6/23/2017.
 */

public class ResponseAboutUs {
    private List<AboutUsData> aboutus;
    private boolean success;
    private String message;

    public ResponseAboutUs(List<AboutUsData> aboutus) {
        this.aboutus = aboutus;
    }

    public List<AboutUsData> getAboutus(){
        return aboutus;
    }
}
