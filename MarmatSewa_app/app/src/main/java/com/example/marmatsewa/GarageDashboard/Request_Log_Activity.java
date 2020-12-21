package com.example.marmatsewa.GarageDashboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.marmatsewa.R;

public class Request_Log_Activity extends AppCompatActivity {

    private RecyclerView rcView;

    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_log);

        drawerLayout=findViewById(R.id.drawer_layout);
    }

    public void  ClickMenu(View view){
        //Open Drawer
        garageDashboard.openDrawer(drawerLayout);
    }

    public  void ClickLogo(View view){
        //Close drawer
        garageDashboard.closeDrawer(drawerLayout);
    }

    public void ClickDashboard(View view){
        garageDashboard.redirectActivity(this, garageDashboard.class);
    }

    public void ClickRequest(View view){
        garageDashboard.redirectActivity(this, customerRequest.class);
    }

    //TODO SERVICES

    public void ClickLog(View view){
        recreate();
    }

    public void ClickLogout(View view){
        garageDashboard.logout(this);
    }

    protected void onPause(){
        super.onPause();
        garageDashboard.closeDrawer(drawerLayout);

    }
}