package com.example.passion.repository;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.network.ApiClient;
import com.example.network.apiServiceListeners;
import com.example.network.response_models.CategoriesResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PassionRepository {

    private Context context;
    private apiServiceListeners listeners;


    public PassionRepository(Context context) {
        this.context = context;
        listeners = ApiClient.getRetrofitInstance().create(apiServiceListeners.class);
    }

    public LiveData<CategoriesResponse> getCategories() {

        final MutableLiveData<CategoriesResponse> categoriesResponse = new MutableLiveData<>();

        listeners.getCategories().enqueue(new Callback<CategoriesResponse>() {
            @Override
            public void onResponse(Call<CategoriesResponse> call, Response<CategoriesResponse> response) {
                if (response.isSuccessful()) {

                    categoriesResponse.setValue(response.body());
                } else {
                    categoriesResponse.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<CategoriesResponse> call, Throwable t) {
                categoriesResponse.setValue(null);
            }
        });
        return categoriesResponse;

    }


}
