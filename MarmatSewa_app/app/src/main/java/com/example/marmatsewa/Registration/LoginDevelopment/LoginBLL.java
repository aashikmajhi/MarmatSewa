package com.example.marmatsewa.Registration.LoginDevelopment;

import android.util.Log;

import com.example.marmatsewa.url.URL;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class LoginBLL {

    private String email;
    private String password;
    private boolean isSuccess = false;

    public LoginBLL(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public boolean checkLogin() {
        LoginAPI loginAPI = URL.getInstance().create(LoginAPI.class);

        Call<LoginResponse> call = loginAPI.checkLogin(email, password);

        try {
            Response<LoginResponse> r = call.execute();

            if (r.isSuccessful()) {
                URL.token = r.body().getToken();
                Log.i("token", URL.token);
                URL.role = r.body().getRole();
                URL.user_id = r.body().getUser_id();
                isSuccess = true;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return isSuccess;
    }
}
