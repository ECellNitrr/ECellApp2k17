package com.example.iket.ecellapp2k17.sponsors.view;

/**
 * Created by samveg on 23/6/17.
 */

public class SponsData {

    private String image1;
    private int id;
    private String sTitle,website_url;


    public SponsData(String image1, String sTitle,String website_url) {
        this.image1 = image1;
        this.sTitle = sTitle;
        this.website_url = website_url;
        this.id=id;
    }

    public int getId() {
        return id;
    }

    public String getsTitle(){
        return  sTitle;
    }

    public String getImage1() {
        return image1;
    }
    public String getWebsite_url(){
        return website_url;
    }



}
