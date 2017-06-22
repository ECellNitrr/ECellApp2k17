package com.example.iket.ecellapp2k17.events.view;

import java.util.List;

/**
 * Created by samveg on 21/6/17.
 */

public class jsonResponse {
    private List<EventsData> events;

    jsonResponse(List<EventsData> events) {
        this.events = events;
    }

    public List<EventsData> getEvents() {
        return events;
    }
}
