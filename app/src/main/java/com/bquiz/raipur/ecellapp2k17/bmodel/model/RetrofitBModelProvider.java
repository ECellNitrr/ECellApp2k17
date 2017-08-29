package com.bquiz.raipur.ecellapp2k17.bmodel.model;

import com.bquiz.raipur.ecellapp2k17.bmodel.OnMentorsRecieved;
import com.bquiz.raipur.ecellapp2k17.bmodel.api.RequestBModelApi;
import com.bquiz.raipur.ecellapp2k17.bmodel.model.data.MentorList;
import com.bquiz.raipur.ecellapp2k17.helper.Cache;
import com.bquiz.raipur.ecellapp2k17.helper.Urls;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by samveg on 29/8/17.
 */

public class RetrofitBModelProvider  implements BModelProvider{
    @Override
    public void requestData(final OnMentorsRecieved onMentorsRecieved) {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .addInterceptor(Cache.REWRITE_CACHE_CONTROL_INTERCEPTOR).cache(Cache.provideCache())
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Urls.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();

        final RequestBModelApi requestBModelApi = retrofit.create(RequestBModelApi.class);
        Call<MentorList> call=requestBModelApi.getMentor();
        call.enqueue(new Callback<MentorList>() {
            @Override
            public void onResponse(Call<MentorList> call, Response<MentorList> response) {
                onMentorsRecieved.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<MentorList> call, Throwable t) {
                onMentorsRecieved.onFailure();
            }
        });
    }
}
