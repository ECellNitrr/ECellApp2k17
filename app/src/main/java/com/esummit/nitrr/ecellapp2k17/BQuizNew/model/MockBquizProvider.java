package com.esummit.nitrr.ecellapp2k17.BQuizNew.model;

import android.os.Handler;

import com.esummit.nitrr.ecellapp2k17.BQuizNew.OnBQuizDataResponse;
import com.esummit.nitrr.ecellapp2k17.BQuizNew.model.data.BQuizData;
import com.esummit.nitrr.ecellapp2k17.BQuizNew.model.data.QuestionData;


/**
 * Created by meghal on 8/8/16.
 */
public class MockBquizProvider implements BQuizProvider {

    @Override
    public void requestBquizData(String adminToken, final OnBQuizDataResponse onBQuizDataResponse) {

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                onBQuizDataResponse.onSuccess(getMockData());
            }
        }, 1000);

    }

    @Override
    public void cancelCall() {

    }

    BQuizData getMockData() {
        QuestionData questionData=new QuestionData(1,"What is Ecell?","https://ecell.nitrr.ac.in/uploads/events/1502905499.png","10 Points",30);
        BQuizData bQuizData=new BQuizData(true,"Error in server","https://ecell.nitrr.ac.in/images/ecell.png",2,questionData,"iket");
        return bQuizData;
    }
}
