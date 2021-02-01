package com.example.marmatsewa.Registration.WorkshopRegistrationDevelopment;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface AddFeatureAPI {

    @POST("api/garagefeatures/")
    Call<Void> addGarageFeatures(@Header("Authorization") String header, @Body Features features);
}
