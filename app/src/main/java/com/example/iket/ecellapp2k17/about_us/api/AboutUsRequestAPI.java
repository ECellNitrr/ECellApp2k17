package com.example.iket.ecellapp2k17.about_us.api;

import com.example.iket.ecellapp2k17.about_us.model.data.AboutUsData;
import com.example.iket.ecellapp2k17.helper.Urls;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by vrihas on 6/23/2017.
 */

public interface AboutUsRequestAPI {
    @GET(Urls.REQUEST_ABOUTUS)
    Call<AboutUsData> getData();

}
