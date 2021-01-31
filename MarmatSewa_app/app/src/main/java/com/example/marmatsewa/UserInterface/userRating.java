package com.example.marmatsewa.UserInterface;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Toast;

import com.example.marmatsewa.R;

public class userRating extends AppCompatActivity {
    RatingBar ratingBar;
    View btnSubmitRating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_rating);

        ratingBar = findViewById(R.id.rating_bar);
        btnSubmitRating = findViewById(R.id.btnSubmitRating);

        btnSubmitRating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = String.valueOf(ratingBar.getRating());
                Toast.makeText(getApplicationContext(), s+"Star", Toast.LENGTH_SHORT).show();
            }
        });
    }
}