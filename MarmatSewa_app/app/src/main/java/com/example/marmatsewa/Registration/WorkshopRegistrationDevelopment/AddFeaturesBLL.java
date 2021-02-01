package com.example.marmatsewa.Registration.WorkshopRegistrationDevelopment;


import com.example.marmatsewa.url.URL;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class AddFeaturesBLL {
    private boolean isSuccess;
    private Features features;

    public AddFeaturesBLL(Features features) {
        this.features = features;
    }

    public boolean checkAddGarageFeatures() {
        isSuccess = false;
        AddFeatureAPI addFeatureAPI = URL.getInstance().create(AddFeatureAPI.class);
        Call<Void> call = addFeatureAPI.addGarageFeatures(URL.token, features);

        try {
            Response<Void> response = call.execute();
            if (response.isSuccessful()){
                isSuccess = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return isSuccess;
    }
}
