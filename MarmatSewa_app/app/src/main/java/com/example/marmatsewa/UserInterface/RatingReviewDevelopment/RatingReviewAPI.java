package com.example.marmatsewa.UserInterface.RatingReviewDevelopment;

import com.example.marmatsewa.Registration.WorkshopRegistrationDevelopment.Workshop;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RatingReviewAPI {
    @GET("api/garageOwner/{garage_id}/reviews")
    Call<List<RatingReviewResponse>> getReview(@Header("Authorization") String header, @Path("garage_id") String garage_id);

    @FormUrlEncoded
    @POST("api/garageOwner/{garage_id}/reviews")
    Call<Void> postReview(@Header("Authorization") String header, @Path("garage_id") String garage_id,
                          @Field("review") String review, @Field("rating") Float rating);
}
