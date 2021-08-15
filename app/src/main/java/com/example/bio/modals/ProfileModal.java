package com.example.bio.modals;

public class ProfileModal {

    private ProfileData profile;
    private boolean fcm_match;

    public ProfileData getProfile() {
        return profile;
    }

    public void setProfile(ProfileData profile) {
        this.profile = profile;
    }

    public boolean isFcm_match() {
        return fcm_match;
    }

    public void setFcm_match(boolean fcm_match) {
        this.fcm_match = fcm_match;
    }
}
