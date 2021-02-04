package com.example.marmatsewa.UserInterface.RatingReviewDevelopment;

import com.example.marmatsewa.url.URL;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class RatingReviewBLL {
    private RatingReviewAPI ratingReviewAPI = URL.getInstance().create(RatingReviewAPI.class);
    private String garage_id;
    private String review;
    private Float rating;

    public RatingReviewBLL(String garage_id, String review, Float rating) {
        this.garage_id = garage_id;
        this.review = review;
        this.rating = rating;
    }

    public Boolean checkPostReview() {
        Call<Void> call = ratingReviewAPI.postReview(URL.token, garage_id, review, rating);

        try {
            Response<Void> response = call.execute();
            if (response.isSuccessful()) {
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
