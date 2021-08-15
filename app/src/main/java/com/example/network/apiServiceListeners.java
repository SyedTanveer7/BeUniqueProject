package com.example.network;


import com.example.network.response_models.CategoriesResponse;
import com.example.network.response_models.ProfileResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface apiServiceListeners {

    @GET("api/v1/category/60597fa4eb72561fb6bb064f")
    Call<CategoriesResponse> getCategories();

    @GET("api/v1/profile/me")
    Call<ProfileResponse> getProfile();


}
