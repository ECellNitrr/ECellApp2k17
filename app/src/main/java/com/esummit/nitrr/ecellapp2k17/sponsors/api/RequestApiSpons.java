package com.esummit.nitrr.ecellapp2k17.sponsors.api;

import com.esummit.nitrr.ecellapp2k17.helper.Urls;
import com.esummit.nitrr.ecellapp2k17.sponsors.model.data.SponsParent;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by samveg on 23/6/17.
 */

public interface RequestApiSpons {
    @GET(Urls.REQUEST_SPONS)
    Call <SponsParent> getSpons();
}
