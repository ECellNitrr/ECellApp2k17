package com.example.iket.ecellapp2k17.sponsors.view;

/**
 * Created by samveg on 23/6/17.
 */

public class SponsData {

    private String image1,bg_spons;
    private int id;
    private String sTitle,spons_desc,spons_body,website_url;


    public SponsData(String image1, String sTitle, String bg_spons, String spons_desc, String spons_body,String website_url) {
        this.image1 = image1;
        this.sTitle = sTitle;
        this.bg_spons = bg_spons;
        this.spons_desc = spons_desc;
        this.spons_body = spons_body;
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
    public String getBg_spons(){
        return bg_spons;
    }
    public  String getSpons_desc(){
        return  spons_desc;
    }
    public  String getSpons_body(){
        return  spons_body;
    }
    public String getWebsite_url(){
        return website_url;
    }



}
