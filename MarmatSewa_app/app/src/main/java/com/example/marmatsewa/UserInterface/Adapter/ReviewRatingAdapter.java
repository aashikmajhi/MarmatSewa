package com.example.marmatsewa.UserInterface.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.marmatsewa.R;
import com.example.marmatsewa.UserInterface.RatingReviewDevelopment.RatingReviewResponse;

import java.util.List;

public class ReviewRatingAdapter extends RecyclerView.Adapter<ReviewRatingAdapter.ReviewRatingHolder> {

    private List<RatingReviewResponse> reviewList;

    public ReviewRatingAdapter(List<RatingReviewResponse> reviewList) {
        this.reviewList = reviewList;
    }

    @NonNull
    @Override
    public ReviewRatingHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return  new ReviewRatingHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.review_rating_card, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewRatingHolder holder, int position) {

        holder.date.setText("Posted on: " + reviewList.get(position).getCreatedAt().substring(0, 10));
        holder.ratingBar.setRating(reviewList.get(position).getRating());
        holder.tvReview.setText(reviewList.get(position).getReview());
    }

    @Override
    public int getItemCount() {
        return reviewList.size();
    }

    public class ReviewRatingHolder extends RecyclerView.ViewHolder {
        private RatingBar ratingBar;
        private TextView tvReview;
        private TextView date;
        public ReviewRatingHolder(@NonNull View itemView) {
            super(itemView);
            tvReview = itemView.findViewById(R.id.tvReview);
            date = itemView.findViewById(R.id.tvName);
            ratingBar = itemView.findViewById(R.id.rating_bar);

        }
    }
}
