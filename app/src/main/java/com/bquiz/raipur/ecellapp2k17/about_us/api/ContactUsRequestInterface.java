package com.bquiz.raipur.ecellapp2k17.about_us.api;

import com.bquiz.raipur.ecellapp2k17.about_us.model.data.ContactUsData;
import com.bquiz.raipur.ecellapp2k17.helper.Urls;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by vrihas on 14/8/17.
 */

public interface ContactUsRequestInterface {
    @FormUrlEncoded
    @POST(Urls.REQUEST_CONTACTUS)
    Call<ContactUsData> getJSON(@Field("name") String name, @Field("email") String email, @Field("message") String body);

}
