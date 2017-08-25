package com.bquiz.raipur.ecellapp2k17.blogs.presenter;

import com.bquiz.raipur.ecellapp2k17.R;
import com.bquiz.raipur.ecellapp2k17.blogs.model.AddBlogsProvider;
import com.bquiz.raipur.ecellapp2k17.blogs.model.data.AddBlogsData;
import com.bquiz.raipur.ecellapp2k17.blogs.view.AddABlogCallback;
import com.bquiz.raipur.ecellapp2k17.blogs.view.AddABlogView;
import com.bquiz.raipur.ecellapp2k17.helper.MyApplication;

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
    public void addBlogsData(final String blogTitle,final String blogBody,final String access_token,final String file_image) {
        addABlogView.showProgressBar(true);
        addBlogsProvider.getBlogResponse(blogTitle, blogBody,access_token,file_image,new AddABlogCallback() {
            @Override
            public void onBlogSent(AddBlogsData addBlogsData) {
                if (addBlogsData.isSuccess()){
                    addABlogView.showProgressBar(false);
                    addABlogView.AddBlogsStatus(addBlogsData);
                }
                else {
                    addABlogView.showProgressBar(false);
                    addABlogView.showMessage(addBlogsData.getMessage());
                }
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
