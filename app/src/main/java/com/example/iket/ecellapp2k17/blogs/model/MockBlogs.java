package com.example.iket.ecellapp2k17.blogs.model;

import com.example.iket.ecellapp2k17.blogs.model.data.BlogData;
import com.example.iket.ecellapp2k17.blogs.model.data.BlogFeed;
import com.example.iket.ecellapp2k17.blogs.view.OnBlogsReceived;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by iket on 22/6/17.
 */

public class MockBlogs implements BlogsProvider{
    @Override
    public void requestBlogs(OnBlogsReceived onBlogsReceived) {
        List<BlogData> dataList=new ArrayList<>();
        BlogData data=new BlogData("Title 1","Iket","05/12/2016","Hello, this is a sample blog for text!!hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh","http://social-media-for-development.org/wp-content/uploads/2012/11/blogging.jpg");
        dataList.add(data);
        data=new BlogData("Title 2","User 2","05/10/2016","Hello, lets get started!!","http://social-media-for-development.org/wp-content/uploads/2012/11/blogging.jpg");
        dataList.add(data);
        dataList.add(data);
        dataList.add(data);
        dataList.add(data);
        dataList.add(data);
        dataList.add(data);
        onBlogsReceived.onSuccess(dataList);
    }
}
