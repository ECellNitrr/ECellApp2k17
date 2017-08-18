package com.example.iket.ecellapp2k17.about_us.presenter;

import com.example.iket.ecellapp2k17.about_us.model.TeamProvider;
import com.example.iket.ecellapp2k17.about_us.model.data.TeamData;
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
        teamProvider.requestData(new OnAboutusReceived() {
            @Override
            public void onSuccess(List<TeamData> teamDataList) {
                aboutUsInterface.setData(teamDataList);
            }

            @Override
            public void onFailure() {

            }
        });
    }
}
