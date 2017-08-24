package com.bquiz.raipur.ecellapp2k17.blogs.presenter;

import com.bquiz.raipur.ecellapp2k17.blogs.model.BlogsProvider;
import com.bquiz.raipur.ecellapp2k17.blogs.model.data.BlogFeed;
import com.bquiz.raipur.ecellapp2k17.blogs.view.BlogsInterface;
import com.bquiz.raipur.ecellapp2k17.blogs.view.OnBlogsReceived;

/**
 * Created by vrihas on 6/21/2017.
 */

public class BlogsPresenterImpl implements BlogsPresenter{

    private BlogsProvider blogsProvider;
    private BlogsInterface blogsInterface;

    public BlogsPresenterImpl(BlogsProvider blogsProvider, BlogsInterface blogsInterface){
        this.blogsProvider = blogsProvider;
        this.blogsInterface = blogsInterface;
    }

    @Override
    public void requestBlogs() {
        blogsInterface.showProgressBar(true);
        blogsProvider.requestBlogs(new OnBlogsReceived() {
            @Override
            public void onSuccess(BlogFeed blogFeedList) {
                blogsInterface.showProgressBar(false);
                if (blogFeedList.isSuccess()){
                    blogsInterface.setData(blogFeedList);
                }
                else {
                    blogsInterface.showDefault(true);
                }

            }
            @Override
            public void onFailure() {
                blogsInterface.showProgressBar(false);
                blogsInterface.showMessage("Please check your internet connection");
//                blogsInterface.checkNetwork();
            }
        });
    }
}
