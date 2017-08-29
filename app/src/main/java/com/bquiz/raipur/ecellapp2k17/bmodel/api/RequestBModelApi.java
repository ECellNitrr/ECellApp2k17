package com.bquiz.raipur.ecellapp2k17.bmodel.api;

import com.bquiz.raipur.ecellapp2k17.bmodel.model.data.MentorList;
import com.bquiz.raipur.ecellapp2k17.helper.Urls;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by samveg on 29/8/17.
 */

public interface RequestBModelApi {

    @GET(Urls.REQUEST_SPEAKERS)
    Call<MentorList> getMentor();
}
