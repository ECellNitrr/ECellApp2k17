package com.esummit.nitrr.ecellapp2k17.BQuizNew.model;

import com.esummit.nitrr.ecellapp2k17.BQuizNew.OnBQuizStatusResponse;
import com.esummit.nitrr.ecellapp2k17.BQuizNew.api.StatusRequestInterface;
import com.esummit.nitrr.ecellapp2k17.BQuizNew.model.data.BQuizStatus;
import com.esummit.nitrr.ecellapp2k17.helper.Urls;
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
 * Created by samveg on 20/8/17.
 */

public class RetrofitStatusProvider implements BQuizStatusProvider {

    private Retrofit retrofit;
    private StatusRequestInterface statusRequestInterface;
/*
    public RetrofitStatusProvider(){


    }
*/
    @Override
    public void requestBquizStatus(final OnBQuizStatusResponse onBQuizStatusResponse) {


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

        statusRequestInterface = retrofit.create(StatusRequestInterface.class);


        Call<BQuizStatus> bQuizDataCall = statusRequestInterface.getBQuizStatus();

        bQuizDataCall.enqueue(new Callback<BQuizStatus>() {
            @Override
            public void onResponse(Call<BQuizStatus> call, Response<BQuizStatus> response) {

                onBQuizStatusResponse.onSuccess(response.body());

            }

            @Override
            public void onFailure(Call<BQuizStatus> call, Throwable t) {

                t.printStackTrace();
            }
        });
    }

    }

