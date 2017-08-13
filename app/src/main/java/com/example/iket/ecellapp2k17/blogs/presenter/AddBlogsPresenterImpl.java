package com.example.iket.ecellapp2k17.blogs.presenter;

import com.example.iket.ecellapp2k17.R;
import com.example.iket.ecellapp2k17.blogs.model.AddBlogsProvider;
import com.example.iket.ecellapp2k17.blogs.model.data.AddBlogsData;
import com.example.iket.ecellapp2k17.blogs.view.AddABlogCallback;
import com.example.iket.ecellapp2k17.blogs.view.AddABlogView;
import com.example.iket.ecellapp2k17.helper.MyApplication;

/**
 * Created by vrihas on 1/8/17.
 */

public class AddBlogsPresenterImpl implements AddBlogsPresenter {
    private AddABlogView addABlogView;
    private AddBlogsProvider addBlogsProvider;

    public AddBlogsPresenterImpl(AddABlogView addABlogView, AddBlogsProvider addBlogsProvider){
        this.addABlogView = addABlogView;
        this.addBlogsProvider = addBlogsProvider;

    }

    @Override
    public void addBlogsData(final String blogTitle,final String blogBody) {
        addABlogView.showProgressBar(true);
        addBlogsProvider.getBlogResponse(blogTitle, blogBody, new AddABlogCallback() {
            @Override
            public void onBlogSent(AddBlogsData addBlogsData) {
                if (addBlogsData.isSuccess()){
                    addABlogView.AddBlogsStatus(addBlogsData);
                }
                else {
                    addABlogView.showMessage(addBlogsData.getMessage());
                }
                addABlogView.showProgressBar(false);
            }

            @Override
            public void onFailure(String error) {
                addABlogView.showProgressBar(false);
                addABlogView.showMessage(MyApplication.getContext().getResources().getString(R.string.failure_message));

            }
        });
    }

    @Override
    public void onDestroy() {
        if (addBlogsProvider!=null){
            addBlogsProvider.onDestroy();
        }
    }
}
