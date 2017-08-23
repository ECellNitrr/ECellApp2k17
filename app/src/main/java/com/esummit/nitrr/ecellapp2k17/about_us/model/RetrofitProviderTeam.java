package com.esummit.nitrr.ecellapp2k17.about_us.model;

import com.esummit.nitrr.ecellapp2k17.about_us.api.TeamRequestAPI;
import com.esummit.nitrr.ecellapp2k17.about_us.model.data.TeamList;
import com.esummit.nitrr.ecellapp2k17.about_us.view.OnAboutusReceived;
import com.esummit.nitrr.ecellapp2k17.helper.Urls;
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
 * Created by vrihas on 6/23/2017.
 */

public class RetrofitProviderTeam implements TeamProvider {
    @Override
    public void requestData(final OnAboutusReceived onAboutusReceived) {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor)
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
               .build();

// .addInterceptor(Cache.REWRITE_CACHE_CONTROL_INTERCEPTOR).cache(Cache.provideCache())
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Urls.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();
        final TeamRequestAPI request = retrofit.create(TeamRequestAPI.class);
        Call<TeamList> call=request.getData();
        call.enqueue(new Callback<TeamList>(){
            @Override
            public void onResponse(Call<TeamList> call, Response<TeamList> response) {
                onAboutusReceived.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<TeamList> call, Throwable throwable) {
                onAboutusReceived.onFailure();
            }
        });
    }
}
