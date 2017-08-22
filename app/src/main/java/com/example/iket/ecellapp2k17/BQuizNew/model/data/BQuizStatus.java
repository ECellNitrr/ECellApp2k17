package com.example.iket.ecellapp2k17.BQuizNew.model.data;

/**
 * Created by samveg on 20/8/17.
 */

public class BQuizStatus {

    private boolean success;
    private String message;

    public BQuizStatus(boolean success, String message){
        this.success = success;
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
    public boolean getSuccess(){
        return success;
    }
}
