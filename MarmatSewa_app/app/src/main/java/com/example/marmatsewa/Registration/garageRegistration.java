package com.example.marmatsewa.Registration;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.marmatsewa.R;
import com.example.marmatsewa.Registration.WorkshopRegistrationDevelopment.Workshop;
import com.example.marmatsewa.Registration.WorkshopRegistrationDevelopment.WorkshopBLL;
import com.example.marmatsewa.url.URL;

public class garageRegistration extends AppCompatActivity {

    private ImageView backBtn, btnNext;
    private EditText edtGarageEmail, edtGaragePassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_garage_registration);


        btnNext = findViewById(R.id.btnNext);
        //TODO intent to garageRegistrationPersonalInfo if the fields are filled..

        backBtn = findViewById(R.id.backBtn);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(garageRegistration.this, RegistrationType.class);
                startActivity(intent);
            }
        });

//        btnRegisterWorkshop.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                if(checkBoxControlBrake.isChecked()){
//                    isCheckBoxControlBrake = true;
//                }
//                if(checkBoxElectrical.isChecked()) {
//                    isCheckBoxElectrical = true;
//                }
//                if(checkBoxFuelAir.isChecked()) {
//                    isCheckBoxFuelAir = true;
//                }
//                if(checkBoxWheelDrives.isChecked()) {
//                    isCheckBoxWheelDrives = true;
//                }
//                registerWorkshop();
//                Toast.makeText(garageRegistration.this, "workshop registered", Toast.LENGTH_SHORT).show();
//
//            }
//        });
    }

//
//    private void registerWorkshop() {
//
//        Workshop workshop = new Workshop(
//                garageName.getText().toString(),
//                edtContactName.getText().toString(),
//                "email@abc.com",
//                "password",
//                edtLocation.getText().toString(),
//                edtNumber.getText().toString(),
//                edtRegType.getText().toString(),
//                edtPanNo.getText().toString(),
//                "registrationdoc",
//                isCheckBoxControlBrake,
//                isCheckBoxElectrical,
//                isCheckBoxFuelAir,
//                isCheckBoxWheelDrives
//                );
//
//        WorkshopBLL workshopBLL = new WorkshopBLL(workshop);
//        URL.getStrictMode();
//
//        if (workshopBLL.isRegisterWorkshop()) {
//            Toast.makeText(this, "Workshop registered successfully!", Toast.LENGTH_SHORT).show();
//        }
//        else {
//            Toast.makeText(this, "error: something went wrong!", Toast.LENGTH_SHORT).show();
//        }
//    }
}