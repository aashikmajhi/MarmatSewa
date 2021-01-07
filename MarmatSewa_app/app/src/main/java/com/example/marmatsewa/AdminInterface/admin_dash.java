package com.example.marmatsewa.AdminInterface;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.marmatsewa.R;

public class admin_dash extends AppCompatActivity {

    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dash);

        drawerLayout = findViewById(R.id.drawer_layout);
    }

    public void  ClickMenu(View view){
        //Open Drawer
        openDrawer(drawerLayout);
    }

    public static void openDrawer(DrawerLayout drawerLayout) {
        //Open Drawer layout
        drawerLayout.openDrawer(GravityCompat.START);
    }

    public  void ClickLogo(View view){
        //Close drawer
        closeDrawer(drawerLayout);
    }

    public static void closeDrawer(DrawerLayout drawerLayout) {
        //Close drawer layout
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    public void ClickAdminDashboard(View view){
        recreate();
    }

    public void ClickAdminServices(View view) {
        admin_dash.redirectActivity(this, admin_services.class);
    }

    public void ClickAdminGarageList(View view){
        redirectActivity(this, admin_garage_list.class);
    }

    public void ClickAdminRequestList(View view){
        redirectActivity(this, admin_garage_request_list.class);
    }

    public void ClickLogout(View view){
        logout(this);
    }

    public static void logout(Activity activity) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);

        builder.setTitle("Logout");

        builder.setMessage("Are you sure you want to logout ?");

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                activity.finishAffinity();

                System.exit(0);
            }
        });

        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builder.show();

    }




    public static void redirectActivity(Activity activity, Class aClass) {
        Intent intent = new Intent(activity, aClass);

        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        activity.startActivity(intent);
    }
    protected void onPause(){
        super.onPause();
        closeDrawer(drawerLayout);
    }

}