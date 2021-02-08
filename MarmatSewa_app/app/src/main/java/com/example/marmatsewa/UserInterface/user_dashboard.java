package com.example.marmatsewa.UserInterface;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
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

import com.example.marmatsewa.GarageDashboard.garageDashboard;
import com.example.marmatsewa.R;
import com.example.marmatsewa.Registration.LoginActivity;
import com.example.marmatsewa.url.URL;

public class user_dashboard extends AppCompatActivity {

    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;
    private RadioGroup radioGroup;

    private ImageView btnTwoWheel, btnFourWheel, btnNotification, userLogout;
    private RecyclerView notificationRcView;

    private AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_dashboard);

        btnNotification = findViewById(R.id.btnNotification);
        notificationRcView = findViewById(R.id.notificationRcView);
        radioGroup = findViewById(R.id.radioGroup);

        userLogout = findViewById(R.id.userLogout);

        btnNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createNewNotificationPopup();
            }
        });

        builder = new AlertDialog.Builder(this);

//        userLogout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                builder.setTitle("Logout")
//                        .setMessage("Are you sure?")
//                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                URL.token = "";
//                                URL.role = "";
//                                URL.user_id = "";
//                                garageDashboard.redirectActivity(user_dashboard.this, LoginActivity.class);
//                            }
//                        });
//                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        dialog.dismiss();
//                    }
//                });
//
//                builder.show();
//            }
//        });

        btnTwoWheel = findViewById(R.id.btnTwoWheel);

        btnTwoWheel.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), user_two_wheel_services.class);
                storeLoggedInStatusToSharedPreference();
                startActivity(intent);
            }
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

}