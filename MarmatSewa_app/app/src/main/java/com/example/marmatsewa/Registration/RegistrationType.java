package com.example.marmatsewa.Registration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.marmatsewa.R;

public class RegistrationType extends AppCompatActivity {


    private ImageView btnUser, btnGarage, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_type);

        btnUser = findViewById(R.id.btnUser);
        btnGarage = findViewById(R.id.btnGarage);
        btnBack = findViewById(R.id.btnBack);

        //TODO go to userRegistration form when btnUser clicked
        btnUser.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(RegistrationType.this, userRegistration.class);
                        startActivity(intent);
                    }
                });


        //TODO go to workshopRegistration form when btnGarage clicked

        btnGarage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegistrationType.this, workshopRegistration.class);
                startActivity(intent);
            }
        });

        //TODO go to login page when btnBack clicked

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegistrationType.this, LoginActivity.class);
                startActivity(intent);
            }
        });


    }
}