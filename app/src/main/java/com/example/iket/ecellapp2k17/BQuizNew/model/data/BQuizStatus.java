package com.example.iket.ecellapp2k17.BQuizNew.model.data;

/**
 * Created by samveg on 20/8/17.
 */

public class BQuizStatus {

    private boolean status;
    private String message;

    public BQuizStatus(boolean status , String message){
        this.status = status;
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
    public boolean getStatus(){
        return status;
    }
}
