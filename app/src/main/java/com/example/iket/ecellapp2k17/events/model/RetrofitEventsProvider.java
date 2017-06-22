package com.example.iket.ecellapp2k17.events.model;

import com.example.iket.ecellapp2k17.events.api.RequestInterface;
import com.example.iket.ecellapp2k17.events.view.OnEventsReceived;
import com.example.iket.ecellapp2k17.events.view.jsonResponse;
import com.example.iket.ecellapp2k17.helper.Cache;
import com.example.iket.ecellapp2k17.helper.Urls;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by samveg on 21/6/17.
 */

public class RetrofitEventsProvider implements EventsProvider {


    @Override
    public void requestEvents(final OnEventsReceived onEventsReceived) {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor)
                .addInterceptor(Cache.REWRITE_CACHE_CONTROL_INTERCEPTOR).cache(Cache.provideCache()).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Urls.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        final RequestInterface request = retrofit.create(RequestInterface.class);

        Call<jsonResponse> call = request.getEvents();

        call.enqueue(new Callback<jsonResponse>() {
            @Override
            public void onResponse(Call<jsonResponse> call, Response<jsonResponse> response) {
                onEventsReceived.onSuccess(response.body().getEvents());
            }

            @Override
            public void onFailure(Call<jsonResponse> call, Throwable t) {
                t.printStackTrace();
                onEventsReceived.onFailure();

            }

        });

    }

}
