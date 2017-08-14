package com.example.iket.ecellapp2k17.events.model.data;

import com.example.iket.ecellapp2k17.events.model.data.EventsData;

import java.util.List;

/**
 * Created by samveg on 21/6/17.
 */

public class EventsList {
    private List<EventsData> events;
    private String message;
    private boolean success;

    public EventsList(List<EventsData> events, String message, boolean success) {
        this.events = events;
        this.message = message;
        this.success = success;
    }

    public List<EventsData> getEvents() {
        return events;
    }

    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return success;
    }
}
