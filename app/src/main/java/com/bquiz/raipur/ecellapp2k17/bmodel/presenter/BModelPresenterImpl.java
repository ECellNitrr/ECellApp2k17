package com.bquiz.raipur.ecellapp2k17.bmodel.presenter;

import com.bquiz.raipur.ecellapp2k17.bmodel.OnMentorsRecieved;
import com.bquiz.raipur.ecellapp2k17.bmodel.model.BModelProvider;
import com.bquiz.raipur.ecellapp2k17.bmodel.model.data.MentorList;
import com.bquiz.raipur.ecellapp2k17.bmodel.view.BModelView;

/**
 * Created by samveg on 29/8/17.
 */

public class BModelPresenterImpl implements BModelPresenter{

    private BModelView bModelView;
    private BModelProvider bModelProvider;

    public BModelPresenterImpl(BModelView bModelView, BModelProvider bModelProvider) {
        this.bModelView = bModelView;
        this.bModelProvider = bModelProvider;
    }

    @Override
    public void requestData() {
        bModelView.showProgressBar(true);
        bModelProvider.requestData(new OnMentorsRecieved() {
            @Override
            public void onSuccess(MentorList mentorList) {
                bModelView.showProgressBar(false);
                if (mentorList.isSuccess()){
                    bModelView.setData(mentorList.getMentors());
                }else{
                    bModelView.showDefault(true);
                    bModelView.showMessage(mentorList.getMessage());
                }
            }

            @Override
            public void onFailure() {
                bModelView.showProgressBar(false);
                bModelView.showMessage("Internet not available");
            }
        });
    }
}
