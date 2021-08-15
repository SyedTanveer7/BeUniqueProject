package com.example.network.response_models;

import java.util.List;

public class ApiResponse {
    private String success;

    public ApiResponse(String success) {
        this.success = success;

    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }
}
