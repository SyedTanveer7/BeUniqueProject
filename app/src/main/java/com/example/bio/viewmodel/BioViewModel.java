package com.example.bio.viewmodel;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.bio.repository.BioRepository;
import com.example.network.response_models.ProfileResponse;

public class BioViewModel extends AndroidViewModel {

    private Context context;
    private BioRepository bioRepository;


    public BioViewModel(@NonNull Application application) {
        super(application);
        bioRepository = new BioRepository(application);
        this.context = application;
    }

    public LiveData<ProfileResponse> getProfile() {
        return bioRepository.getProfile();
    }

}
