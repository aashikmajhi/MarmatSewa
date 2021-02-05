package com.example.marmatsewa.UserInterface;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.marmatsewa.R;

public class user_profile_view extends AppCompatActivity {

    ImageView btnBack, userLogout;
    TextView tvUserFullName, tvUserEmail, tvUserPhone, tvUserAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile_view);
    }
}