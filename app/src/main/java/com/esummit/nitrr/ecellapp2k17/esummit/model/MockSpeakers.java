package com.esummit.nitrr.ecellapp2k17.esummit.model;

import com.esummit.nitrr.ecellapp2k17.esummit.model.data.SpeakerData;
import com.esummit.nitrr.ecellapp2k17.esummit.model.data.SpeakerList;
import com.esummit.nitrr.ecellapp2k17.esummit.view.OnSpeakersRecieved;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by samveg on 14/8/17.
 */

public class MockSpeakers implements EsummitProvider{
    @Override
    public void requestData(OnSpeakersRecieved onSpeakersRecieved) {
        List<SpeakerData> speakerDataList=new ArrayList<>();
       SpeakerData data = new SpeakerData("Sundar Pichai","Pichai is the chief executive officer (CEO) of Google Inc.Formerly the Product Chief of Google, Pichai's current role was announced on 10 August 2015, as part of the restructuring process that made Alphabet Inc. into Google's parent company, and he assumed the position on 2 October 2015.","https://i.ytimg.com/vi/p9LmpNH_cXM/maxresdefault.jpg","2016");
        speakerDataList.add(data);
        speakerDataList.add(data);
        speakerDataList.add(data);
        speakerDataList.add(data);
        speakerDataList.add(data);
        speakerDataList.add(data);
        speakerDataList.add(data);

        SpeakerList speakerList=new SpeakerList(speakerDataList,true,"sfsd");
        onSpeakersRecieved.onSuccess(speakerList);

    }
}
