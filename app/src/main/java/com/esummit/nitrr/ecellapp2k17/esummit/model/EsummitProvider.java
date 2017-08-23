package com.esummit.nitrr.ecellapp2k17.esummit.model;

import com.esummit.nitrr.ecellapp2k17.esummit.view.OnSpeakersRecieved;

/**
 * Created by iket on 14/8/17.
 */

public interface EsummitProvider {

    void requestData(OnSpeakersRecieved onSpeakersRecieved);
}
