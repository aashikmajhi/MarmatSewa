package com.example.marmatsewa.AdminInterface.UploadImageDevelopment;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ImageAPI {
    @Multipart
    @POST("api/upload")
    Call<ImageResponse> uploadImage (@Part MultipartBody.Part img);
}
