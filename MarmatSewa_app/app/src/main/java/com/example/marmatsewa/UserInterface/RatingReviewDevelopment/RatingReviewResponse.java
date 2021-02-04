package com.example.marmatsewa.UserInterface.RatingReviewDevelopment;

import com.example.marmatsewa.GarageDashboard.GarageRequestDevelopment.User;

public class RatingReviewResponse {
    private String review;
    private Double rating;
    private User user;

    public RatingReviewResponse(String review, Double rating, User user) {
        this.review = review;
        this.rating = rating;
        this.user = user;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
