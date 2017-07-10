package com.example.iket.ecellapp2k17.sponsors.api;

import com.example.iket.ecellapp2k17.helper.Urls;
import com.example.iket.ecellapp2k17.sponsors.view.ResponseSpons;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by samveg on 23/6/17.
 */

public interface RequestApiSpons {
    @GET(Urls.REQUEST_SPONS)
    Call<ResponseSpons> getSpons();
}