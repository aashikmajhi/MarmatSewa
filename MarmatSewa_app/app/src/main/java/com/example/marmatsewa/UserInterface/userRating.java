package com.example.marmatsewa.UserInterface;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Toast;

import com.example.marmatsewa.R;
import com.example.marmatsewa.UserInterface.RatingReviewDevelopment.RatingReviewBLL;

public class userRating extends AppCompatActivity {
    private RatingBar ratingBar;
    private View btnSubmitRating;
    private EditText edtReview;

    private Float rating;
    private String review;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_rating);

        ratingBar = findViewById(R.id.rating_bar);
        btnSubmitRating = findViewById(R.id.btnSubmitRating);
        edtReview = findViewById(R.id.edtReview);

        btnSubmitRating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postReviewCall();
            }
        });
    }

    private String getGarageIDFromIntent() {
        try {
            String garage_id = getIntent().getStringExtra("garage_id");
            return garage_id;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }

    }

    private void getInputValues() {
        review =  edtReview.getText().toString();
        rating = ratingBar.getRating();
    }

    private void postReviewCall() {
        if (getGarageIDFromIntent().isEmpty()) {
            Toast.makeText(this, "No Garage_id is fetched from intent ...", Toast.LENGTH_SHORT).show();
            return;
        }
        getInputValues();
        RatingReviewBLL ratingReviewBLL = new RatingReviewBLL(getGarageIDFromIntent(), review, rating );

        if (ratingReviewBLL.checkPostReview()) {
            Intent intent = new Intent(this, user_dashboard.class);
            startActivity(intent);
            Toast.makeText(this, "Review has been posted successfully", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Posting review failed ...", Toast.LENGTH_SHORT).show();

        }
    }
}