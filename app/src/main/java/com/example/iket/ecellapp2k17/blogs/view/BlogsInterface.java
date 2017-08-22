package com.example.iket.ecellapp2k17.blogs.view;

import com.example.iket.ecellapp2k17.blogs.model.data.BlogData;
import com.example.iket.ecellapp2k17.blogs.model.data.BlogFeed;

import java.util.List;

/**
 * Created by vrihas on 6/21/2017.
 */

public interface BlogsInterface {

    void setData(BlogFeed blogFeedList);
    void showMessage(String message);
    void showProgressBar(boolean show);
    void showDefault(boolean show);
}
