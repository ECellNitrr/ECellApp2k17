package com.example.iket.ecellapp2k17.blogs.model.data;

import java.util.List;

/**
 * Created by vrihas on 6/21/2017.
 */

public class BlogFeed {
    private List<BlogData> blogs;

    public BlogFeed(List<BlogData> blogs) {
        this.blogs = blogs;
    }

    public List<BlogData> getBlogs() {
        return blogs;
    }
}
