package com.esummit.nitrr.ecellapp2k17.login.api;

import com.esummit.nitrr.ecellapp2k17.helper.Urls;
import com.esummit.nitrr.ecellapp2k17.login.model.LoginDataResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by samveg on 30/7/17.
 */

public interface RequestLogin {

    @FormUrlEncoded
    @POST(Urls.REQUEST_LOGIN)
    Call<LoginDataResponse> getJSON(@Field("name") String name,@Field("contact_no") String mobile, @Field("email") String email);
}
