package com.example.marmatsewa.UserInterface;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.marmatsewa.GarageDashboard.GarageRequestDevelopment.GarageRequestBLL;
import com.example.marmatsewa.GarageDashboard.GarageRequestDevelopment.GarageRequestResponse;
import com.example.marmatsewa.GarageDashboard.GarageRequestDevelopment.RequestResponse;
import com.example.marmatsewa.GarageDashboard.garageDashboard;
import com.example.marmatsewa.R;
import com.example.marmatsewa.Registration.LoginActivity;
import com.example.marmatsewa.notificationChannel.CreateChannel;
import com.example.marmatsewa.url.URL;

import java.util.List;

public class user_dashboard extends AppCompatActivity {

    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;

    private ImageView btnTwoWheel, btnFourWheel, btnNotification, btnUserProfile;
    private RecyclerView notificationRcView;

    private AlertDialog.Builder builder;
    private NotificationManagerCompat notificationManagerCompat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_dashboard);

        btnNotification = findViewById(R.id.btnNotification);
        notificationRcView = findViewById(R.id.notificationRcView);

        btnUserProfile = findViewById(R.id.btnUserProfile);

        btnNotification.setOnClickListener(v -> createNewNotificationPopup());

        btnUserProfile.setOnClickListener(v -> startActivity(new Intent(user_dashboard.this, user_profile_view.class)));

        builder = new AlertDialog.Builder(this);

        btnTwoWheel = findViewById(R.id.btnTwoWheel);

        btnTwoWheel.setOnClickListener(view -> startActivity(new Intent(user_dashboard.this, user_two_wheel_services.class)));

        btnFourWheel = findViewById(R.id.btnFourWheel);

        btnFourWheel.setOnClickListener(view -> startActivity(new Intent(user_dashboard.this, user_four_wheel_services.class)));

        //notification
        notificationManagerCompat = NotificationManagerCompat.from(this);
        CreateChannel c = new CreateChannel(this);
        c.createChannel();

        showApprovedNotification();
        doneNotification();
    }

    public void createNewNotificationPopup() {
        dialogBuilder = new AlertDialog.Builder(this);
        final View notificationView = getLayoutInflater().inflate(R.layout.notification_popup, null);

        //TODO: assign notification card here

        dialogBuilder.setView(notificationView);
        dialog = dialogBuilder.create();
        dialog.show();

    }

    private void showApprovedNotification(){
        GarageRequestBLL pendindRequest = new GarageRequestBLL();
        URL.getStrictMode();

        List<RequestResponse> approveRequestList = pendindRequest.getApprovedRequests();
        String garagename = null, servicename = null;
        if (approveRequestList.size() >= 0) {
            for (RequestResponse r : approveRequestList) {
                garagename = r.getWorkshop().getBusinessName();
                servicename = r.getFeature().getFeature();
            }
            NotificationCompat.Builder notification = new NotificationCompat.Builder(this, CreateChannel.approved)
                    .setSmallIcon(R.drawable.ic_baseline_notifications_24)
                    .setContentTitle("Approved")
                    .setContentText("Your request of : " + servicename + " is approved by " + garagename)
                    .setCategory(NotificationCompat.CATEGORY_MESSAGE);

            notificationManagerCompat.notify(2, notification.build());

        }
    }

    private void doneNotification(){
        GarageRequestBLL doneRequest = new GarageRequestBLL();
        URL.getStrictMode();

        List<RequestResponse> doneRequestList = doneRequest.getDoneRequests();
        String garageName = null, servicename = null;
        if (doneRequestList.size() >= 0) {
            for (RequestResponse dr : doneRequestList) {
                garageName = dr.getWorkshop().getBusinessName();
                servicename = dr.getFeature().getFeature();
            }
            NotificationCompat.Builder notification = new NotificationCompat.Builder(this, CreateChannel.completed)
                    .setSmallIcon(R.drawable.ic_baseline_notifications_24)
                    .setContentTitle("Serivce Completed")
                    .setContentText("Your Request for " + servicename + " is completed and done by " + garageName)
                    .setCategory(NotificationCompat.CATEGORY_MESSAGE);

            notificationManagerCompat.notify(3, notification.build());

        }
    }

}