package com.example.iket.ecellapp2k17.about_us.presenter;

import com.example.iket.ecellapp2k17.about_us.model.TeamProvider;
import com.example.iket.ecellapp2k17.about_us.model.data.TeamData;
import com.example.iket.ecellapp2k17.about_us.model.data.TeamList;
import com.example.iket.ecellapp2k17.about_us.view.AboutUsInterface;
import com.example.iket.ecellapp2k17.about_us.view.OnAboutusReceived;

import java.util.List;

/**
 * Created by vrihas on 6/23/2017.
 */

public class AboutUsPresenterImpl implements AboutUsPresenter{

    private TeamProvider teamProvider;
    private AboutUsInterface aboutUsInterface;

    public AboutUsPresenterImpl(TeamProvider teamProvider, AboutUsInterface aboutUsInterface){
        this.teamProvider = teamProvider;
        this.aboutUsInterface = aboutUsInterface;
    }

    @Override
    public void requestData() {
        aboutUsInterface.showProgressBar(true);
        teamProvider.requestData(new OnAboutusReceived() {
            @Override
            public void onSuccess(TeamList teamList) {
                aboutUsInterface.showProgressBar(false);
                if(teamList.isSuccess())
                aboutUsInterface.setData(teamList.getTeam_members());
                else
                    aboutUsInterface.showMessage(teamList.getMessage());
            }

            @Override
            public void onFailure() {
                aboutUsInterface.showProgressBar(false);
                aboutUsInterface.showMessage("Please check your internet connection");
//                aboutUsInterface.checkNetwork();
            }
        });
    }
}
