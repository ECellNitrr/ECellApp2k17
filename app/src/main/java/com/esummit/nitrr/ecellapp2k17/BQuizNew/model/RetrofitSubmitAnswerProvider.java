package com.esummit.nitrr.ecellapp2k17.BQuizNew.model;

import com.esummit.nitrr.ecellapp2k17.BQuizNew.api.SubmitAnswerRequestInterface;
import com.esummit.nitrr.ecellapp2k17.BQuizNew.model.data.SubmitAnswerData;
import com.esummit.nitrr.ecellapp2k17.helper.Urls;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * Created by meghal on 9/8/16.
 */
public class RetrofitSubmitAnswerProvider implements SubmitAnswerProvider {

    Retrofit retrofit;
    SubmitAnswerRequestInterface submitAnswerRequestInterface;

    public RetrofitSubmitAnswerProvider() {

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
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        submitAnswerRequestInterface = retrofit.create(SubmitAnswerRequestInterface.class);


    }

    @Override
    public Observable<SubmitAnswerData> submitQuestion(int questionId, String answerId, String access_token) {

        return submitAnswerRequestInterface.submitAnswer(questionId, answerId,access_token);
    }
}
