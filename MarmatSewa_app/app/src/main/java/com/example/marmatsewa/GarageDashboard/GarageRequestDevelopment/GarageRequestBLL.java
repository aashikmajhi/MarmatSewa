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

    public List<GarageRequestResponse> getPendingRequests() {
        List<GarageRequestResponse> requestList = null;
        Call<List<GarageRequestResponse>> call = garageRequestAPI.getPendingRequests(URL.token);

        try {
            Response<List<GarageRequestResponse>> response = call.execute();
            if(response.isSuccessful()) {
                requestList = response.body();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return requestList;
    }
    public List<RequestResponse> getAcceptedRequests() {
        List<RequestResponse> requestList = null;
        Call<List<RequestResponse>> call = garageRequestAPI.getApprovedRequests(URL.token);

        try {
            Response<List<RequestResponse>> response = call.execute();
            if(response.isSuccessful()) {
                requestList = response.body();
                for (RequestResponse service: requestList) {
                    System.out.println(service);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return requestList;
    }

    public List<RequestResponse> getApprovedRequest() {
        List<RequestResponse> requestList = null;
        Call<List<RequestResponse>> call = garageRequestAPI.getApprovedRequests(URL.token);

        try {
            Response<List<RequestResponse>> response = call.execute();
            if(response.isSuccessful()) {
                requestList = response.body();
                for (RequestResponse service: requestList) {
                    System.out.println(service);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return requestList;
    }

    public List<RequestResponse> getDoneRequests() {
        List<RequestResponse> requestList = null;
        Call<List<RequestResponse>> call = garageRequestAPI.getDoneRequests(URL.token);

        try {
            Response<List<RequestResponse>> response = call.execute();
            if(response.isSuccessful()) {
                requestList = response.body();
                for (RequestResponse service: requestList) {
                    System.out.println(service);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return requestList;
    }

    public Boolean putRequest(String id, String status) {
        Call<Void> call = garageRequestAPI.checkPutRequest(URL.token, id, status);
        try {
            Response<Void> response = call.execute();
            if(response.isSuccessful()) {
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
