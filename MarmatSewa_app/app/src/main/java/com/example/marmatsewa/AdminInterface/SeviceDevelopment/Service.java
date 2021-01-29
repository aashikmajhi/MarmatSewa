package com.example.marmatsewa.AdminInterface.SeviceDevelopment;

public class Service {
    private String feature;
    private String image;

    public Service(String feature, String image) {
        this.feature = feature;
        this.image = image;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
