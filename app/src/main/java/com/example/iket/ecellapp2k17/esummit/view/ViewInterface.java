package com.example.iket.ecellapp2k17.esummit.view;

import com.example.iket.ecellapp2k17.esummit.model.data.SpeakerData;

import java.util.List;

/**
 * Created by iket on 14/8/17.
 */

public interface ViewInterface {


    void setData(List<SpeakerData> speakerDataList);
    void showMessage(String message);
    void ShowProgressBar(boolean show);
}
