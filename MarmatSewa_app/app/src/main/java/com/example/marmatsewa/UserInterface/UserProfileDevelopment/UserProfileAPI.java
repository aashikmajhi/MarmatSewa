package com.example.marmatsewa.UserInterface.UserProfileDevelopment;

import com.example.marmatsewa.Registration.UserRegistrationDevelopment.User;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface UserProfileAPI {

    @GET("api/profiles/{user_id}")
    Call<User> getProfile(@Header("Authorization") String header, @Path("user_id") String user_id);
}
