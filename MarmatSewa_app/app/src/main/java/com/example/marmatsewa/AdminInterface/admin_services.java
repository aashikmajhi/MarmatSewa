package com.example.marmatsewa.AdminInterface;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

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
                Intent intent = new Intent(admin_services.this, adminTwoWheelerServices.class);
                startActivity(intent);

            }
        });

        btnFourWheeler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(admin_services.this, adminFourWheelerServices.class);
                startActivity(intent);
            }
        });

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