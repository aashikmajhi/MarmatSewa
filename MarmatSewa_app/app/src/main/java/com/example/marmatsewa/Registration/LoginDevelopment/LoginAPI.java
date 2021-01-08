package com.example.marmatsewa.Registration.LoginDevelopment;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface LoginAPI {

    @FormUrlEncoded
    @POST("api/users/login")
    Call<LoginResponse> checkLogin(@Field("email") String email, @Field("password") String password);
}
