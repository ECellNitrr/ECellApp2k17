package com.example.iket.ecellapp2k17.blogs.model;

import com.example.iket.ecellapp2k17.blogs.view.AddABlogCallback;

/**
 * Created by vrihas on 1/8/17.
 */

public interface AddBlogsProvider {
    void getBlogResponse(String blogTitle, String blogBody, String acess_token, String file_image, AddABlogCallback addABlogCallback);
    void  onDestroy();
}
