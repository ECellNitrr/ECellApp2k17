package com.bquiz.raipur.ecellapp2k17.BQuizNew.model;


import com.bquiz.raipur.ecellapp2k17.BQuizNew.OnBQuizDataResponse;

/**
 * Created by meghal on 6/8/16.
 */
public interface BQuizProvider {

    void requestBquizData(String adminToken, OnBQuizDataResponse onBQuizDataResponse);
    void cancelCall();

}
