package com.example.marmatsewa.Registration.WorkshopRegistrationDevelopment;

public class Features {
    private String feature;
    private String garageOwner;

    public Features(String feature, String garageOwner) {
        this.feature = feature;
        this.garageOwner = garageOwner;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public String getGarageOwner() {
        return garageOwner;
    }

    public void setGarageOwner(String garageOwner) {
        this.garageOwner = garageOwner;
    }
}
