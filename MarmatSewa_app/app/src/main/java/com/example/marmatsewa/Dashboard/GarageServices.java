package com.example.marmatsewa.Dashboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.marmatsewa.GarageDashboard.GarageProfile;
import com.example.marmatsewa.GarageDashboard.Request_Log_Activity;
import com.example.marmatsewa.GarageDashboard.customerRequest;
import com.example.marmatsewa.GarageDashboard.garageDashboard;
import com.example.marmatsewa.R;

public class GarageServices extends AppCompatActivity {
    ImageView btnTwoWheeler, btnFourWheeler;

    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_garage_services);

        drawerLayout = findViewById(R.id.drawer_layout);

        btnTwoWheeler=findViewById(R.id.btnTwoWheeler);
        btnFourWheeler=findViewById(R.id.btnFourWheeler);

//        btnTwoWheeler=findViewById(R.id.btnTwoWheeler);
//        btnFourWheeler=findViewById(R.id.btnFourWheeler);


        btnTwoWheeler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GarageServices.this, TwoWheelerServices.class);
                startActivity(intent);

            }
        });

        btnFourWheeler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GarageServices.this, FourWheelerServices.class);
                startActivity(intent);
            }
        });

    }

    //Integrating SideNav (START)
    public void ClickMenu(View view) {
        //Open Drawer
        garageDashboard.openDrawer(drawerLayout);
    }

    public void ClickLogo(View view) {
        //Close drawer
        garageDashboard.closeDrawer(drawerLayout);
    }

    public void ClickProfile(View view){
        garageDashboard.redirectActivity(this, GarageProfile.class);
    }


    public void ClickDashboard(View view) {
        garageDashboard.redirectActivity(this, garageDashboard.class);
    }

    public void ClickRequest(View view) {
        garageDashboard.redirectActivity(this, customerRequest.class);
    }

    public void ClickServices(View v) {
        recreate();
//        switch (v.getId()){
//            case R.id.btnTwoWheeler:
//                i=new Intent(this,TwoWheelerServices.class);
//                startActivity(i);
//                break;
//
//            case R.id.btnFourWheeler:
//                i=new Intent(this,FourWheelerServices.class);
//                startActivity(i);
//                break;
    }


    public void ClickLog(View view) {
        garageDashboard.redirectActivity(this, Request_Log_Activity.class);
    }


    public void ClickLogout(View view) {
        garageDashboard.logout(this);
    }

    protected void onPause() {
        super.onPause();
        garageDashboard.closeDrawer(drawerLayout);
    }
    //Integrating SideNav (FINISH)
}