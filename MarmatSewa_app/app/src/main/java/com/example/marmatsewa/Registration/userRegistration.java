package com.example.marmatsewa.Registration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.marmatsewa.R;
import com.example.marmatsewa.Registration.UserRegistrationDevelopment.User;
import com.example.marmatsewa.Registration.UserRegistrationDevelopment.UserRegisterBLL;
import com.example.marmatsewa.url.URL;

public class userRegistration extends AppCompatActivity {

    private ImageView backBtn, submitUser;
    private EditText edtfName, edtEmail, edtPassword, edtPhone, edtAddress, edtDob;
    private RadioButton genderMale, genderFemale;
    private TextView license;

    private String gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_registration);

        //references
        edtfName = findViewById(R.id.edtfName);
        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        edtPhone = findViewById(R.id.edtPhone);
//        edtPhone = findViewById(R.id.edtPhone);
        edtAddress = findViewById(R.id.edtAddress);
        edtDob = findViewById(R.id.edtDob);

        genderMale = findViewById(R.id.genderMale);
        genderFemale = findViewById(R.id.genderFemale);

        submitUser = findViewById(R.id.submitUser);

        backBtn = findViewById(R.id.backBtn);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(userRegistration.this, RegistrationType.class);
                startActivity(intent);
            }
        });

        submitUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(genderMale.isSelected()) {
                    gender = "MALE";
                    System.out.println("gender is male");
                }
                else if(genderFemale.isSelected()) {
                    gender = "FEMALE";
                    System.out.println("gender is female");
                }
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
                "MALE",
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
}