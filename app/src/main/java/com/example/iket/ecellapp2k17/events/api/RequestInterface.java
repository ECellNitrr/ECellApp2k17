package com.example.iket.ecellapp2k17.events.api;

import android.telecom.Call;

import com.example.iket.ecellapp2k17.events.view.jsonResponse;
import com.example.iket.ecellapp2k17.helper.Urls;

import static com.facebook.HttpMethod.GET;

/**
 * Created by samveg on 22/6/17.
 */

public interface RequestInterface {
    @GET(Urls.REQUEST_EVENTS)
    Call<jsonResponse> getEvents();
}
