package com.example.network;

import com.example.helpers.AppConstants;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static Retrofit retrofit;
    private static final String BASE_URL = "https://api.zipconnect.app/";
    public static final String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjYwZGM1MThlODJlM2QwMDNjZTc4MmMzMiIsImlhdCI6MTYyODQzMDUwOCwiZXhwIjoxNjM2MjA2NTA4fQ.x24t3_fy4hKsBBzt4zPk1RvYMJtWUlKFfoUcqbS_Xtk";

    static OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request newRequest = chain.request().newBuilder()
                    .addHeader("Authorization", "Bearer " + token)
                    .build();
            return chain.proceed(newRequest);
        }
    })
            .connectTimeout(AppConstants.CONNECTION_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(AppConstants.CONNECTION_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(AppConstants.CONNECTION_TIMEOUT, TimeUnit.SECONDS).build();


    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL).client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
