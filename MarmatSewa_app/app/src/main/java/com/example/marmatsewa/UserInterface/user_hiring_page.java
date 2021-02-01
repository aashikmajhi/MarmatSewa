package com.example.marmatsewa.UserInterface;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.marmatsewa.R;
import com.example.marmatsewa.Registration.garageRegistrationBusinessInfo;
import com.example.marmatsewa.Registration.garageRegistrationPersonalInfo;
import com.example.marmatsewa.notificationChannel.createChannel;

public class user_hiring_page extends AppCompatActivity {

    Button btnHire;

    NotificationManagerCompat notificationManagerCompat;
    Notification.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_hiring_page);

        notificationManagerCompat = NotificationManagerCompat.from(this);

        btnHire=findViewById(R.id.btnHire);

        btnHire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                hire();
            }
        });
    }

    private void hire() {
        NotificationCompat.Builder notification = new NotificationCompat.Builder(this, createChannel.hire)
                .setContentTitle("New Request!!")
                .setContentText("New Service Request")
                .setCategory(NotificationCompat.CATEGORY_MESSAGE);

        notificationManagerCompat.notify(1, notification.build());
    }

}