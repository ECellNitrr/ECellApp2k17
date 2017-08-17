package com.example.iket.ecellapp2k17.about_us.model.data;

/**
 * Created by vrihas on 6/23/2017.
 */

public class AboutUsData {
    String name;
    String linkedIn;
    String meta;


    public AboutUsData(String linkedIn, String meta, String name){

        this.linkedIn = linkedIn;

        this.name = name;
        this.meta = meta;
    }


    public String getLinkedIn() {
        return linkedIn;
    }

    public String getMeta() {
        return meta;
    }

    public String getName() {
        return name;
    }

}
