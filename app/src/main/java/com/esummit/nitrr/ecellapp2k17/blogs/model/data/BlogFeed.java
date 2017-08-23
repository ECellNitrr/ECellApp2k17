package com.esummit.nitrr.ecellapp2k17.blogs.model.data;

import java.util.List;

/**
 * Created by vrihas on 6/21/2017.
 */

public class BlogFeed {
    private List<BlogData> blogs;
    private boolean success;
    private String message;

    public BlogFeed(List<BlogData> blogs, boolean success, String message) {
        this.blogs = blogs;
        this.success = success;
        this.message = message;
    }

    public List<BlogData> getBlogs() {
        return blogs;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
