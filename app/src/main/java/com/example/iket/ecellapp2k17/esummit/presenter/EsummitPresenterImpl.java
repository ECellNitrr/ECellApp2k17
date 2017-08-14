package com.example.iket.ecellapp2k17.esummit.presenter;

import com.example.iket.ecellapp2k17.esummit.model.EsummitProvider;
import com.example.iket.ecellapp2k17.esummit.model.data.SpeakerData;
import com.example.iket.ecellapp2k17.esummit.view.OnSpeakersRecieved;
import com.example.iket.ecellapp2k17.esummit.view.ViewInterface;

import java.util.List;

/**
 * Created by samveg on 14/8/17.
 */

public class EsummitPresenterImpl implements EsummitPresenter{
    private ViewInterface viewInterface;
    private EsummitProvider esummitProvider;

    public EsummitPresenterImpl(EsummitProvider esummitProvider,ViewInterface viewInterface){
        this.esummitProvider=esummitProvider;
        this.viewInterface=viewInterface;
    }

    @Override
    public void requestData() {
        esummitProvider.requestData(new OnSpeakersRecieved() {
            @Override
            public void onSuccess(List<SpeakerData> speakerDataList) {
                viewInterface.setData(speakerDataList);
            }

            @Override
            public void onFailure() {

            }
        } );
    }
}
