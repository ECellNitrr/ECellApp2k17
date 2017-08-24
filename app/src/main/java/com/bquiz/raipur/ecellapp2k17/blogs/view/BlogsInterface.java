package com.bquiz.raipur.ecellapp2k17.blogs.view;

import com.bquiz.raipur.ecellapp2k17.blogs.model.data.BlogFeed;

/**
 * Created by vrihas on 6/21/2017.
 */

public interface BlogsInterface {

    void setData(BlogFeed blogFeedList);
    void showMessage(String message);
    void showProgressBar(boolean show);
    void showDefault(boolean show);
    //void checkNetwork();
}
