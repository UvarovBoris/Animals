package com.uvarov.domain.models;

import java.util.ArrayList;

public class ApiResponse {

    private String message;

    private ArrayList<Animal> data;

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(ArrayList<Animal> data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public ArrayList<Animal> getData() {
        return data;
    }
}
