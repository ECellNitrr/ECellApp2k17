package com.example.iket.ecellapp2k17.otp_verify.api;

import com.example.iket.ecellapp2k17.helper.Urls;
import com.example.iket.ecellapp2k17.otp_verify.model.OtpData;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by samveg on 30/7/17.
 */

public interface RequestOtpVerify {

    @FormUrlEncoded
    @POST(Urls.REQUEST_VERIFY)
    Call<OtpData> getJson(@Field("otp") String otp, @Field("mobile") String mobile, @Field("token") String access_token);
}
