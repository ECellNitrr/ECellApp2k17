package com.example.iket.ecellapp2k17.blogs.model;


import com.example.iket.ecellapp2k17.blogs.api.RequestInterface;
import com.example.iket.ecellapp2k17.blogs.model.data.BlogFeed;
import com.example.iket.ecellapp2k17.blogs.view.OnBlogsReceived;
import android.util.Log;
import com.example.iket.ecellapp2k17.helper.Cache;
import com.example.iket.ecellapp2k17.helper.Urls;
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
 * Created by vrihas on 6/21/2017.
 */

public class RetrofitBlogsProvider implements BlogsProvider{

    private static final String TAG = "Retrofit Blogs Provider";

    @Override
    public void requestBlogs(final OnBlogsReceived onBlogsReceived) {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();
        //.addInterceptor(Cache.REWRITE_CACHE_CONTROL_INTERCEPTOR).cache(Cache.provideCache())

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Urls.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        final RequestInterface request = retrofit.create(RequestInterface.class);


        Call<BlogFeed> call = request.getBlog();

        call.enqueue(new Callback<BlogFeed>(){
            @Override
            public void onResponse(Call<BlogFeed> call, Response<BlogFeed> response) {
                onBlogsReceived.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<BlogFeed> call, Throwable t) {
                Log.d("Response","Fail");
                t.printStackTrace();
                onBlogsReceived.onFailure();
            }
        });
    }
}
