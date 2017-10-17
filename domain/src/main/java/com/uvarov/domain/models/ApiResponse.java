package com.uvarov.domain.models;

import java.util.List;

public class ApiResponse {

    private String message;

    private List<Animal> data;

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(List<Animal> data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public List<Animal> getData() {
        return data;
    }
}
