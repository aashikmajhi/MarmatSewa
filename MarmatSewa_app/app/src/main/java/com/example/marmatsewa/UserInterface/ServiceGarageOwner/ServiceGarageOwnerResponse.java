package com.example.marmatsewa.UserInterface.ServiceGarageOwner;

import com.example.marmatsewa.Registration.WorkshopRegistrationDevelopment.Workshop;
import com.example.marmatsewa.RequestDevelopment.Feature;

public class ServiceGarageOwnerResponse {
   public Workshop garageOwner;
   private Feature feature;

    public Feature getFeature() {
        return feature;
    }

    public void setFeature(Feature feature) {
        this.feature = feature;
    }

    public ServiceGarageOwnerResponse(Workshop garageOwner) {
        this.garageOwner = garageOwner;
    }

    public Workshop getGarageOwner() {
        return garageOwner;
    }

    public void setGarageOwner(Workshop garageOwner) {
        this.garageOwner = garageOwner;
    }
}
