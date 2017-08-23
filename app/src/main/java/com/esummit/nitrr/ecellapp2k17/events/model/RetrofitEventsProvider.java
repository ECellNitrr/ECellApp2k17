package com.esummit.nitrr.ecellapp2k17.events.model;

import com.esummit.nitrr.ecellapp2k17.events.api.RequestInterface;
import com.esummit.nitrr.ecellapp2k17.events.view.OnEventsReceived;
import com.esummit.nitrr.ecellapp2k17.events.model.data.EventsList;
import com.esummit.nitrr.ecellapp2k17.helper.Urls;

import java.util.concurrent.TimeUnit;

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
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Urls.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        final RequestInterface request = retrofit.create(RequestInterface.class);

        Call<EventsList> call = request.getEvents();

        call.enqueue(new Callback<EventsList>() {
            @Override
            public void onResponse(Call<EventsList> call, Response<EventsList> response) {
                onEventsReceived.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<EventsList> call, Throwable t) {
                t.printStackTrace();
                onEventsReceived.onFailure();

            }

        });

    }

}
