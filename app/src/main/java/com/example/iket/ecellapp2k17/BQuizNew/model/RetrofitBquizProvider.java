package com.example.iket.ecellapp2k17.BQuizNew.model;

import com.example.iket.ecellapp2k17.BQuizNew.OnBQuizDataResponse;
import com.example.iket.ecellapp2k17.BQuizNew.api.BquizRequestInterface;
import com.example.iket.ecellapp2k17.BQuizNew.model.data.BQuizData;
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
 * Created by meghal on 6/8/16.
 */
public class RetrofitBquizProvider implements BQuizProvider {

    private Retrofit retrofit;
    private BquizRequestInterface bquizRequestInterface;

    public RetrofitBquizProvider() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        retrofit = new Retrofit.Builder()
                .baseUrl(Urls.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        bquizRequestInterface = retrofit.create(BquizRequestInterface.class);

    }


    @Override
    public void requestBquizData(String adminToken, final OnBQuizDataResponse onBQuizDataResponse) {
        Call<BQuizData> bQuizDataCall = bquizRequestInterface.getBQuizData(adminToken);

        bQuizDataCall.enqueue(new Callback<BQuizData>() {
            @Override
            public void onResponse(Call<BQuizData> call, Response<BQuizData> response) {

                onBQuizDataResponse.onSuccess(response.body());

            }

            @Override
            public void onFailure(Call<BQuizData> call, Throwable t) {

                t.printStackTrace();
            }
        });
    }
}
