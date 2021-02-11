package com.example.marmatsewa.UserInterface.RatingReviewDevelopment;

import com.example.marmatsewa.GarageDashboard.GarageRequestDevelopment.User;

public class RatingReviewResponse {
    private String review;
    private Float rating;
    private String createdAt;

    public RatingReviewResponse(String review, Float rating, String createdAt) {
        this.review = review;
        this.rating = rating;
        this.createdAt = createdAt;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
