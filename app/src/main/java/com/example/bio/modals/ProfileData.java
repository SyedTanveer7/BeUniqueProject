package com.example.bio.modals;

import java.util.List;

public class ProfileData {

    private String name;
    private String gender;
    private String profile_picture;
    private long age;
    private String bio;
    private LocationData location;
    private List<BasicInfoData> basic_info;
    private List<SliderPhotoData> media;
    private List<SliderPhotoData> photos;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getProfile_picture() {
        return profile_picture;
    }

    public void setProfile_picture(String profile_picture) {
        this.profile_picture = profile_picture;
    }

    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public List<BasicInfoData> getBasic_info() {
        return basic_info;
    }

    public void setBasic_info(List<BasicInfoData> basic_info) {
        this.basic_info = basic_info;
    }

    public List<SliderPhotoData> getMedia() {
        return media;
    }

    public void setMedia(List<SliderPhotoData> media) {
        this.media = media;
    }

    public LocationData getLocation() {
        return location;
    }

    public void setLocation(LocationData location) {
        this.location = location;
    }

    public List<SliderPhotoData> getPhotos() {
        return photos;
    }

    public void setPhotos(List<SliderPhotoData> photos) {
        this.photos = photos;
    }
}
