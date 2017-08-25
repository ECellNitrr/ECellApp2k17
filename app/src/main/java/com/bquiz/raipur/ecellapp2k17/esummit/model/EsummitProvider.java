package com.bquiz.raipur.ecellapp2k17.esummit.model;

import com.bquiz.raipur.ecellapp2k17.esummit.view.OnSpeakersRecieved;

/**
 * Created by iket on 14/8/17.
 */

public interface EsummitProvider {

    void requestData(OnSpeakersRecieved onSpeakersRecieved);
}
