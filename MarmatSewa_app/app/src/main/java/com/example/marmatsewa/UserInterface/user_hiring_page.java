package com.example.marmatsewa.UserInterface;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.marmatsewa.AdminInterface.adapter.ServiceAdapter;
import com.example.marmatsewa.R;
import com.example.marmatsewa.RequestDevelopment.RequestBLL;
import com.example.marmatsewa.UserInterface.Adapter.ReviewRatingAdapter;
import com.example.marmatsewa.UserInterface.RatingReviewDevelopment.RatingReviewBLL;
import com.example.marmatsewa.UserInterface.RatingReviewDevelopment.RatingReviewResponse;

import java.util.List;

public class user_hiring_page extends AppCompatActivity {

    private TextView tvGarageNumber;
    private TextView tvAddress;
    private TextView tvGarageName;
    private Button btnHire;
    private String garageName;
    private String garage_id;
    private String feature_id;
    private String garageAddress;
    private String featureName;
    private String phoneNo;
    private RecyclerView rcReview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_hiring_page);

        tvGarageNumber = findViewById(R.id.garageNumber);
        tvAddress = findViewById(R.id.tvAddress);
        tvGarageName = findViewById(R.id.garageTitle);
        //hiding rating as it is not implemented ...
        btnHire = findViewById(R.id.btnHire);
        rcReview = findViewById(R.id.rcReview);
        getValuesFromIntentAndSetText();
        getReviewsCall();

        btnHire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postRequestCall();

            }
        });




    }
    private void getReviewsCall() {
        if (garage_id.isEmpty()) return;
        RatingReviewBLL ratingReviewBLL = new RatingReviewBLL(garage_id);
        List<RatingReviewResponse> responseList =  ratingReviewBLL.checkGetReviews();
        if (responseList == null) {
            Toast.makeText(this, "No Reviews in DB ...", Toast.LENGTH_SHORT).show();
            return;
        }
        //setup recycler view ...
        rcReview.setLayoutManager(new LinearLayoutManager(this));
        ReviewRatingAdapter serviceAdapter = new ReviewRatingAdapter(responseList);
        rcReview.setAdapter(serviceAdapter);


    }

    private void getValuesFromIntentAndSetText() {
        try {
            garageName = getIntent().getStringExtra("name");
            garage_id = getIntent().getStringExtra("garage_id");
            feature_id = getIntent().getStringExtra("feature_id");
            featureName = getIntent().getStringExtra("feature_name");
            phoneNo = getIntent().getStringExtra("garage_phone");
            garageAddress = getIntent().getStringExtra("garage_address");

            tvGarageNumber.setText(phoneNo);
            tvGarageName.setText(garageName);
            tvAddress.setText(garageAddress);

        } catch (Exception ex) {
            Toast.makeText(this, "No data fetched from Intent ...", Toast.LENGTH_SHORT).show();
        }
    }

    private void postRequestCall() {
        RequestBLL requestBLL = new RequestBLL(feature_id, garage_id);
        if (requestBLL.checkPostRequest()) {
        Intent i = new Intent(this, userRating.class);
        i.putExtra("garage_id", garage_id);
        startActivity(i);
        } else {
            Toast.makeText(this, "postRequestCall failed ..", Toast.LENGTH_SHORT).show();
        }
    }
}