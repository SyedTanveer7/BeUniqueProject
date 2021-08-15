package com.example.bio.repository;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.network.ApiClient;
import com.example.network.apiServiceListeners;
import com.example.network.response_models.ProfileResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BioRepository {

    private Context context;
    private apiServiceListeners listeners;


    public BioRepository(Context context) {
        this.context = context;
        listeners = ApiClient.getRetrofitInstance().create(apiServiceListeners.class);
    }


    public LiveData<ProfileResponse> getProfile() {

        final MutableLiveData<ProfileResponse> dashboardResponse = new MutableLiveData<>();

        listeners.getProfile().enqueue(new Callback<ProfileResponse>() {
            @Override
            public void onResponse(Call<ProfileResponse> call, Response<ProfileResponse> response) {
                if (response.isSuccessful()) {

                    dashboardResponse.setValue(response.body());
                } else {
                    dashboardResponse.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<ProfileResponse> call, Throwable t) {
                dashboardResponse.setValue(null);
            }
        });
        return dashboardResponse;

    }


}
