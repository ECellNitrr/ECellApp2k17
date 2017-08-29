package com.bquiz.raipur.ecellapp2k17.bmodel.view;

import com.bquiz.raipur.ecellapp2k17.bmodel.model.data.MentorData;
import com.bquiz.raipur.ecellapp2k17.bmodel.model.data.MentorList;

import java.util.List;

/**
 * Created by samveg on 29/8/17.
 */

public interface BModelView {
    void setData(List<MentorData> mentorDataList);
    void showMessage(String message);
    void showProgressBar(boolean show);
    void showDefault(boolean show);
}
