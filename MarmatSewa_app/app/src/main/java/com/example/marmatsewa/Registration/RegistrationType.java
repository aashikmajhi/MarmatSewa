package com.example.marmatsewa.Registration;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.marmatsewa.R;

public class RegistrationType extends AppCompatActivity {


    private ImageView btnUser, btnGarage;
    private TextView btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_type);

        btnUser = findViewById(R.id.btnUser);
        btnGarage = findViewById(R.id.btnGarage);
        btnBack = findViewById(R.id.btnBack);

        //TODO go to userRegistration form when btnUser clicked
        //TODO go to workshopRegistration form when btnGarage clicked

        //TODO go to login page when btnBack clicked



    }
}