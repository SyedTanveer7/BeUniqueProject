package com.example.bio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.bio.adapters.ImageSliderAdapter;
import com.example.bio.adapters.InstagramPhotoAdapter;
import com.example.bio.adapters.PersonalInfoAdapter;
import com.example.bio.modals.ProfileModal;
import com.example.bio.modals.SliderPhotoData;
import com.example.bio.repository.BioRepository;
import com.example.helpers.AppConstants;
import com.example.network.response_models.ProfileResponse;
import com.example.splashactivity.R;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.List;

public class BioActivity extends AppCompatActivity {

    private BioRepository bioRepository;
    private TextView txtTitle, txtDesc, txtName, txtGender, txtAge, txtLocation;
    private RecyclerView recyclerViewBasicInfo, recyclerViewInstagramPosts;
    private SliderView profileSliderView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        setContentView(R.layout.activity_bio);


        initializeViews();
    }


    @Override
    protected void onStart() {
        super.onStart();
        getProfileData();

    }

    private void initializeViews() {
        bioRepository = new BioRepository(this);
        txtTitle = findViewById(R.id.txt_person_name);
        txtDesc = findViewById(R.id.textView4);
        txtAge = findViewById(R.id.textView9);
        txtName = findViewById(R.id.textView7);
        txtGender = findViewById(R.id.textView11);
        txtLocation = findViewById(R.id.textView13);
        progressBar = findViewById(R.id.progressBar);
        profileSliderView = findViewById(R.id.imageSlider);
        recyclerViewBasicInfo = findViewById(R.id.recyclerview);
        recyclerViewInstagramPosts = findViewById(R.id.recyclerView);
    }


    private void getProfileData() {
        progressBar.setVisibility(View.VISIBLE);
        bioRepository.getProfile().observe(this, new Observer<ProfileResponse>() {
            @Override
            public void onChanged(ProfileResponse profileResponse) {

                if (profileResponse != null) {

                    bindData(profileResponse.getProfile());
                }
                progressBar.setVisibility(View.GONE);

            }
        });
    }

    private void bindData(ProfileModal profile) {

        txtTitle.setText(profile.getProfile().getName() + ", " + profile.getProfile().getAge());
        txtName.setText(profile.getProfile().getName());
        txtDesc.setText(profile.getProfile().getBio());
        txtAge.setText(String.valueOf(profile.getProfile().getAge()));
        txtGender.setText(profile.getProfile().getGender());
        txtLocation.setText(AppConstants.getAddress(this, profile.getProfile().getLocation().getCoordinates().get(0), profile.getProfile().getLocation().getCoordinates().get(1)));

        PersonalInfoAdapter adapter = new PersonalInfoAdapter(this, profile.getProfile().getBasic_info());
        recyclerViewBasicInfo.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewBasicInfo.setItemAnimator(new DefaultItemAnimator());
        recyclerViewBasicInfo.setHasFixedSize(true);
        recyclerViewBasicInfo.setAdapter(adapter);

        InstagramPhotoAdapter instagramPhotoAdapter = new InstagramPhotoAdapter(this, profile.getProfile().getPhotos());
        recyclerViewInstagramPosts.setLayoutManager(new GridLayoutManager(this, 3));
        recyclerViewInstagramPosts.setItemAnimator(new DefaultItemAnimator());
        recyclerViewInstagramPosts.setHasFixedSize(true);
        recyclerViewInstagramPosts.setAdapter(instagramPhotoAdapter);

        bindSliderImages(profile.getProfile().getMedia());

    }


    private void bindSliderImages(List<SliderPhotoData> photos) {


        profileSliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        profileSliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);

        profileSliderView.setSliderAdapter(new ImageSliderAdapter(photos, this));

//        profileSliderView.startAutoCycle();
    }

}