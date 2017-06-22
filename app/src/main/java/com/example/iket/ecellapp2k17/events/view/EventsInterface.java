package com.example.iket.ecellapp2k17.events.view;

import java.util.List;

/**
 * Created by samveg on 22/6/17.
 */

public interface EventsInterface {
    void ShowProgressBar(boolean show);
    void SetData(List<EventsData> eventDataList);
    void showMessage(String message);
}
