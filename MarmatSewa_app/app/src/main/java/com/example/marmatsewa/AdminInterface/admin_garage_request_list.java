package com.example.marmatsewa.AdminInterface;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;

import com.example.marmatsewa.R;

public class admin_garage_request_list extends AppCompatActivity {

    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_garage_request_list);

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
        admin_dash.redirectActivity(this, admin_garage_list.class);
    }

    public void ClickAdminServices(View view) {
        admin_dash.redirectActivity(this, admin_services.class);
    }

    public void ClickAdminRequestList(View view){
        recreate();
    }

    public void ClickLogout(View view){
        admin_dash.logout(this);
    }

    protected void onPause(){
        super.onPause();
        admin_dash.closeDrawer(drawerLayout);

    }

}