package com.example.marmatsewa.Dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.marmatsewa.R;
import com.example.marmatsewa.Registration.LoginActivity;
import com.example.marmatsewa.Registration.RegistrationType;
import com.example.marmatsewa.Registration.userRegistration;

public class TwoWheelerServices extends AppCompatActivity {

    ImageView backbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_wheeler_services);

        backbtn=findViewById(R.id.btnBack);

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(TwoWheelerServices.this, "Back Button Pressed", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(TwoWheelerServices.this,GarageServices.class);
                startActivity(intent);
            }
        });

    }
}