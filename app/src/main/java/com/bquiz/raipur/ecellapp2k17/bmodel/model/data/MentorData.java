package com.bquiz.raipur.ecellapp2k17.bmodel.model.data;

/**
 * Created by samveg on 29/8/17.
 */

public class MentorData {
    String name;
    String description;
    String image;

    public MentorData(String name, String description, String image){
        this.name =name;
        this.description = description;
        this.image = image;
    }
    public String getName(){return name;}
    public String getDescription(){return description;}
    public String getImage(){return image;}
}
