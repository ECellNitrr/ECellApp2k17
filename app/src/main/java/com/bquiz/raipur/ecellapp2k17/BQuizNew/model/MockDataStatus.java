package com.bquiz.raipur.ecellapp2k17.BQuizNew.model;

import com.bquiz.raipur.ecellapp2k17.BQuizNew.OnBQuizStatusResponse;
import com.bquiz.raipur.ecellapp2k17.BQuizNew.model.data.BQuizStatus;

/**
 * Created by iket on 25/8/17.
 */

public class MockDataStatus implements BQuizStatusProvider {
    @Override
    public void requestBquizStatus(OnBQuizStatusResponse onBQuizStatusResponse) {
        BQuizStatus bQuizStatus=new BQuizStatus(true,"dvfvfv");
        onBQuizStatusResponse.onSuccess(bQuizStatus);
    }
}
