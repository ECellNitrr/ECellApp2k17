package com.example.iket.ecellapp2k17.about_us.model.data;

/**
 * Created by vrihas on 6/23/2017.
 */

public class AboutUsData {
    String member_name;
    String member_contact;
    String member_email;
    String member_position;
    String member_img_url;
    String vision_body;

    public AboutUsData(String member_contact,String member_email, String member_img_url,String member_name,String member_position,String vision_body){
        this.member_contact=member_contact;
        this.member_email=member_email;
        this.member_position=member_position;
        this.member_name=member_name;
        this.member_img_url=member_img_url;
        this.vision_body=vision_body;
    }

    public String getMember_contact() {
        return member_contact;
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

    public String getMember_position() {
        return member_position;
    }
    public String getVisionBody(){ return vision_body;}
}
