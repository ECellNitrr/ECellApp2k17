package com.example.iket.ecellapp2k17.BQuizNew.view;


import com.example.iket.ecellapp2k17.BQuizNew.model.data.BQuizData;
import com.example.iket.ecellapp2k17.BQuizNew.model.data.SubmitAnswerData;

/**
 * Created by meghal on 6/8/16.
 */
public interface BQuizView {


    void showMessage(String message);
    void show_Image(String image);

    void showProgressbar(boolean show);

    void setBquizData(BQuizData bquizData);

    void answerSubmitted(SubmitAnswerData submitAnswerData);

}
