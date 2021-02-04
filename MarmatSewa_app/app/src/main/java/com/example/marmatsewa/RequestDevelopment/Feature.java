package com.example.marmatsewa.RequestDevelopment;

public class Feature {
    private String feature;
    private String _id;

    public Feature(String feature, String _id) {
        this.feature = feature;
        this._id = _id;
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
