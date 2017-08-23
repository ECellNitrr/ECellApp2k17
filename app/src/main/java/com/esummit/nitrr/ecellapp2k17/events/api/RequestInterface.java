package com.esummit.nitrr.ecellapp2k17.events.api;


import com.esummit.nitrr.ecellapp2k17.events.model.data.EventsList;
import com.esummit.nitrr.ecellapp2k17.helper.Urls;

import retrofit2.Call;
import retrofit2.http.GET;


/**
 * Created by samveg on 22/6/17.
 */

public interface RequestInterface {
    @GET(Urls.REQUEST_EVENTS)
    Call<EventsList> getEvents();
}
