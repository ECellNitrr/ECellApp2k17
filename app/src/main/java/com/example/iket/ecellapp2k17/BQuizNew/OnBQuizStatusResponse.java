package com.example.iket.ecellapp2k17.BQuizNew;

import com.example.iket.ecellapp2k17.BQuizNew.model.data.BQuizStatus;

/**
 * Created by samveg on 20/8/17.
 */

public interface OnBQuizStatusResponse {

    void onSuccess(BQuizStatus bQuizStatus);
    void onFailure();

}
