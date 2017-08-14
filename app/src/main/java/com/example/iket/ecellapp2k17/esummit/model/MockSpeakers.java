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
       SpeakerData data = new SpeakerData("Samveg Thaker","Test,test,test.","https://scontent-bom1-1.xx.fbcdn.net/v/t1.0-9/17200942_1288060997949315_9092226983798702660_n.jpg?oh=05a8f8f1689abfa0b16c8f3d4f4845bb&oe=5A2BE053");
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
