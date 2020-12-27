package com.example.marmatsewa.Registration;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.media.Image;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.marmatsewa.R;
import com.example.marmatsewa.Registration.UserRegistrationDevelopment.User;
import com.example.marmatsewa.Registration.UserRegistrationDevelopment.UserRegisterBLL;
import com.example.marmatsewa.url.URL;

import java.util.Calendar;

public class userRegistration extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    private ImageView backBtn, submitUser, btnUploadLicense;
    private EditText edtfName, edtEmail, edtPassword, edtPhone, edtAddress, edtDob;
    private RadioButton genderMale, genderFemale;
    private TextView license;

    private String gender;

    final Calendar c = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_registration);

        //references
        edtfName = findViewById(R.id.edtfName);
        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        edtPhone = findViewById(R.id.edtPhone);
        edtAddress = findViewById(R.id.edtAddress);
        edtDob = findViewById(R.id.edtDob);

        genderMale = findViewById(R.id.genderMale);
        genderFemale = findViewById(R.id.genderFemale);

        btnUploadLicense = findViewById(R.id.btnUploadLicense);

        submitUser = findViewById(R.id.submitUser);

        backBtn = findViewById(R.id.backBtn);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(userRegistration.this, RegistrationType.class);
                startActivity(intent);
            }
        });

        edtDob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadDatePicker();
            }
        });

        genderMale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gender = "MALE";
            }
        });
        genderFemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gender = "FEMALE";
            }
        });

        checkPermissions();
        btnUploadLicense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadCamera();
            }
        });

        submitUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //registerUser();
            }
        });
    }

    private void registerUser() {

        User user = new User(
                edtfName.getText().toString(),
                edtEmail.getText().toString(),
                edtPassword.getText().toString(),
                edtPhone.getText().toString(),
                edtAddress.getText().toString(),
                edtDob.getText().toString(),
                gender,
                "scannedlicense"
        );

        UserRegisterBLL userRegisterBLL = new UserRegisterBLL(user);
        URL.getStrictMode();

        if(userRegisterBLL.isRegisterUser()) {
            Toast.makeText(this, "User register successfully", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "User register failed!!", Toast.LENGTH_SHORT).show();
        }
    }

    private void loadDatePicker() {

        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, this, year, month, day);
        datePickerDialog.show();
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String date = month + "/" + dayOfMonth + "/" + year;
        edtDob.setText(date);
    }

    private void checkPermissions() {
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]
                    {Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 0);
        }
    }

    private void loadCamera() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (intent.resolveActivity(getPackageManager())!= null) {
            startActivityForResult(intent, 1);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            //imageView.setImageBitmap(imageBitmap);
        }

    }

}