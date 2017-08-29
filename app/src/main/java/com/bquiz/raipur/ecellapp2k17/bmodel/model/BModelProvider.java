package com.bquiz.raipur.ecellapp2k17.bmodel.model;

import com.bquiz.raipur.ecellapp2k17.bmodel.OnMentorsRecieved;

/**
 * Created by samveg on 29/8/17.
 */

public interface BModelProvider {

    void requestData(OnMentorsRecieved onMentorsRecieved);
}
