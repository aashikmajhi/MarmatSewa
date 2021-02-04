package com.example.marmatsewa.UserInterface;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.marmatsewa.R;
import com.example.marmatsewa.RequestDevelopment.RequestBLL;

public class user_hiring_page extends AppCompatActivity {

    private TextView tvGarageNumber;
    private TextView tvGarageRating;
    private TextView tvGarageName;
    private Button btnHire;
    private String garageName;
    private String garage_id;
    private String feature_id;
    private String featureName;
    private String phoneNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_hiring_page);

        tvGarageNumber = findViewById(R.id.garageNumber);
        tvGarageRating = findViewById(R.id.garageRating);
        tvGarageName = findViewById(R.id.garageTitle);
        //hiding rating as it is not implemented ...
        tvGarageRating.setVisibility(View.INVISIBLE);
        btnHire = findViewById(R.id.btnHire);
        getValuesFromIntentAndSetText();

        btnHire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postRequestCall();
            }
        });








    }

    private void getValuesFromIntentAndSetText() {
        try {
            garageName = getIntent().getStringExtra("name");
            garage_id = getIntent().getStringExtra("garage_id");
            feature_id = getIntent().getStringExtra("feature_id");
            featureName = getIntent().getStringExtra("feature_name");
            phoneNo = getIntent().getStringExtra("garage_phone");

            tvGarageNumber.setText(phoneNo);
            tvGarageName.setText(garageName);

        } catch (Exception ex) {
            Toast.makeText(this, "No data fetched from Intent ...", Toast.LENGTH_SHORT).show();
        }
    }

    private void postRequestCall() {
        RequestBLL requestBLL = new RequestBLL(feature_id, garage_id);
        if (requestBLL.checkPostRequest()) {
        Intent i = new Intent(this, user_dashboard.class);
        startActivity(i);
        } else {
            Toast.makeText(this, "postRequestCall failed ..", Toast.LENGTH_SHORT).show();
        }

    }
}