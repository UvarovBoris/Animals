package com.uvarov.domain.models;

import java.io.Serializable;

public class Animal implements Serializable {

    private String url;

    private String title;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
