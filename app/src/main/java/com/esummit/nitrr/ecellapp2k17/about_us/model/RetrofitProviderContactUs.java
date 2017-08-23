package com.esummit.nitrr.ecellapp2k17.about_us.model;

import com.esummit.nitrr.ecellapp2k17.about_us.api.ContactUsRequestInterface;
import com.esummit.nitrr.ecellapp2k17.about_us.model.data.ContactUsData;
import com.esummit.nitrr.ecellapp2k17.about_us.view.ContactUsCallback;
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
 * Created by vrihas on 14/8/17.
 */

public class RetrofitProviderContactUs implements ContactUsProvider {

    private static String TAG ="RetrofitProviderContactUs";

    @Override
    public void contactUsResponse(String name, String email, String body, final ContactUsCallback contactUsCallback) {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS).writeTimeout(10, TimeUnit.SECONDS).addInterceptor(interceptor).build();

        Retrofit retrofit= new Retrofit.Builder().baseUrl(Urls.BASE_URL).client(client).addConverterFactory(GsonConverterFactory.create()).build();
        ContactUsRequestInterface contactUsRequestInterface = retrofit.create(ContactUsRequestInterface.class);
        Call<ContactUsData> call= contactUsRequestInterface.getJSON(name, email, body);
        call.enqueue(new Callback<ContactUsData>() {
            @Override
            public void onResponse(Call<ContactUsData> call, Response<ContactUsData> response) {
                contactUsCallback.onMessageSuccess(response.body());
            }

            @Override
            public void onFailure(Call<ContactUsData> call, Throwable t) {
                contactUsCallback.onMessageFailure(t.getMessage());
            }
        });
    }
}
