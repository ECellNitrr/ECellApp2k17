package com.bquiz.raipur.ecellapp2k17.blogs.view;

import com.bquiz.raipur.ecellapp2k17.blogs.model.data.BlogFeed;

/**
 * Created by vrihas on 6/21/2017.
 */

public interface OnBlogsReceived {

    void onSuccess(BlogFeed blogFeedList);
    void onFailure();
}
