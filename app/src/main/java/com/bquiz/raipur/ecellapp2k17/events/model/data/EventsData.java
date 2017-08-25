package com.bquiz.raipur.ecellapp2k17.events.model.data;

/**
 * Created by samveg on 21/6/17.
 */

public class EventsData {
    private String title,description,date,time,venue, meta,bg_image;
    
    public EventsData(String name, String date, String time, String venue, String description, String meta,String bg_image) {
        this.title =name;
        this.meta = meta;
        this.date=date;
        this.venue=venue;
        this.time=time;
        this.description=description;
        this.bg_image = bg_image;
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

    public String getMeta() {

        return meta;
    }
    public String getTime(){
        return time;
    }

    public String getBg_image(){return bg_image;}

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
        return title;
    }



    public void setEventName(String name) {
        this.title = name;
    }
    public void setBg_image(String bg_image){this.bg_image=bg_image;}
}
