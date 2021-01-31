package com.example.marmatsewa.AdminInterface.GarageListDevelopment;

import com.example.marmatsewa.Registration.WorkshopRegistrationDevelopment.Workshop;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface GarageAPI {

    @GET("api/garageOwner/")
    Call<List<Workshop>> getAllGarageList(@Header("Authorization") String header);
}
