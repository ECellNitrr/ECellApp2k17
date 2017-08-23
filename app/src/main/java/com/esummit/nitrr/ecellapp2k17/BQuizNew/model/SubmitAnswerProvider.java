package com.esummit.nitrr.ecellapp2k17.BQuizNew.model;

import com.esummit.nitrr.ecellapp2k17.BQuizNew.model.data.SubmitAnswerData;

import rx.Observable;

/**
 * Created by meghal on 9/8/16.
 */
public interface SubmitAnswerProvider {

    Observable<SubmitAnswerData> submitQuestion(int questionId, String answerId, String access_token);

}
