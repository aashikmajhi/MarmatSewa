package com.example.marmatsewa.AdminInterface;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.marmatsewa.Dashboard.GarageServices;
import com.example.marmatsewa.R;

public class admin_services extends AppCompatActivity {

    ImageView btnTwoWheeler, btnFourWheeler;

    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_services);


        drawerLayout = findViewById(R.id.drawer_layout);

        btnTwoWheeler=findViewById(R.id.btnTwoWheeler);
        btnFourWheeler=findViewById(R.id.btnFourWheeler);

        btnTwoWheeler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(admin_services.this, TwoWheelerServices.class);
                startActivity(intent);

            }
        });

        btnFourWheeler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(admin_services.this, FourWheelerServices.class);
                startActivity(intent);
            }
        });
    }
}