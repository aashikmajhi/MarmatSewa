package com.example.marmatsewa.ServiceDevelopment;

public class Service {
    private String feature;
    private String admin;

    public Service(String feature, String admin) {
        this.feature = feature;
        this.admin = admin;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }
}
