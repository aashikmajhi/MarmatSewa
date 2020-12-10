package com.example.marmatsewa.Registration;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.marmatsewa.R;
import com.example.marmatsewa.Registration.LoginDev.LoginBLL;
import com.example.marmatsewa.url.URL;

public class LoginActivity extends AppCompatActivity {

    private EditText edtEmail, edtPword;
    private ImageView btnLogin;
    private TextView btnSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtEmail = findViewById(R.id.edtEmail);
        edtPword = findViewById(R.id.edtPword);
        btnLogin = findViewById(R.id.btnLogin);
        btnSignup = findViewById(R.id.btnSignup);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validateLogin()) {
                    loginSync();
                }
            }
        });

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LoginActivity.this, "Signup Button Pressed", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void loginSync() {
        LoginBLL loginBLL = new LoginBLL(edtEmail.getText().toString(), edtPword.getText().toString());
        URL.getStrictMode();

        if (loginBLL.checkLogin()) {
            Toast.makeText(this, "login successful", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Invalid Email or Password", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean validateLogin() {
        boolean flag = true;

        if (TextUtils.isEmpty(edtEmail.getText().toString())) {
            edtEmail.requestFocus();
            edtEmail.setError("Email is required");
            flag = false;
        }
        else if (TextUtils.isEmpty(edtPword.getText().toString())) {
            edtPword.requestFocus();
            edtPword.setError("Password is required");
            flag = false;
        }
        return flag;
    }
}