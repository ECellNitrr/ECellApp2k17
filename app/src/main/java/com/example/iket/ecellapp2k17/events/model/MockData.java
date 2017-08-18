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
        EventsData data=new EventsData("Experts Lecture Series","9th September","8:00 pm","E-Hall","Esummit is the event","https://ecell.nitrr.ac.in/uploads/events/1502908078.png");
        list.add(data);
        EventsData data1 = new EventsData("Cricnometrica","9th September","9:00 am","E-hall","Cricnometrica is an event designed to provide a stage for entertainment as well as a platform to showcase the individuals’ or teams’ knowledge of the game of cricket. A team game comprising of three rounds which range from pen paper to slide-shows and leads finally to virtual bidding to create a team of their own .The team with the maximum points at the end of the third round is declared as the winner.","https://ecell.nitrr.ac.in/uploads/events/1502908078.png");
        list.add(data1);
        list.add(data);
        list.add(data1);
        list.add(data);
        onEventsReceived.onSuccess(list);
    }
}
