package com.example.marmatsewa.ServiceDevelopment;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ServiceAPI {

    @GET("/api/features")
    Call<List<Service>> getService();
}
