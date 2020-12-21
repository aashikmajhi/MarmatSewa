package com.example.marmatsewa.Registration.UserRegistrationDevelopment;

import com.example.marmatsewa.url.URL;

import retrofit2.Call;
import retrofit2.Response;

public class UserRegisterBLL {

    private User user;
    private boolean isSuccess = false;

    public UserRegisterBLL(User user) {
        this.user = user;
    }

    public boolean isRegisterUser() {
        UserAPI userAPI = URL.getInstance().create(UserAPI.class);

        Call<Void> call = userAPI.registerUser(user);

        try {
            Response<Void> response = call.execute();
            isSuccess = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isSuccess;
    }
}
