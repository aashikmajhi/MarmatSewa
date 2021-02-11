package com.example.marmatsewa.UserInterface;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.marmatsewa.GarageDashboard.garageDashboard;
import com.example.marmatsewa.R;
import com.example.marmatsewa.Registration.LoginActivity;
import com.example.marmatsewa.url.URL;

public class user_dashboard extends AppCompatActivity {

    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;

    private ImageView btnTwoWheel, btnFourWheel, btnNotification, btnUserProfile;
    private RecyclerView notificationRcView;

    private AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_dashboard);

        btnNotification = findViewById(R.id.btnNotification);
        notificationRcView = findViewById(R.id.notificationRcView);

        btnUserProfile = findViewById(R.id.btnUserProfile);

        btnNotification.setOnClickListener(v -> createNewNotificationPopup());

        btnUserProfile.setOnClickListener(v -> startActivity(new Intent(user_dashboard.this, user_profile_view.class)));

        builder = new AlertDialog.Builder(this);

        btnTwoWheel = findViewById(R.id.btnTwoWheel);

        btnTwoWheel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(new Intent(user_dashboard.this, user_two_wheel_services.class));
            }
        });

        btnFourWheel = findViewById(R.id.btnFourWheel);

        btnFourWheel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(user_dashboard.this, user_four_wheel_services.class));
            }
        });

    }

    public void createNewNotificationPopup() {
        dialogBuilder = new AlertDialog.Builder(this);
        final View notificationView = getLayoutInflater().inflate(R.layout.notification_popup, null);

        //TODO: assign notification card here

        dialogBuilder.setView(notificationView);
        dialog = dialogBuilder.create();
        dialog.show();

    }

}