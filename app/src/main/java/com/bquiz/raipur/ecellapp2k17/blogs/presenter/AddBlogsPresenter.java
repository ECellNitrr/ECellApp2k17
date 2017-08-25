package com.bquiz.raipur.ecellapp2k17.blogs.presenter;

/**
 * Created by vrihas on 1/8/17.
 */

public interface AddBlogsPresenter {
    void addBlogsData(String blogTitle, String blogBody, String access_token, String file_image);
    void onDestroy();
}