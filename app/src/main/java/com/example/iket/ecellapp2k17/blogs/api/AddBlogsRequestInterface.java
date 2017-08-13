package com.example.iket.ecellapp2k17.blogs.api;

import com.example.iket.ecellapp2k17.blogs.model.data.AddBlogsData;
import com.example.iket.ecellapp2k17.helper.Urls;

import java.util.Observable;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * Created by vrihas on 31/7/17.
 */

public interface AddBlogsRequestInterface {

    @Multipart
    @POST(Urls.REQUEST_ADD_BLOGS)
    Call<AddBlogsData> getJson(
            @Part("blogTitle") RequestBody blogTitle,
            @Part("blogBody") RequestBody blogBody,
            @Part MultipartBody.Part file
    );

}
