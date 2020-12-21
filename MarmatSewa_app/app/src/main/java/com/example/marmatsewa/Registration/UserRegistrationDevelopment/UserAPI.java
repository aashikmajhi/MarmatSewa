package com.example.marmatsewa.Registration.UserRegistrationDevelopment;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserAPI {

    @POST("api/users/register")
    Call<Void> registerUser(@Body User user);

}
