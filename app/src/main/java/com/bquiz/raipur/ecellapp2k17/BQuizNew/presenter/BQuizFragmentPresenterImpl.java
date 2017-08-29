package com.bquiz.raipur.ecellapp2k17.BQuizNew.presenter;

import android.widget.Toast;

import com.bquiz.raipur.ecellapp2k17.BQuizNew.OnBQuizStatusResponse;
import com.bquiz.raipur.ecellapp2k17.BQuizNew.model.BQuizStatusProvider;
import com.bquiz.raipur.ecellapp2k17.BQuizNew.model.data.BQuizStatus;
import com.bquiz.raipur.ecellapp2k17.BQuizNew.view.BQuizFragmentView;

/**
 * Created by samveg on 20/8/17.
 */

public class BQuizFragmentPresenterImpl implements BQuizFragmentPresenter{

    BQuizFragmentView bQuizFragmentView;
    BQuizStatusProvider bQuizStatusProvider;

    public BQuizFragmentPresenterImpl(BQuizFragmentView bQuizFragmentView, BQuizStatusProvider bQuizStatusProvider){

        this.bQuizFragmentView = bQuizFragmentView;
        this.bQuizStatusProvider=bQuizStatusProvider;
    }

    @Override
    public void getBquizStatus() {

       // bQuizFragmentView.showPlayButton(true);

        bQuizStatusProvider.requestBquizStatus( new OnBQuizStatusResponse() {
            @Override
            public void onSuccess(BQuizStatus bQuizStatus) {

                if (bQuizStatus.getSuccess())
                {
                    bQuizFragmentView.showPlayButton(true);
                }
                else
                {
                    bQuizFragmentView.showPlayButton(false);
                    try{
                        bQuizFragmentView.showMessage(bQuizStatus.getMessage());
                    }
                    catch(Exception e){
                        bQuizFragmentView.showMessage("An error ocurred!!Please try again later.");
                        e.printStackTrace();
                    }
                }


            }

            @Override
            public void onFailure() {
                bQuizFragmentView.showPlayButton(false);
                bQuizFragmentView.showMessage("No Internet Connection Found.");
            }
        });

    }
}
