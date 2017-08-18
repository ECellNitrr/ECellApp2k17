package com.example.iket.ecellapp2k17.about_us.model;

import com.example.iket.ecellapp2k17.about_us.view.OnAboutusReceived;

/**
 * Created by vrihas on 6/23/2017.
 */

public interface TeamProvider {
    void requestData(OnAboutusReceived onAboutusReceived);
}
