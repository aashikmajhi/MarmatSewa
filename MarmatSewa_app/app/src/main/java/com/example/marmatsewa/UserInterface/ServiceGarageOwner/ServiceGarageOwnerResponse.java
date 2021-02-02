package com.example.marmatsewa.UserInterface.ServiceGarageOwner;

import com.example.marmatsewa.Registration.WorkshopRegistrationDevelopment.Workshop;

public class ServiceGarageOwnerResponse {
   public Workshop garageOwner;

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
