package com.example.marmatsewa.UserInterface;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;

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
    private RadioGroup radioGroup;

    private ImageView btnTwoWheel, btnFourWheel, btnNotification, btnUserProfile;
    private RecyclerView notificationRcView;
    private NotificationManagerCompat notificationManagerCompat;

    private AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_dashboard);

        btnNotification = findViewById(R.id.btnNotification);
        notificationRcView = findViewById(R.id.notificationRcView);
        radioGroup = findViewById(R.id.radioGroup);

        btnUserProfile = findViewById(R.id.btnUserProfile);
        radioGroup = findViewById(R.id.radioGroup);
        btnTwoWheel = findViewById(R.id.btnTwoWheel);

        btnNotification.setOnClickListener(v -> createNewNotificationPopup());


        btnUserProfile.setOnClickListener(v -> startActivity(new Intent(user_dashboard.this, user_profile_view.class)));


        btnTwoWheel = findViewById(R.id.btnTwoWheel);

        btnTwoWheel.setOnClickListener(view -> startActivity(new Intent(user_dashboard.this, user_two_wheel_services.class)));

        btnFourWheel = findViewById(R.id.btnFourWheel);

        btnFourWheel.setOnClickListener(view -> startActivity(new Intent(user_dashboard.this, user_four_wheel_services.class)));

        btnTwoWheel.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), user_two_wheel_services.class);
            storeLoggedInStatusToSharedPreference();
            startActivity(intent);

        });

        btnFourWheel = findViewById(R.id.btnFourWheel);

        btnFourWheel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(user_dashboard.this,user_four_wheel_services.class);
                storeLoggedInStatusToSharedPreference();
                startActivity(intent);
            }
        });

        //notification
        notificationManagerCompat = NotificationManagerCompat.from(this);
        CreateChannel c = new CreateChannel(this);
        c.createChannel();


        showApprovedNotification();
        doneNotification();
    }
    private String getRadioButtonValue() {
        switch (radioGroup.getCheckedRadioButtonId()) {
            case R.id.rbDropInService:
                return "DROP IN SERVICE";
            case R.id.rbOnTheSpot:
                return "ON THE SPOT";
            case R.id.rbPickUpDelivery:
                return "PICKUP AND DELIVERY";
        }
        return "";

    }

    private void storeLoggedInStatusToSharedPreference() {
        SharedPreferences sharedPreferences = this.getSharedPreferences("USER_REQUEST", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("SERVICE_TYPES", getRadioButtonValue());
        editor.apply();
    }
    private String getRadioButtonValue() {
        switch (radioGroup.getCheckedRadioButtonId()) {
            case R.id.rbDropInService:
                return "DROP IN SERVICE";
            case R.id.rbOnTheSpot:
                return "ON THE SPOT";
            case R.id.rbPickUpDelivery:
                return "PICKUP AND DELIVERY";
        }
        return "";

    }

    private void storeLoggedInStatusToSharedPreference() {
        SharedPreferences sharedPreferences = this.getSharedPreferences("USER_REQUEST", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("SERVICE_TYPES", getRadioButtonValue());
        editor.apply();
    }





    public void createNewNotificationPopup(){
        dialogBuilder = new AlertDialog.Builder(this);
        final View notificationView = getLayoutInflater().inflate(R.layout.notification_popup, null);

        //TODO: assign notification card here

        dialogBuilder.setView(notificationView);
        dialog = dialogBuilder.create();
        dialog.show();

    }

    private void showApprovedNotification(){
        GarageRequestBLL approvedRequest = new GarageRequestBLL();
        URL.getStrictMode();

        List<RequestResponse> approveRequestList = approvedRequest.getApprovedRequest();
        String garagename = null, servicename = null;

        System.out.println(approveRequestList.size());
        if (approveRequestList.size() == 0 ) {
            return;
        }

        //if (approveRequestList.size() > 0) {
            for (RequestResponse r : approveRequestList) {
                garagename = r.getGarageOwner().getBusinessName();
                servicename = r.getFeature().getFeature();
            }
            NotificationCompat.Builder notification = new NotificationCompat.Builder(this, CreateChannel.approved)
                    .setSmallIcon(R.drawable.ic_baseline_notifications_24)
                    .setContentTitle("Approved")
                    .setContentText("Your request of : " + servicename + " is approved by " + garagename)
                    .setCategory(NotificationCompat.CATEGORY_MESSAGE);

            notificationManagerCompat.notify(2, notification.build());
       // }

    }

    private void doneNotification(){
        GarageRequestBLL doneRequest = new GarageRequestBLL();
        URL.getStrictMode();

        List<RequestResponse> doneRequestList = doneRequest.getDoneRequests();
        String garageName = null, servicename = null;
        if(doneRequestList.size() == 0) {
            return;
        }
        //if (doneRequestList.size() > 0) {
            for (RequestResponse dr : doneRequestList) {
                garageName = dr.getGarageOwner().getBusinessName();
                servicename = dr.getFeature().getFeature();
            }
            NotificationCompat.Builder notification = new NotificationCompat.Builder(this, CreateChannel.completed)
                    .setSmallIcon(R.drawable.ic_baseline_notifications_24)
                    .setContentTitle("Serivce Completed")
                    .setContentText("Your Request for " + servicename + " is completed and done by " + garageName)
                    .setCategory(NotificationCompat.CATEGORY_MESSAGE);

            notificationManagerCompat.notify(3, notification.build());

       // }
    }

}