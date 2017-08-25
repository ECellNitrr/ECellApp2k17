package com.bquiz.raipur.ecellapp2k17.esummit.view;

import com.bquiz.raipur.ecellapp2k17.esummit.model.data.SpeakerList;

/**
 * Created by samveg on 14/8/17.
 */

public interface OnSpeakersRecieved {
    void onSuccess(SpeakerList speakerList);
    void onFailure();
}
