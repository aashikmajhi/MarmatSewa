package com.example.marmatsewa.ProfileDevelopment;


import com.example.marmatsewa.Registration.UserRegistrationDevelopment.User;
import com.example.marmatsewa.Registration.WorkshopRegistrationDevelopment.Workshop;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ProfileAPI {

//    @GET("api/profiles/")
//    Call<User> getProfile(@Header("Authorization") String header, @Path("user_id") String user_id);

    @GET("api/garageOwner/{gid}")
    Call<Workshop> getGarageProfile(@Header("Authorization") String header, @Path("gid") String gid);

    @PUT("api/garageOwner/{gid}")
    Call<Void> updateGarageProfile(@Header("Authorization") String header, @Path("gid") String gid, @Body Workshop workshop);
}
