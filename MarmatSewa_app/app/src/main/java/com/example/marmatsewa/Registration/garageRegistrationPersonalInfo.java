package com.example.marmatsewa.Registration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.marmatsewa.R;

public class garageRegistrationPersonalInfo extends AppCompatActivity {

    private ImageView backBtn, btnUploadDocument, btnNext;
    private EditText garageName, edtRegType, edtLocation, edtContactName, edtNumber, edtPanNo;

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

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

        sharedPreferences = getApplicationContext().getSharedPreferences("Workshop",0);
        editor = sharedPreferences.edit();

        System.out.println(sharedPreferences.getString("garageEmail", null));

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate()) {
                    editor.putString("garageName", garageName.getText().toString());
                    editor.putString("garageRegType", edtRegType.getText().toString());
                    editor.putString("garageLocation", edtLocation.getText().toString());
                    editor.putString("garageContactName", edtContactName.getText().toString());
                    editor.putString("garageNumber", edtNumber.getText().toString());
                    editor.putString("garagePan", edtPanNo.getText().toString());
                    editor.commit();

//                    startActivity(new Intent(garageRegistrationPersonalInfo.this, garageRegistrationBusinessInfo.class));
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
}