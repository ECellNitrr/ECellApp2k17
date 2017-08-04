package com.example.iket.ecellapp2k17.blogs.model.data;

/**
 * Created by vrihas on 31/7/17.
 */

public class AddBlogsData {
    private boolean success;
    private String message;
    private String access_token;

    public AddBlogsData(String message, String access_token, boolean success){
        this.message = message;
        this.success = success;
        this.access_token = access_token;
    }
    public  String getMessage(){
        return message;
    }
    public  String getAccess_token(){
        return access_token;
    }
    public boolean isSuccess(){
        return  success;
    }

}
