package com.esummit.nitrr.ecellapp2k17.blogs.model.data;

/**
 * Created by vrihas on 31/7/17.
 */

public class AddBlogsData {
    private boolean success;
    private String message;
    private String access_token;

    public AddBlogsData(String message, boolean success){
        this.message = message;
        this.success = success;
    }
    public  String getMessage(){
        return message;
    }

    public boolean isSuccess(){
        return  success;
    }

}
