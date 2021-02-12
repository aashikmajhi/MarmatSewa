package com.example.marmatsewa.Dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.marmatsewa.R;
import com.example.marmatsewa.Registration.RegistrationType;
import com.example.marmatsewa.Registration.userRegistration;

public class TwoWheelerServices extends AppCompatActivity {

    ImageView backbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_wheeler_services);

        backbtn=findViewById(R.id.backBtn);

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(TwoWheelerServices.this,GarageServices.class);
                startActivity(i);
            }
        });
    }
}