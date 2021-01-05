package com.example.marmatsewa.AdminInterface;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;

import com.example.marmatsewa.Dashboard.GarageServices;
import com.example.marmatsewa.GarageDashboard.GarageProfile;
import com.example.marmatsewa.GarageDashboard.customerRequest;
import com.example.marmatsewa.GarageDashboard.garageDashboard;
import com.example.marmatsewa.R;

public class admin_garage_list extends AppCompatActivity {

    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_garage_list);

        drawerLayout = findViewById(R.id.drawer_layout);
    }

    public void  ClickMenu(View view){
        //Open Drawer
        admin_dash.openDrawer(drawerLayout);
    }

    public  void ClickLogo(View view){
        //Close drawer
        admin_dash.closeDrawer(drawerLayout);
    }

    public void ClickAdminDashboard(View view){
        admin_dash.redirectActivity(this, admin_dash.class);
    }

    public void ClickAdminGarageList(View view){
        recreate();
    }

    public void ClickAdminServices(View view) {
        admin_dash.redirectActivity(this, admin_services.class);
    }

    public void ClickAdminRequestList(View view){
        admin_dash.redirectActivity(this, admin_garage_request_list.class);
    }

    public void ClickLogout(View view){
        admin_dash.logout(this);
    }

    protected void onPause(){
        super.onPause();
        admin_dash.closeDrawer(drawerLayout);

    }


}