package com.example.marmatsewa.Registration.WorkshopRegistrationDevelopment;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface WorkshopAPI {

    @POST("api/garageOwner/")
    Call<Void> registerWorkshop(@Body Workshop workshop);
}
