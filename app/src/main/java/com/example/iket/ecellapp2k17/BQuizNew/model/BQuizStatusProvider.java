package com.example.iket.ecellapp2k17.BQuizNew.model;

import com.example.iket.ecellapp2k17.BQuizNew.OnBQuizStatusResponse;

/**
 * Created by samveg on 20/8/17.
 */

public interface BQuizStatusProvider {

    void requestBquizStatus(Boolean status , OnBQuizStatusResponse onBQuizStatusResponse);
}
