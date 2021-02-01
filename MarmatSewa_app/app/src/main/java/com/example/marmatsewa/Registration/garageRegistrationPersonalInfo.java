package com.example.marmatsewa.Registration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.marmatsewa.R;
import com.example.marmatsewa.Registration.WorkshopRegistrationDevelopment.Workshop;
import com.example.marmatsewa.Registration.WorkshopRegistrationDevelopment.WorkshopBLL;
import com.example.marmatsewa.url.URL;

public class garageRegistrationPersonalInfo extends AppCompatActivity {

    private ImageView backBtn, btnNext, btnRegisterWorkshop;
    private EditText garageName, edtRegType, edtLocation, edtContactName, edtNumber, edtPanNo;

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    private TextView register;

    private String garageEmail, garagePassword, garageRegType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_garage_registration_personal_info);

        //button References
        backBtn=findViewById(R.id.backBtn);
        //btnUploadDocument=findViewById(R.id.btnUploadDocument);
        //btnNext = findViewById(R.id.btnNext);
        register = findViewById(R.id.register);
        btnRegisterWorkshop = findViewById(R.id.btnRegisterWorkshop);

        //edit text references
        garageName = findViewById(R.id.garageName);
        edtRegType = findViewById(R.id.edtRegType);
        edtLocation = findViewById(R.id.edtLocation);
        edtContactName = findViewById(R.id.edtContactName);
        edtNumber = findViewById(R.id.edtNumber);
        edtPanNo = findViewById(R.id.edtPanNo);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(garageRegistrationPersonalInfo.this, garageRegistration.class);
                startActivity(intent);
            }
        });

        sharedPreferences = getApplicationContext().getSharedPreferences("Workshop",0);
        editor = sharedPreferences.edit();


        garageEmail = sharedPreferences.getString("garageEmail", null);
        garagePassword = sharedPreferences.getString("garagePassword", null);
        garageRegType = sharedPreferences.getString("garageRegType", null);


        System.out.println(sharedPreferences.getString("garageEmail", null));

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate()) {
                    registerWorkshop();
                }
            }
        });

    }

    private boolean validate() {
        boolean flag = true;

        if(TextUtils.isEmpty(garageName.getText().toString())) {
            garageName.requestFocus();
            garageName.setError("Please enter garage name");
            flag = false;
        }
        else if (TextUtils.isEmpty(edtRegType.getText().toString())) {
            edtRegType.requestFocus();
            edtRegType.setError("Please enter registration type private or public");
            flag = false;
        }
        else if (TextUtils.isEmpty(edtLocation.getText().toString())) {
            edtLocation.requestFocus();
            edtLocation.setError("Please enter the address of garage");
            flag = false;
        }
        else if (TextUtils.isEmpty(edtContactName.getText().toString())) {
            edtContactName.requestFocus();
            edtContactName.setError("Please enter the contact perseon name");
            flag = false;
        }
        else if (TextUtils.isEmpty(edtNumber.getText().toString())) {
            edtNumber.requestFocus();
            edtNumber.setError("Please enter the contact number");
            flag = false;
        }
        else if (TextUtils.isEmpty(edtPanNo.getText().toString())) {
            edtPanNo.requestFocus();
            edtPanNo.setError("Please enter the valid PAN number");
        }

        return flag;
    }

    private void registerWorkshop() {

        Workshop workshop = new Workshop(
                garageName.getText().toString(),
                edtContactName.getText().toString(),
                garageEmail,
                garagePassword,
                edtLocation.getText().toString(),
                edtNumber.getText().toString(),
                edtRegType.getText().toString(),
                edtPanNo.getText().toString(),
                garageRegType
        );

        WorkshopBLL workshopBLL = new WorkshopBLL(workshop);
        URL.getStrictMode();

        if (workshopBLL.isRegisterWorkshop()) {
            Toast.makeText(this, "Workshop registered successfully!", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(garageRegistrationPersonalInfo.this, LoginActivity.class));
        }
        else {
            Toast.makeText(this, "error: something went wrong!", Toast.LENGTH_SHORT).show();
        }
    }
}