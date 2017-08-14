package com.example.iket.ecellapp2k17.esummit.api;

import com.example.iket.ecellapp2k17.blogs.model.data.BlogFeed;
import com.example.iket.ecellapp2k17.esummit.model.data.SpeakerList;
import com.example.iket.ecellapp2k17.helper.Urls;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by iket on 14/8/17.
 */

public interface SpeakersInterface {
    @GET(Urls.REQUEST_SPEAKERS)
    Call<SpeakerList> getSpeaker();
}
