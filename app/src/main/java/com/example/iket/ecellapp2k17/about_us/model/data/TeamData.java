package com.example.iket.ecellapp2k17.about_us.model.data;

/**
 * Created by vrihas on 6/23/2017.
 */

public class TeamData {
    String name;
    String linkedIn;
    String meta;
    String position;

    public TeamData(String linkedIn, String meta, String name, String position){

        this.linkedIn = linkedIn;
        this.position = position;
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

    public String getPosition(){
        return position;
    }

}
