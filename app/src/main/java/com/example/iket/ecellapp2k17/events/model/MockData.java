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
        EventsData data=new EventsData("Experts Lecture Series","9th September","8:00 pm","E-Hall","Esummit is the event","https://i2.wp.com/www.hypnotherapyillinois.com/wp-content/uploads/2015/11/hypnosis-training-chicago.jpg?w=500");
        list.add(data);
        EventsData data1 = new EventsData("Cricnometrica","9th September","9:00 am","E-hall","It is a quiz compeition","http://www.kidslitquiz.com/images/general/650/051.jpg");
        list.add(data1);
        list.add(data);
        list.add(data1);
        list.add(data);
        onEventsReceived.onSuccess(list);
    }
}
