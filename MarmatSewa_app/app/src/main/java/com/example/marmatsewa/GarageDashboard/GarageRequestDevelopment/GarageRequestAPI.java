package com.example.marmatsewa.GarageDashboard.GarageRequestDevelopment;

import com.example.marmatsewa.Registration.WorkshopRegistrationDevelopment.Workshop;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface GarageRequestAPI {
    @GET("api/requests/garages")
    Call<List<GarageRequestResponse>> getPendingRequests(@Header("Authorization") String header);

    @GET("api/requests/garages/{requestId}")
    Call<List<GarageRequestResponse>> getAcceptedRequestForLog(@Header("Authorization") String header, @Path("requestId") String requestId);

    @FormUrlEncoded
    @PUT("api/requests/garages/{requestId}")
    Call<Void> checkPutRequest(@Header("Authorization") String header, @Path("requestId") String requestId, @Field("status") String status);

    @GET("api/requests/approvelist")
    Call<List<RequestResponse>> getApprovedRequests(@Header("Authorization") String header);

    @GET("api/requests/donelist")
    Call<List<RequestResponse>> getDoneRequests(@Header("Authorization") String header);


}
