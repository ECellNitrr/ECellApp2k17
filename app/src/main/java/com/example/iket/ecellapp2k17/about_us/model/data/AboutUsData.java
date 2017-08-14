package com.example.iket.ecellapp2k17.about_us.model.data;

/**
 * Created by vrihas on 6/23/2017.
 */

public class AboutUsData {
    String member_name;
    String member_email;
    String member_img_url;


    public AboutUsData(String member_email, String member_img_url,String member_name){

        this.member_email=member_email;

        this.member_name=member_name;
        this.member_img_url=member_img_url;
    }


    public String getMember_email() {
        return member_email;
    }

    public String getMember_img_url() {
        return member_img_url;
    }

    public String getMember_name() {
        return member_name;
    }

}
