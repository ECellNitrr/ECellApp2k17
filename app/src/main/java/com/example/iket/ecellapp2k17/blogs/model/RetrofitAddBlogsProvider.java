package com.example.iket.ecellapp2k17.blogs.model;

import com.example.iket.ecellapp2k17.blogs.api.AddBlogsRequestInterface;
import com.example.iket.ecellapp2k17.blogs.model.data.AddBlogsData;
import com.example.iket.ecellapp2k17.blogs.view.AddABlogCallback;
import com.example.iket.ecellapp2k17.helper.Urls;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by vrihas on 1/8/17.
 */

public class RetrofitAddBlogsProvider implements  AddBlogsProvider{
    private static String TAG = "RetrofitAddBlogsProvider";
    private Call<AddBlogsData> call;

    @Override
    public void getBlogResponse(String blogTitle, String blogType, String blogBody, final AddABlogCallback addABlogCallback) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder().baseUrl(Urls.BASE_URL).client(client).
                addConverterFactory(GsonConverterFactory.create()).build();
        final AddBlogsRequestInterface addBlogsRequestInterface = retrofit.create(AddBlogsRequestInterface.class);

        call = addBlogsRequestInterface.getJson(blogTitle,blogType,blogBody);
        call.enqueue(new Callback<AddBlogsData>() {
            @Override
            public void onResponse(Call<AddBlogsData> call, Response<AddBlogsData> response) {
                addABlogCallback.onBlogSent(response.body());
            }

            @Override
            public void onFailure(Call<AddBlogsData> call, Throwable t) {
                t.printStackTrace();
                addABlogCallback.onFailure(t.getMessage());
            }
        });
    }

    @Override
    public void onDestroy() {
        if (call!=null){
            call.cancel();
        }
    }
}

