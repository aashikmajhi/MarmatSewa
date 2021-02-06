package com.example.marmatsewa.UserInterface;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.marmatsewa.GarageDashboard.garageDashboard;
import com.example.marmatsewa.R;
import com.example.marmatsewa.Registration.LoginActivity;
import com.example.marmatsewa.Registration.UserRegistrationDevelopment.User;
import com.example.marmatsewa.UserInterface.UserProfileDevelopment.UserProfileBLL;
import com.example.marmatsewa.url.URL;

public class user_profile_view extends AppCompatActivity {

    private ImageView btnBack, userLogout;
    private TextView tvUserFullName, tvUserEmail, tvUserPhone, tvUserAddress;
    private User user;
    private AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile_view);

        tvUserFullName = findViewById(R.id.tvUserFullName);
        tvUserEmail = findViewById(R.id.tvUserEmail);
        tvUserPhone = findViewById(R.id.tvUserPhone);
        tvUserAddress = findViewById(R.id.tvUserAddress);

        btnBack = findViewById(R.id.btnBack);
        userLogout = findViewById(R.id.userLogout);

        loadUserProfile();

        btnBack.setOnClickListener(v -> {
            startActivity(new Intent(user_profile_view.this, user_dashboard.class));
        });

        builder = new AlertDialog.Builder(this);
        userLogout.setOnClickListener(v -> {
            builder.setTitle("Logout")
                    .setMessage("Are you sure?")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            URL.token = "";
                            URL.role = "";
                            URL.user_id = "";
                            garageDashboard.redirectActivity(user_profile_view.this, LoginActivity.class);
                        }
                    });
            builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });

            builder.show();
        });
    }

    private void loadUserProfile() {
        UserProfileBLL userProfileBLL = new UserProfileBLL(URL.user_id);
        user = userProfileBLL.getUserProfile();
        URL.getStrictMode();

        tvUserFullName.setText(user.getFullname().toString());
        tvUserEmail.setText(user.getEmail());
        tvUserPhone.setText(user.getPhoneNo());
        tvUserAddress.setText(user.getAddress());
    }
}