package com.example.iket.ecellapp2k17.events.model;

import com.example.iket.ecellapp2k17.events.model.data.EventsData;
import com.example.iket.ecellapp2k17.events.view.OnEventsReceived;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by iket on 3/8/17.
 */

public class MockData implements EventsProvider{
    @Override
    public void requestEvents(OnEventsReceived onEventsReceived) {
        List<EventsData> list=new ArrayList<>();
        EventsData data=new EventsData("E-Summit","9th September","8:00 pm","E-Hall","Esummit is the event","http://ecellnsit.com/blog/wp-content/uploads/2016/03/esummit.jpg");
        list.add(data);
        EventsData data1 = new EventsData("B Quiz","9th September","9:00 am","E-hall","It is a quiz compeition","http://ecellnsit.com/blog/wp-content/uploads/2016/03/esummit.jpg");
        list.add(data1);
        list.add(data);
        list.add(data);
        onEventsReceived.onSuccess(list);
    }
}
