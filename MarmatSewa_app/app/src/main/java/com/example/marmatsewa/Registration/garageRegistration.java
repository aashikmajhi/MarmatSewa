package com.example.marmatsewa.Registration;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
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

import java.util.ArrayList;
import java.util.List;

public class garageRegistration extends AppCompatActivity {


    private ImageView backBtn, btnNext;
    private EditText edtGarageEmail, edtGaragePassword;

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    private Spinner spinner;
    String[] categories = {"TWO WHEEL", "FOUR WHEEL", "BOTH"};
    private String category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_garage_registration);

        edtGarageEmail = findViewById(R.id.edtGarageEmail);
        edtGaragePassword = findViewById(R.id.edtGaragePassword);

        backBtn = findViewById(R.id.backBtn);
        btnNext = findViewById(R.id.btnNext);

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

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(garageRegistration.this, RegistrationType.class);
                startActivity(intent);
            }
        });

        sharedPreferences = getApplicationContext().getSharedPreferences("Workshop",0);
        editor = sharedPreferences.edit();

       btnNext.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               if(validate()) {
                   editor.putString("garageEmail", edtGarageEmail.getText().toString());
                   editor.putString("garagePassword", edtGaragePassword.getText().toString());
                   editor.putString("category", category);
                   editor.commit();

                   startActivity(new Intent(garageRegistration.this, garageRegistrationPersonalInfo.class));
               }
           }
       });

    }

    public boolean validate() {
        boolean flag = true;
        if(TextUtils.isEmpty(edtGarageEmail.getText().toString())) {
            edtGarageEmail.requestFocus();
            edtGarageEmail.setError("Please enter the garage email");
            flag = false;
        }
        else if(TextUtils.isEmpty(edtGaragePassword.getText().toString())) {
            edtGaragePassword.requestFocus();
            edtGaragePassword.setError("Please enter the password");
            flag = false;
        }
        return flag;
    }
}