package com.example.iket.ecellapp2k17.events.model;

import com.example.iket.ecellapp2k17.events.view.OnEventsReceived;

/**
 * Created by samveg on 21/6/17.
 */

public interface EventsProvider {
    void requestEvents(OnEventsReceived onEventsReceived);
}
