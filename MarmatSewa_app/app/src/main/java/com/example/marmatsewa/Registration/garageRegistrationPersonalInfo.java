package com.example.marmatsewa.Registration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.marmatsewa.R;

public class garageRegistrationPersonalInfo extends AppCompatActivity {

    private ImageView backBtn, btnUploadDocument, btnNext;
    private EditText garageName, edtRegType, edtLocation, edtContactName, edtNumber, edtPanNo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_garage_registration_personal_info);

        //button References
        backBtn=findViewById(R.id.backBtn);
        btnUploadDocument=findViewById(R.id.btnUploadDocument);
        btnNext = findViewById(R.id.btnNext);

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

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO intent to garageRegistrationBusinessInfo if the fields are filled..
            }
        });
    }
}