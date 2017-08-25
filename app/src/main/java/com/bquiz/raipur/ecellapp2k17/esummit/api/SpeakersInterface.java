package com.bquiz.raipur.ecellapp2k17.esummit.api;

import com.bquiz.raipur.ecellapp2k17.esummit.model.data.SpeakerList;
import com.bquiz.raipur.ecellapp2k17.helper.Urls;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by iket on 14/8/17.
 */

public interface SpeakersInterface {
    @GET(Urls.REQUEST_SPEAKERS)
    Call<SpeakerList> getSpeaker();
}
