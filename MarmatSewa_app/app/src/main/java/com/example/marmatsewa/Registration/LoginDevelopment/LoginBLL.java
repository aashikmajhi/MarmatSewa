package com.example.marmatsewa.Registration.LoginDevelopment;

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
                URL.role = r.body().getRole();
                isSuccess = true;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return isSuccess;
    }
}
