package com.example.iket.ecellapp2k17.esummit.presenter;

import com.example.iket.ecellapp2k17.esummit.model.EsummitProvider;
import com.example.iket.ecellapp2k17.esummit.model.data.SpeakerData;
import com.example.iket.ecellapp2k17.esummit.model.data.SpeakerList;
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
        viewInterface.showProgressBar(true);
        esummitProvider.requestData(new OnSpeakersRecieved() {
            @Override
            public void onSuccess(SpeakerList speakerList) {
                viewInterface.showProgressBar(false);
                if(speakerList.isSuccess()) {
                    viewInterface.setData(speakerList.getSpeakers());
                }
                else {
                    viewInterface.showDefault(true);
                    viewInterface.showMessage(speakerList.getMessage());
                }
            }

            @Override
            public void onFailure() {
                viewInterface.showProgressBar(false);
                viewInterface.showMessage("Internet not available");
                viewInterface.checkNetwork();
            }
        } );
    }
}
