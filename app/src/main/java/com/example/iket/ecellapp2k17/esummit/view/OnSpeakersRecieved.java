package com.example.iket.ecellapp2k17.esummit.view;

import com.example.iket.ecellapp2k17.esummit.model.data.SpeakerData;
import com.example.iket.ecellapp2k17.esummit.model.data.SpeakerList;

import java.util.List;

/**
 * Created by samveg on 14/8/17.
 */

public interface OnSpeakersRecieved {
    void onSuccess(SpeakerList speakerList);
    void onFailure();
}
