package com.bquiz.raipur.ecellapp2k17.BQuizNew.presenter;

<<<<<<< HEAD:app/src/main/java/com/example/iket/ecellapp2k17/BQuizNew/presenter/BQuizFragmentPresenterImpl.java
import android.widget.Toast;

import com.example.iket.ecellapp2k17.BQuizNew.OnBQuizStatusResponse;
import com.example.iket.ecellapp2k17.BQuizNew.model.BQuizStatusProvider;
import com.example.iket.ecellapp2k17.BQuizNew.model.data.BQuizStatus;
import com.example.iket.ecellapp2k17.BQuizNew.view.BQuizFragmentView;
=======
import com.bquiz.raipur.ecellapp2k17.BQuizNew.OnBQuizStatusResponse;
import com.bquiz.raipur.ecellapp2k17.BQuizNew.model.BQuizStatusProvider;
import com.bquiz.raipur.ecellapp2k17.BQuizNew.model.data.BQuizStatus;
import com.bquiz.raipur.ecellapp2k17.BQuizNew.view.BQuizFragmentView;
>>>>>>> fc5cc48b671c475e377ccea838b160313c547e8f:app/src/main/java/com/bquiz/raipur/ecellapp2k17/BQuizNew/presenter/BQuizFragmentPresenterImpl.java

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
