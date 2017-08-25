package com.bquiz.raipur.ecellapp2k17.blogs.api;

import com.bquiz.raipur.ecellapp2k17.blogs.model.data.AddBlogsData;
import com.bquiz.raipur.ecellapp2k17.helper.Urls;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
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
            @Part("access_token") RequestBody access_token,
            @Part MultipartBody.Part file
    );

}
