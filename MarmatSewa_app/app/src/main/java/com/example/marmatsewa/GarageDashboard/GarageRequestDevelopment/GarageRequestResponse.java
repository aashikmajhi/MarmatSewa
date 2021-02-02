package com.example.marmatsewa.GarageDashboard.GarageRequestDevelopment;

public class GarageRequestResponse {
    private Feature feature;
    private User user;
    private String _id;

    public GarageRequestResponse(Feature feature, User user, String _id) {
        this.feature = feature;
        this.user = user;
        this._id = _id;
    }

    public Feature getFeature() {
        return feature;
    }

    public void setFeature(Feature feature) {
        this.feature = feature;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }
}
