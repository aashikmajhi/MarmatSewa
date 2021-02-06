package com.example.marmatsewa.UserInterface.UserProfileDevelopment;

import com.example.marmatsewa.ProfileDevelopment.ProfileAPI;
import com.example.marmatsewa.Registration.UserRegistrationDevelopment.User;
import com.example.marmatsewa.url.URL;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class UserProfileBLL {

    public UserProfileBLL() {
    }

    public User getUserProfile() {
        User userProfile = null;
        UserProfileAPI userProfileAPI = URL.getInstance().create(UserProfileAPI.class);
        Call<User> call = userProfileAPI.getProfile(URL.token);

        try {
            Response<User> response = call.execute();

            if(response.isSuccessful()) {
                userProfile = response.body();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userProfile;
    }
}
