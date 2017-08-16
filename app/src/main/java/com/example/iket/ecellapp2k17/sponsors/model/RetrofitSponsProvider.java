package com.example.iket.ecellapp2k17.sponsors.model;

import com.example.iket.ecellapp2k17.helper.Cache;
import com.example.iket.ecellapp2k17.helper.Urls;
import com.example.iket.ecellapp2k17.sponsors.api.RequestApiSpons;
import com.example.iket.ecellapp2k17.sponsors.view.OnSponsReceived;
import com.example.iket.ecellapp2k17.sponsors.model.data.SponsHeading;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by samveg on 23/6/17.
 */

public class RetrofitSponsProvider implements SponsProvider {

    @Override
    public void reqSpons(final OnSponsReceived onSponsReceived) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Urls.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        final RequestApiSpons request = retrofit.create(RequestApiSpons.class);
        Call <List<SponsHeading>> call=request.getSpons();

        call.enqueue(new Callback<List<SponsHeading>>() {
            @Override
            public void onResponse(Call<List<SponsHeading>> call, Response<List<SponsHeading>> response) {
                onSponsReceived.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<SponsHeading>> call, Throwable t) {

                onSponsReceived.onFailure();
                t.printStackTrace();
            }
        });


    }
}
