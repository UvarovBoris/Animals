package com.uvarov.domain.models;

/**
 * Created by freeman on 17.10.2017.
 */

public enum AnimalType {

    CAT("cat"),
    DOG("dog");

    private String apiKey;

    AnimalType(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getApiKey() {
        return apiKey;
    }
}
