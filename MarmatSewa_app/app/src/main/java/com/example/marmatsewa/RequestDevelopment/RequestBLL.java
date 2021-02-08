package com.example.marmatsewa.RequestDevelopment;

import android.widget.Toast;

import com.example.marmatsewa.GarageDashboard.GarageRequestDevelopment.GarageRequestAPI;
import com.example.marmatsewa.GarageDashboard.GarageRequestDevelopment.GarageRequestResponse;
import com.example.marmatsewa.url.URL;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class RequestBLL {
    private RequestAPI requestAPI = URL.getInstance().create(RequestAPI.class);
    private String feature;
    private String garageOwner;
    private String serviceTypes;

    public RequestBLL(String feature, String garageOwner, String serviceTypes) {
        this.feature = feature;
        this.garageOwner = garageOwner;
        this.serviceTypes = serviceTypes;
    }

    public Boolean checkPostRequest() {
        Call<Void> call = requestAPI.postRequest(URL.token, feature, garageOwner, serviceTypes);

        try {
            Response<Void> response = call.execute();
            if (response.isSuccessful()) {
              return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
