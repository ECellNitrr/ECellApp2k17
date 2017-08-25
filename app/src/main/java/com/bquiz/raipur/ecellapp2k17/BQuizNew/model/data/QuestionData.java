package com.bquiz.raipur.ecellapp2k17.BQuizNew.model.data;

/**
 * Created by meghal on 6/8/16.
 */
public class QuestionData {

    private int question_id;
    private String question;
    private String image_url;
    private String points;
    private int question_duration;

    public QuestionData(int question_id, String question, String image_url, String points, int question_duration) {
        this.question_id = question_id;
        this.question = question;
        this.image_url = image_url;
        this.points=points;
        this.question_duration = question_duration;
    }

    public String getPoints() {
        return points;
    }

    public int getQuestion_id() {
        return question_id;
    }

    public String getQuestion() {
        return question;
    }

    public String getImage_url() {
        return image_url;
    }

    public int getQuestion_duration() {
        return question_duration;
    }
}
