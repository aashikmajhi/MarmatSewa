package com.example.marmatsewa.GarageDashboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.marmatsewa.GarageDashboard.GarageRequestDevelopment.GarageRequestBLL;
import com.example.marmatsewa.GarageDashboard.GarageRequestDevelopment.GarageRequestResponse;
import com.example.marmatsewa.R;
import com.example.marmatsewa.Registration.LoginActivity;
import com.example.marmatsewa.Registration.garageRegistrationBusinessInfo;
import com.example.marmatsewa.RequestDevelopment.RequestBLL;
import com.example.marmatsewa.notificationChannel.CreateChannel;
import com.example.marmatsewa.url.URL;

import java.util.List;

public class garageDashboard extends AppCompatActivity {

    //Initialize variable
    private androidx.appcompat.app.AlertDialog.Builder dialogBuilder;
    private androidx.appcompat.app.AlertDialog dialog;

    DrawerLayout drawerLayout;

    private Button btnAddgarageService;

    private NotificationManagerCompat notificationManagerCompat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_garage_dashboard);

        //Assign variable
        drawerLayout = findViewById(R.id.drawer_layout);


        btnAddgarageService = findViewById(R.id.btnAddgarageService);

        //notification
        notificationManagerCompat = NotificationManagerCompat.from(this);
        CreateChannel c = new CreateChannel(this);
        c.createChannel();
        NewRequest();

        btnAddgarageService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(garageDashboard.this, garageRegistrationBusinessInfo.class));
            }
        });

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


    public void ClickProfile(View view) {
        garageDashboard.redirectActivity(this, GarageProfile.class);
    }

    public void ClickDashboard(View view){
        recreate();
    }


    public void ClickRequest(View view){
        redirectActivity(this,customerRequest.class);
    }

    public void ClickLog(View view){
        redirectActivity(this,Request_Log_Activity.class);
    }

    public void ClickServices(View view) {
        garageDashboard.redirectActivity(this, GarageServices.class);
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
                URL.token="";
                URL.role="";
                URL.user_id="";

                garageDashboard.redirectActivity(activity, LoginActivity.class);
                //activity.finishAffinity();
               // System.exit(0);
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

    public void newRequest(){
        dialogBuilder = new androidx.appcompat.app.AlertDialog.Builder(this);
        final View notificationView = getLayoutInflater().inflate(R.layout.notification_popup, null);

        //TODO: assign notification card here

        dialogBuilder.setView(notificationView);
        dialog = dialogBuilder.create();
        dialog.show();
    }


    private void NewRequest(){
        GarageRequestBLL pendindRequest = new GarageRequestBLL();
        URL.getStrictMode();

        List<GarageRequestResponse> pendingRequestList = pendindRequest.getPendingRequests();
        String username = null, servicename = null;
        if (pendingRequestList.size() >= 0) {
            for (GarageRequestResponse grr : pendingRequestList) {
                username = grr.getUser().getFullname();
                servicename = grr.getFeature().getFeature();
            }
            NotificationCompat.Builder notification = new NotificationCompat.Builder(this, CreateChannel.hire)
                    .setSmallIcon(R.drawable.ic_baseline_notifications_24)
                    .setContentTitle("New Request")
                    .setContentText("New Request from : " + username + "  For service: " + servicename)
                    .setCategory(NotificationCompat.CATEGORY_MESSAGE);

            notificationManagerCompat.notify(1, notification.build());

        }
    }
}