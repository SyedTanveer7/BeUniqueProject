package com.example.network.response_models;

import com.example.bio.modals.ProfileModal;
import com.google.gson.annotations.SerializedName;

public class ProfileResponse extends ApiResponse {

    @SerializedName("data")
    private ProfileModal profile;

    public ProfileResponse(String success) {
        super(success);
    }

    public ProfileModal getProfile() {
        return profile;
    }

    public void setProfile(ProfileModal profile) {
        this.profile = profile;
    }
}
