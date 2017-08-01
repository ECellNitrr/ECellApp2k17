package com.example.iket.ecellapp2k17.blogs.model.data;

/**
 * Created by vrihas on 6/21/2017.
 */

public class BlogData {
    String blogTitle;
    String blogOwner;
    String blogDate;
    String blogBody;
    String blogImage;

    public BlogData(String blogTitle, String blogOwner, String blogDate, String blogBody, String blogImage) {
        this.blogTitle = blogTitle;
        this.blogOwner = blogOwner;
        this.blogDate = blogDate;
        this.blogBody = blogBody;
        this.blogImage = blogImage;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public String getBlogOwner() {
        return blogOwner;
    }

    public String getBlogDate() {
        return blogDate;
    }

    public String getBlogBody() {
        return blogBody;
    }

    public String getBlogImage() {
        return blogImage;
    }
}
