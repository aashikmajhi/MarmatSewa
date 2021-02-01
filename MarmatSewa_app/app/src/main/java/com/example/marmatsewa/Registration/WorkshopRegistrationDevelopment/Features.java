package com.example.marmatsewa.Registration.WorkshopRegistrationDevelopment;

public class Features {
    private String featureId;
    private String garageOwnerId;

    public Features(String featureId, String garageOwnerId) {
        this.featureId = featureId;
        this.garageOwnerId = garageOwnerId;
    }

    public String getFeatureId() {
        return featureId;
    }

    public void setFeatureId(String featureId) {
        this.featureId = featureId;
    }

    public String getGarageOwnerId() {
        return garageOwnerId;
    }

    public void setGarageOwnerId(String garageOwnerId) {
        this.garageOwnerId = garageOwnerId;
    }
}
