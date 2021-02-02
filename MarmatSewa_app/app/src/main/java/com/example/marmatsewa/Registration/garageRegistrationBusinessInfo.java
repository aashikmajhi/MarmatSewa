package com.example.marmatsewa.Registration;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.marmatsewa.AdminInterface.SeviceDevelopment.Service;
import com.example.marmatsewa.AdminInterface.SeviceDevelopment.ServiceBLL;
import com.example.marmatsewa.AdminInterface.adapter.ServiceAdapter;
import com.example.marmatsewa.GarageDashboard.garageDashboard;
import com.example.marmatsewa.R;
import com.example.marmatsewa.Registration.WorkshopRegistrationDevelopment.UserServiceApdater;
import com.example.marmatsewa.Registration.WorkshopRegistrationDevelopment.Workshop;
import com.example.marmatsewa.Registration.WorkshopRegistrationDevelopment.WorkshopBLL;
import com.example.marmatsewa.url.URL;

import java.util.List;

public class garageRegistrationBusinessInfo extends AppCompatActivity {

    private ImageView backBtn;

    private RecyclerView serviceRcView;
    private List<Service> serviceList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_garage_registration_business_info);

        //button reference
        backBtn = findViewById(R.id.backBtn);

        serviceRcView = findViewById(R.id.serviceRcView);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(garageRegistrationBusinessInfo.this, garageDashboard.class);
                startActivity(intent);
            }
        });

        serviceRcView.setLayoutManager(new LinearLayoutManager(this));
        loadService();

    }

    private void loadService() {
        ServiceBLL serviceBLL = new ServiceBLL();
        URL.getStrictMode();

        serviceList = serviceBLL.getServices();
        UserServiceApdater userServiceApdater = new UserServiceApdater(this, serviceList);
        serviceRcView.setAdapter(userServiceApdater);
    }
}


