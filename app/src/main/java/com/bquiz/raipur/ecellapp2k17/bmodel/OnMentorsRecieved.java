package com.bquiz.raipur.ecellapp2k17.bmodel;

import com.bquiz.raipur.ecellapp2k17.bmodel.model.data.MentorList;

/**
 * Created by samveg on 29/8/17.
 */

public interface OnMentorsRecieved {
    void onSuccess(MentorList mentorList);
    void onFailure();
}
