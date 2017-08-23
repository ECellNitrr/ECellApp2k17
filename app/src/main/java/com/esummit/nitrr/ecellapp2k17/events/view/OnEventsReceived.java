package com.esummit.nitrr.ecellapp2k17.events.view;

import com.esummit.nitrr.ecellapp2k17.events.model.data.EventsList;

/**
 * Created by samveg on 21/6/17.
 */

public interface OnEventsReceived {
    void onFailure();
    void onSuccess(EventsList eventsList);
}
