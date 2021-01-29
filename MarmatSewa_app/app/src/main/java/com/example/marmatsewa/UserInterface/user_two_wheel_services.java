package com.example.marmatsewa.UserInterface;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.marmatsewa.R;

public class user_two_wheel_services extends AppCompatActivity {

    private ImageView btnback2wheelservice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_two_wheel_services);

        btnback2wheelservice=findViewById(R.id.btnback2wheelservice);

        btnback2wheelservice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(user_two_wheel_services.this,user_dashboard.class));
            }
        });
    }
}