package com.example.marmatsewa.GarageDashboard.GarageRequestDevelopment;

import com.example.marmatsewa.AdminInterface.SeviceDevelopment.Service;
import com.example.marmatsewa.AdminInterface.SeviceDevelopment.ServiceAPI;
import com.example.marmatsewa.url.URL;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class GarageRequestBLL {
    private GarageRequestAPI garageRequestAPI = URL.getInstance().create(GarageRequestAPI.class);

    public List<GarageRequestResponse> getGarageRequests() {
        List<GarageRequestResponse> requestList = null;
        Call<List<GarageRequestResponse>> call = garageRequestAPI.getRequestList(URL.token);

        try {
            Response<List<GarageRequestResponse>> response = call.execute();
            if(response.isSuccessful()) {
                requestList = response.body();
                for (GarageRequestResponse service: requestList) {
                    System.out.println(service);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return requestList;
    }

}
