package com.esummit.nitrr.ecellapp2k17.blogs.view;

import com.esummit.nitrr.ecellapp2k17.blogs.model.data.AddBlogsData;

/**
 * Created by vrihas on 1/8/17.
 */

public interface AddABlogView {
    void showProgressBar(boolean show);
    void showMessage(String message);
    void AddBlogsStatus(AddBlogsData addBlogsData);
}
