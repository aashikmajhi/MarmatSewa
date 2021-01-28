package com.example.marmatsewa.AdminInterface.SeviceDevelopment;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ServiceAPI {

    @GET("api/features")
    Call<List<Service>> getAllService(@Header("Authorization") String header);

    @POST("api/features")
    Call<Void> postService(@Header("Authorization") String header, @Body Service service);
}
