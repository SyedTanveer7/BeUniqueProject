package com.example.passion.viewmodel;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.network.response_models.CategoriesResponse;
import com.example.passion.repository.PassionRepository;

public class PassionViewModel extends AndroidViewModel {

    private Context context;
    private PassionRepository passionRepository;


    public PassionViewModel(@NonNull Application application) {
        super(application);
        passionRepository = new PassionRepository(application);
        this.context = application;
    }

    public LiveData<CategoriesResponse> getCategories() {
        return passionRepository.getCategories();
    }

}
