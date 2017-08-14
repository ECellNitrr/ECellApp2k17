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
       SpeakerData data = new SpeakerData("Samveg Thaker","Test,test,test.","http://social-media-for-development.org/wp-content/uploads/2012/11/blogging.jpg");
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
