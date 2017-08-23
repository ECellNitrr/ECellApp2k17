package com.example.iket.ecellapp2k17.BQuizNew.presenter;


import com.example.iket.ecellapp2k17.BQuizNew.OnBQuizDataResponse;
import com.example.iket.ecellapp2k17.BQuizNew.model.BQuizProvider;
import com.example.iket.ecellapp2k17.BQuizNew.model.data.BQuizData;
import com.example.iket.ecellapp2k17.BQuizNew.view.BQuizView;


public class BQuizPresenterImpl implements BQuizPresenter {

    BQuizView bQuizView;
    BQuizProvider bQuizProvider;

    public BQuizPresenterImpl(BQuizView bQuizView, BQuizProvider bQuizProvider) {
        this.bQuizView = bQuizView;
        this.bQuizProvider = bQuizProvider;
    }

    @Override
    public void getBquizData(String adminToken) {

        bQuizView.showProgressbar(true);
        bQuizProvider.requestBquizData(adminToken, new OnBQuizDataResponse() {
            @Override
            public void onSuccess(BQuizData bQuizData) {

                if (bQuizData.isSuccess()) {
                    bQuizView.showProgressbar(false);
                    bQuizView.setBquizData(bQuizData);
                }else{
                    bQuizView.showProgressbar(false);
                    bQuizView.showMessage(bQuizData.getMessage());
                }
            }

            @Override
            public void onFailure() {
                bQuizView.showProgressbar(false);
            }
        });

    }

    @Override
    public void cancelCall() {
        bQuizProvider.cancelCall();
    }
}
