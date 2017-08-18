package com.example.iket.ecellapp2k17.blogs.presenter;

import com.example.iket.ecellapp2k17.blogs.model.data.BlogData;
import com.example.iket.ecellapp2k17.blogs.model.BlogsProvider;
import com.example.iket.ecellapp2k17.blogs.view.BlogsInterface;
import com.example.iket.ecellapp2k17.blogs.view.OnBlogsReceived;

import java.util.List;

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
            public void onSuccess(List<BlogData> blogDataList) {
                blogsInterface.showProgressBar(false);
                blogsInterface.setData(blogDataList);
            }

            @Override
            public void onFailure() {
                blogsInterface.showProgressBar(false);
                blogsInterface.showMessage("Please check your internet connection");
            }
        });
    }
}
