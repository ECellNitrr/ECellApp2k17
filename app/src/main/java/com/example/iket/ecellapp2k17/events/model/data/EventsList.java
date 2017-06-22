package com.example.iket.ecellapp2k17.events.model.data;

import com.example.iket.ecellapp2k17.events.model.data.EventsData;

import java.util.List;

/**
 * Created by samveg on 21/6/17.
 */

public class EventsList {
    private List<EventsData> events;

    EventsList(List<EventsData> events) {
        this.events = events;
    }

    public List<EventsData> getEvents() {
        return events;
    }
}
