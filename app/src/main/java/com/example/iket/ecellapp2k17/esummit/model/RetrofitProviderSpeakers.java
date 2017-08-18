package com.example.iket.ecellapp2k17.esummit.model;

import com.example.iket.ecellapp2k17.esummit.api.SpeakersInterface;
import com.example.iket.ecellapp2k17.esummit.model.data.SpeakerList;
import com.example.iket.ecellapp2k17.esummit.view.OnSpeakersRecieved;
import com.example.iket.ecellapp2k17.helper.Cache;
import com.example.iket.ecellapp2k17.helper.Urls;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by samveg on 14/8/17.
 */

public class RetrofitProviderSpeakers implements EsummitProvider{
    @Override
    public void requestData(final OnSpeakersRecieved onSpeakersRecieved) {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor)
                .addInterceptor(Cache.REWRITE_CACHE_CONTROL_INTERCEPTOR).cache(Cache.provideCache())
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Urls.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();
        final SpeakersInterface request = retrofit.create(SpeakersInterface.class);
        Call<SpeakerList> call=request.getSpeaker();
        call.enqueue(new Callback<SpeakerList>(){
            @Override
            public void onResponse(Call<SpeakerList> call, Response<SpeakerList> response) {

                onSpeakersRecieved.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<SpeakerList> call, Throwable throwable) {
                onSpeakersRecieved.onFailure();
            }
        });
    }
}
