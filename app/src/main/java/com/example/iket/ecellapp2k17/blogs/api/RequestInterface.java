package com.example.iket.ecellapp2k17.blogs.api;

import com.example.iket.ecellapp2k17.blogs.model.data.BlogFeed;
import com.example.iket.ecellapp2k17.helper.Urls;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by lenovo on 6/21/2017.
 */

public interface RequestInterface {
    @GET(Urls.REQUEST_BLOGS)
    Call<BlogFeed> getBlog();
}
