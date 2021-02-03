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

import com.example.marmatsewa.GarageDashboard.customerRequest;
import com.example.marmatsewa.R;
import com.example.marmatsewa.Registration.garageRegistrationBusinessInfo;
import com.example.marmatsewa.Registration.garageRegistrationPersonalInfo;
import com.example.marmatsewa.notificationChannel.createChannel;

public class user_hiring_page extends AppCompatActivity {

    Button btnHire;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_hiring_page);

        btnHire = findViewById(R.id.btnHire);

        btnHire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //notification
                Intent i = new Intent(user_hiring_page.this, customerRequest.class);
                i.putExtra("Username", "true");
                startActivity(i);
            }
        });
    }
}