package com.uvarov.domain.models;

public enum AnimalType {

    CAT("cat"),
    DOG("dog"),
    UNKNOWN("");

    private String name;

    AnimalType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static AnimalType getByName(String name) {
        for (AnimalType animalType : values()) {
            if (animalType.getName().equals(name)) {
                return animalType;
            }
        }
        return UNKNOWN;
    }
}
