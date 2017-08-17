package com.example.iket.ecellapp2k17.BQuizNew.model;

import android.os.Handler;

import com.example.iket.ecellapp2k17.BQuizNew.OnBQuizDataResponse;
import com.example.iket.ecellapp2k17.BQuizNew.model.data.BQuizData;
import com.example.iket.ecellapp2k17.BQuizNew.model.data.QuestionData;


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

    BQuizData getMockData() {
        QuestionData questionData=new QuestionData(1,"iket","iket","iket",2);
        BQuizData bQuizData=new BQuizData(true,"iket","iket",30,questionData,"iket",true);
        return bQuizData;
    }
}
