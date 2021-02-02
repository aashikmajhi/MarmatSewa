package com.example.marmatsewa.UserInterface;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.marmatsewa.R;

public class user_four_wheel_services extends AppCompatActivity {
    private ImageView btnback4wheelservice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_four_wheel_services);

        btnback4wheelservice=findViewById(R.id.btnback4wheelservice);

        btnback4wheelservice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(user_four_wheel_services.this,user_dashboard.class));
            }
        });
    }
}