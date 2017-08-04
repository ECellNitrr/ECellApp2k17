package com.example.iket.ecellapp2k17.blogs.api;

import com.example.iket.ecellapp2k17.blogs.model.data.AddBlogsData;
import com.example.iket.ecellapp2k17.helper.Urls;

import java.util.Observable;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by vrihas on 31/7/17.
 */

public interface AddBlogsRequestInterface {
    @FormUrlEncoded
    @POST(Urls.REQUEST_ADD_BLOGS)
    Call<AddBlogsData> getJson(@Field("blogTitle") String blogTtile, @Field("blogType") String blogType, @Field("blogBody") String blogBody);

}
