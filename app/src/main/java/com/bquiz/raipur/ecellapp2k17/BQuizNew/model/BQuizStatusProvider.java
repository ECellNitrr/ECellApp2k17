package com.bquiz.raipur.ecellapp2k17.BQuizNew.model;

import com.bquiz.raipur.ecellapp2k17.BQuizNew.OnBQuizStatusResponse;

/**
 * Created by samveg on 20/8/17.
 */

public interface BQuizStatusProvider {

    void requestBquizStatus(OnBQuizStatusResponse onBQuizStatusResponse);
}
