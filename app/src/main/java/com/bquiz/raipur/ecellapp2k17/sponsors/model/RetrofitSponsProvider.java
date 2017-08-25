package com.bquiz.raipur.ecellapp2k17.sponsors.model;

import com.bquiz.raipur.ecellapp2k17.helper.Urls;
import com.bquiz.raipur.ecellapp2k17.sponsors.api.RequestApiSpons;
import com.bquiz.raipur.ecellapp2k17.sponsors.model.data.SponsParent;
import com.bquiz.raipur.ecellapp2k17.sponsors.view.OnSponsReceived;

import java.util.concurrent.TimeUnit;

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
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Urls.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        final RequestApiSpons request = retrofit.create(RequestApiSpons.class);
        Call <SponsParent> call=request.getSpons();

        call.enqueue(new Callback<SponsParent>() {
            @Override
            public void onResponse(Call<SponsParent> call, Response<SponsParent> response) {
                onSponsReceived.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<SponsParent> call, Throwable t) {
                onSponsReceived.onFailure();
                t.printStackTrace();
            }
        });


    }
}
