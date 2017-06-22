package com.example.iket.ecellapp2k17.events.view;

import java.util.List;

/**
 * Created by samveg on 21/6/17.
 */

public interface OnEventsReceived {
    void onFailure();
    void onSuccess(List<EventsData> eventDataList);
}
