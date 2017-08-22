package com.example.iket.ecellapp2k17.BQuizNew.api;

import com.example.iket.ecellapp2k17.BQuizNew.model.data.BQuizStatus;
import com.example.iket.ecellapp2k17.helper.Urls;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by samveg on 20/8/17.
 */

public interface StatusRequestInterface {

    @GET(Urls.REQUEST_BQUIZ_STATUS)
    Call<BQuizStatus> getBQuizStatus();
}
