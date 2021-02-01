package com.example.marmatsewa.GarageDashboard.GarageRequestDevelopment;

import com.example.marmatsewa.Registration.WorkshopRegistrationDevelopment.Workshop;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface GarageRequestAPI {
    @GET("api/requests/garages")
    Call<List<GarageRequestResponse>> getRequestList(@Header("Authorization") String header);
}
