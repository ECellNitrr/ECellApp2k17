package com.example.iket.ecellapp2k17.about_us.view;

import com.example.iket.ecellapp2k17.about_us.model.data.TeamData;

import java.util.List;

/**
 * Created by vrihas on 6/23/2017.
 */

public interface AboutUsInterface {

    void setData(List<TeamData> teamDataList);
    void showMessage(String message);
    void ShowProgressBar(boolean show);

}
