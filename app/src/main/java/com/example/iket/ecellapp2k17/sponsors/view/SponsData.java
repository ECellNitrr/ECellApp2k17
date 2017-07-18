package com.example.iket.ecellapp2k17.sponsors.view;

/**
 * Created by samveg on 23/6/17.
 */

public class SponsData {

    private String image1;
    private int id;
    private String sTitle;


    public SponsData(String image1, String sTitle) {
        this.image1 = image1;
        this.sTitle = sTitle;
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

}
