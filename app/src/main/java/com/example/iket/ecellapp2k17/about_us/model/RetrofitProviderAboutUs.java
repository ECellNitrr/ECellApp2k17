package com.example.iket.ecellapp2k17.about_us.model;

import com.example.iket.ecellapp2k17.about_us.api.AboutUsRequestAPI;
import com.example.iket.ecellapp2k17.about_us.model.data.AboutUsData;
import com.example.iket.ecellapp2k17.about_us.view.OnAboutusReceived;
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
 * Created by vrihas on 6/23/2017.
 */

public class RetrofitProviderAboutUs implements AboutUsProvider{
    @Override
    public void requestData(final OnAboutusReceived onAboutusReceived) {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor)
                .addInterceptor(Cache.REWRITE_CACHE_CONTROL_INTERCEPTOR).cache(Cache.provideCache()).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Urls.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();
        final AboutUsRequestAPI request = retrofit.create(AboutUsRequestAPI.class);
        Call<AboutUsData> call=request.getData();
        call.enqueue(new Callback<AboutUsData>(){
            @Override
            public void onResponse(Call<AboutUsData> call, Response<AboutUsData> response) {
            //    onAboutusReceived.onSuccess(response.body().getAboutUs());
            }

            @Override
            public void onFailure(Call<AboutUsData> call, Throwable throwable) {
                onAboutusReceived.onFailure();
            }
        });
    }
}
