package com.example.marmatsewa.GarageDashboard.GarageRequestDevelopment;

import com.example.marmatsewa.Registration.WorkshopRegistrationDevelopment.Workshop;

public class RequestResponse {
    private String _id;
    private Feature feature;
    private GarageOwner garageOwner;
    private User user;

    public RequestResponse(String _id, Feature feature, GarageOwner garageOwner, User user) {
        this._id = _id;
        this.feature = feature;
        this.garageOwner = garageOwner;
        this.user = user;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public Feature getFeature() {
        return feature;
    }

    public void setFeature(Feature feature) {
        this.feature = feature;
    }

    public GarageOwner getGarageOwner() {
        return garageOwner;
    }

    public void setGarageOwner(GarageOwner garageOwner) {
        this.garageOwner = garageOwner;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
