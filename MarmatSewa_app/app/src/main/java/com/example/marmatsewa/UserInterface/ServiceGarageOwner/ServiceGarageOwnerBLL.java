package com.example.marmatsewa.UserInterface.ServiceGarageOwner;

import com.example.marmatsewa.Registration.WorkshopRegistrationDevelopment.Workshop;
import com.example.marmatsewa.url.URL;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class ServiceGarageOwnerBLL {
    private String feature_id;
    private List<ServiceGarageOwnerResponse> garageList;

    public ServiceGarageOwnerBLL(String feature_id) {
        this.feature_id = feature_id;
    }

    public List<ServiceGarageOwnerResponse> getGarageInfo() {
        ServiceGarageOwnerAPI serviceGarageOwnerAPI = URL.getInstance().create(ServiceGarageOwnerAPI.class);
        Call<List<ServiceGarageOwnerResponse>> call = serviceGarageOwnerAPI.getGarages(URL.token, feature_id);

        try {
            Response<List<ServiceGarageOwnerResponse>> response = call.execute();
            if(response.isSuccessful()) {
                garageList = response.body();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return garageList;
    }
}
