package com.bquiz.raipur.ecellapp2k17.sponsors.model.data;

/**
 * Created by samveg on 23/6/17.
 */

public class SponsData {

    private String image1;
    private String sponsName,website,body;


    public SponsData(String image1, String sponsName, String website_url, String body) {
        this.image1 = image1;
        this.sponsName = sponsName;
        this.website = website_url;
        this.body = body;
    }

    public String getImage1() {
        return image1;
    }

    public String getSponsName() {
        return sponsName;
    }

    public String getWebsite_url() {
        return website;
    }

    public String getBody() {
        return body;
    }
}
