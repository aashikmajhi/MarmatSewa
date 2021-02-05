package com.example.marmatsewa.GarageDashboard.GarageRequestDevelopment;

public class Feature {
    private String _id;
    private String feature;

    public Feature(String _id, String feature) {
        this._id = _id;
        this.feature = feature;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }
}
