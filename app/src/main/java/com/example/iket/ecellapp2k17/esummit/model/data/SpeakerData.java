package com.example.iket.ecellapp2k17.esummit.model.data;

/**
 * Created by iket on 14/8/17.
 */

public class SpeakerData {

    String name;
    String description;
    String image;
    String year;

    public SpeakerData(String name, String description, String image , String year){
        this.name =name;
        this.description = description;
        this.image = image;
        this.year = year;
    }
    public String getName(){return name;}
    public String getDescription(){return description;}
    public String getImage(){return image;}
    public String getYear(){return year;}
}
