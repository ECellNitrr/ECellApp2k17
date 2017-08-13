package com.example.iket.ecellapp2k17.events.model.data;

/**
 * Created by samveg on 21/6/17.
 */

public class EventsData {
    private String name,description,date,time,venue,image;


    public EventsData(String name, String date, String time, String venue, String description, String image) {
        this.name =name;
        this.image=image;
        this.date=date;
        this.venue=venue;
        this.time=time;
        this.description=description;

    }
    public EventsData() {
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }


    public String getVenue() {
        return venue;
    }

    public String getImage() {

        return image;
    }
    public String getTime(){
        return time;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getEventName() {
        return name;
    }



    public void setEventName(String name) {
        this.name = name;
    }
}
