package com.example.marmatsewa.GarageDashboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.marmatsewa.Dashboard.GarageServices;
import com.example.marmatsewa.R;

public class customerRequest extends AppCompatActivity {

    DrawerLayout drawerLayout;

    private RecyclerView rcView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_request);

        drawerLayout = findViewById(R.id.drawer_layout);

    }

    public void  ClickMenu(View view){
        //Open Drawer
        garageDashboard.openDrawer(drawerLayout);
    }

    public  void ClickLogo(View view){
        //Close drawer
        garageDashboard.closeDrawer(drawerLayout);
    }

    public void ClickProfile(View view) {
        garageDashboard.redirectActivity(this, GarageProfile.class);
    }

    public void ClickDashboard(View view){
        garageDashboard.redirectActivity(this, garageDashboard.class);
    }

    public void ClickRequest(View view){
        recreate();
    }

    public void ClickServices(View view) {
        garageDashboard.redirectActivity(this, GarageServices.class);
    }

    public void ClickLog(View view){
        garageDashboard.redirectActivity(this, Request_Log_Activity.class);
    }


    public void ClickLogout(View view){
        garageDashboard.logout(this);
    }

    protected void onPause(){
        super.onPause();
        garageDashboard.closeDrawer(drawerLayout);

    }
}