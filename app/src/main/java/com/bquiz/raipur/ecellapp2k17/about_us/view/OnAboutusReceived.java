package com.bquiz.raipur.ecellapp2k17.about_us.view;

import com.bquiz.raipur.ecellapp2k17.about_us.model.data.TeamList;

/**
 * Created by lenovo on 6/23/2017.
 */

public interface OnAboutusReceived {

    void onSuccess(TeamList teamList);
    void onFailure();
}
