package com.example.marmatsewa.UserInterface.ServiceGarageOwner;

import com.example.marmatsewa.Registration.WorkshopRegistrationDevelopment.Workshop;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface ServiceGarageOwnerAPI {
    @GET("api/garagefeatures/{feature_id}")
    Call<List<ServiceGarageOwnerResponse>> getGarages(@Header("Authorization") String header, @Path("feature_id") String feature_id);
}
