package com.example.iket.ecellapp2k17.about_us.presenter;

import com.example.iket.ecellapp2k17.about_us.model.AboutUsProvider;
import com.example.iket.ecellapp2k17.about_us.model.data.AboutUsData;
import com.example.iket.ecellapp2k17.about_us.view.AboutUsInterface;
import com.example.iket.ecellapp2k17.about_us.view.OnAboutusReceived;

import java.util.List;

/**
 * Created by vrihas on 6/23/2017.
 */

public class AboutUsPresenterImpl implements AboutUsPresenter{

    private AboutUsProvider aboutUsProvider;
    private AboutUsInterface aboutUsInterface;

    public AboutUsPresenterImpl(AboutUsProvider aboutUsProvider,AboutUsInterface aboutUsInterface){
        this.aboutUsProvider = aboutUsProvider;
        this.aboutUsInterface = aboutUsInterface;
    }

    @Override
    public void requestData() {
        aboutUsProvider.requestData(new OnAboutusReceived() {
            @Override
            public void onSuccess(List<AboutUsData> aboutUsDataList) {
                aboutUsInterface.setData(aboutUsDataList);
            }

            @Override
            public void onFailure() {

            }
        });
    }
}
