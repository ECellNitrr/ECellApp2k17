package com.esummit.nitrr.ecellapp2k17.BQuizNew.model.data;

/**
 * Created by meghal on 6/8/16.
 */
public class BQuizData {

    private boolean success;
    private String message;
    private String message_image_url;
    private int data_type;
    private QuestionData question_data;
    private String rules;

    public BQuizData(boolean success, String message, String message_image_url, int data_type, QuestionData question_data, String rules) {
        this.success = success;
        this.message = message;
        this.message_image_url = message_image_url;
        this.data_type = data_type;
        this.question_data = question_data;
        this.rules = rules;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public String getMessage_image_url() {
        return message_image_url;
    }

    public int getData_type() {
        return data_type;
    }

    public QuestionData getQuestion_data() {
        return question_data;
    }

    public String getRules() {
        return rules;
    }
}
