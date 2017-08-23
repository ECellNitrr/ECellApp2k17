package com.esummit.nitrr.ecellapp2k17.BQuizNew.view;


import com.esummit.nitrr.ecellapp2k17.BQuizNew.model.data.BQuizData;
import com.esummit.nitrr.ecellapp2k17.BQuizNew.model.data.SubmitAnswerData;

/**
 * Created by meghal on 6/8/16.
 */
public interface BQuizView {


    void showMessage(String message);

    void showProgressbar(boolean show);

    void setBquizData(BQuizData bquizData);

    void setBquizInactive(String message_image);

    void answerSubmitted(SubmitAnswerData submitAnswerData);

}
