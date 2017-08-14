package com.example.iket.ecellapp2k17.esummit.model;

import com.example.iket.ecellapp2k17.esummit.model.data.SpeakerData;
import com.example.iket.ecellapp2k17.esummit.view.OnSpeakersRecieved;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by samveg on 14/8/17.
 */

public class MockSpeakers implements EsummitProvider{
    @Override
    public void requestData(OnSpeakersRecieved onSpeakersRecieved) {
        List<SpeakerData> speakerDataList=new ArrayList<>();
       SpeakerData data = new SpeakerData("Samveg Thaker","Test,test,test.","https://scontent-bom1-1.xx.fbcdn.net/v/t1.0-9/14199330_589530031219744_1227788087780498651_n.jpg?oh=b2d79911108330201dc3f83488cbdbe3&oe=59F40693");
        speakerDataList.add(data);
        speakerDataList.add(data);
        speakerDataList.add(data);
        speakerDataList.add(data);
        speakerDataList.add(data);
        speakerDataList.add(data);
        speakerDataList.add(data);

        onSpeakersRecieved.onSuccess(speakerDataList);

    }
}
