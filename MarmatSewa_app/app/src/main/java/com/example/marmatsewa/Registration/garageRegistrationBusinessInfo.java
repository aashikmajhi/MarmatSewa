package com.example.marmatsewa.Registration;

import androidx.appcompat.app.AppCompatActivity;

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

import com.example.marmatsewa.R;
import com.example.marmatsewa.Registration.WorkshopRegistrationDevelopment.Workshop;
import com.example.marmatsewa.Registration.WorkshopRegistrationDevelopment.WorkshopBLL;
import com.example.marmatsewa.url.URL;

public class garageRegistrationBusinessInfo extends AppCompatActivity {

    private ImageView btnRegisterWorkshop, backBtn;
    private TextView register;


    private Spinner spinner;
    String[] categories = {"TWO WHEEL", "FOUR WHEEL", "BOTH"};
    private String category;

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    private String garageName, garageContactName, garageEmail, garagePassword, garageLocation, garageNumber, garageRegType, garagePan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_garage_registration_business_info);


        //button reference
        backBtn = findViewById(R.id.backBtn);
        btnRegisterWorkshop = findViewById(R.id.btnRegisterWorkshop);
        register = findViewById(R.id.register);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(garageRegistrationBusinessInfo.this, garageRegistrationPersonalInfo.class);
                startActivity(intent);
            }
        });

        //Dropdown list for the garage registration form..
        spinner = (Spinner) findViewById(R.id.spinner);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, categories);

        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    category = spinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        sharedPreferences = getApplicationContext().getSharedPreferences("Workshop",0);

        garageName = sharedPreferences.getString("garageName", null);
        garageContactName = sharedPreferences.getString("garageContactName", null);
        garageEmail = sharedPreferences.getString("garageEmail", null);
        garagePassword = sharedPreferences.getString("garagePassword", null);
        garageLocation = sharedPreferences.getString("garageLocation", null);
        garageNumber = sharedPreferences.getString("garageNumber", null);
        garageRegType = sharedPreferences.getString("garageRegType", null);
        garagePan = sharedPreferences.getString("garagePan", null);

    }

    private void registerWorkshop() {

        Workshop workshop = new Workshop(
                garageName,
                garageContactName,
                garageEmail,
                garagePassword,
                garageLocation,
                garageNumber,
                garageRegType,
                garagePan,
                "registrationdoc",
                "APPROVED",
                27.6946843,
                85.3310636,
                category
        );

        WorkshopBLL workshopBLL = new WorkshopBLL(workshop);
        URL.getStrictMode();

        if (workshopBLL.isRegisterWorkshop()) {
            Toast.makeText(this, "Workshop registered successfully!", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(garageRegistrationBusinessInfo.this, LoginActivity.class));
        }
        else {
            Toast.makeText(this, "error: something went wrong!", Toast.LENGTH_SHORT).show();
        }
    }
}


