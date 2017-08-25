package com.bquiz.raipur.ecellapp2k17.BQuizNew.api;

import com.bquiz.raipur.ecellapp2k17.BQuizNew.model.data.BQuizData;
import com.bquiz.raipur.ecellapp2k17.helper.Urls;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by meghal on 6/8/16.
 */
public interface BquizRequestInterface {

//    @FormUrlEncoded
    @GET(Urls.REQUEST_BQUIZ_DATA)
    Call<BQuizData> getBQuizData(@Query("access_token") String access_token);
}
