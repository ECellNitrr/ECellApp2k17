package com.example.iket.ecellapp2k17.BQuizNew;


import com.example.iket.ecellapp2k17.BQuizNew.model.data.BQuizData;

/**
 * Created by meghal on 6/8/16.
 */
public interface OnBQuizDataResponse {

    void onSuccess(BQuizData bQuizData);
    void onFailure();
}
