package com.esummit.nitrr.ecellapp2k17.events.view;

import com.esummit.nitrr.ecellapp2k17.events.model.data.EventsData;

import java.util.List;

/**
 * Created by samveg on 22/6/17.
 */

public interface EventsInterface {
    void SetData(List<EventsData> eventDataList);
    void showMessage(String message);
    void ShowProgressBar(boolean show);
    void showDefault(boolean show);
//    void checkNetwork();
}
