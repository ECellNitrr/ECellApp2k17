package com.example.iket.ecellapp2k17.events.view;

import com.example.iket.ecellapp2k17.events.model.data.EventsData;
import com.example.iket.ecellapp2k17.events.model.data.EventsList;

import java.util.List;

/**
 * Created by samveg on 21/6/17.
 */

public interface OnEventsReceived {
    void onFailure();
    void onSuccess(EventsList eventsList);
}
