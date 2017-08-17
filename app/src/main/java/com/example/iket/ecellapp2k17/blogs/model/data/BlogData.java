package com.example.iket.ecellapp2k17.blogs.model.data;

/**
 * Created by vrihas on 6/21/2017.
 */

public class BlogData {
    String title;
    String blogOwner;
    String date;
    String body;
    String image;
    String url;

    public BlogData(String title, String blogOwner, String date, String body, String image, String url) {
        this.title = title;
        this.blogOwner = blogOwner;
        this.date = date;
        this.body = body;
        this.image = image;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public String getBlogOwner() {
        return blogOwner;
    }

    public String getDate() {
        return date;
    }

    public String getBody() {
        return body;
    }

    public String getImage() {
        return image;
    }
    public String getUrl(){
        return url;
    }
}
