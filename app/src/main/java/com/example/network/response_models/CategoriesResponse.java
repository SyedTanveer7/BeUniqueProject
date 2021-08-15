package com.example.network.response_models;

import com.example.passion.modals.CategoryModal;
import com.google.gson.annotations.SerializedName;

public class CategoriesResponse extends ApiResponse {

    @SerializedName("data")
    private CategoryModal data;

    public CategoriesResponse(String success) {
        super(success);
    }

    public CategoryModal getData() {
        return data;
    }

    public void setData(CategoryModal data) {
        this.data = data;
    }
}
