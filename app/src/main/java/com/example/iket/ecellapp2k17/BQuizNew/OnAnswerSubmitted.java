package com.example.iket.ecellapp2k17.BQuizNew;

import com.example.iket.ecellapp2k17.BQuizNew.model.data.SubmitAnswerData;

/**
 * Created by meghal on 9/8/16.
 */
public interface OnAnswerSubmitted {

    void onSuccess(SubmitAnswerData submitAnswerData);

    void onFailure();

}
