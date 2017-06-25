package com.example.iket.ecellapp2k17.about_us.model.data;

/**
 * Created by vrihas on 6/23/2017.
 */

public class AboutUsData {
    String aboutUsTitle;
    String aboutUsBody;

    public AboutUsData(String aboutUsTitle, String aboutUsBody){
        this.aboutUsTitle = aboutUsTitle;
        this.aboutUsBody = aboutUsBody;
    }

    public String getAboutUsTitle(){
        return aboutUsTitle;
    }
    public String getAboutUsBody(){
        return aboutUsBody;
    }
}
