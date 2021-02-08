package com.example.marmatsewa.RequestDevelopment;

import com.example.marmatsewa.AdminInterface.SeviceDevelopment.Service;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface RequestAPI {
    @POST("api/requests")
    @FormUrlEncoded
    Call<Void> postRequest(@Header("Authorization") String header, @Field("feature") String feature, @Field("garageOwner") String garageOwner, @Field("serviceTypes") String serviceTypes);
}
