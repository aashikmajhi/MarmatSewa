package com.example.marmatsewa.UserInterface.UserProfileDevelopment;

import com.example.marmatsewa.ProfileDevelopment.ProfileAPI;
import com.example.marmatsewa.Registration.UserRegistrationDevelopment.User;
import com.example.marmatsewa.url.URL;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class UserProfileBLL {

    private String user_id;

    public UserProfileBLL(String user_id) {
        this.user_id = user_id;
    }

    public User getUserProfile() {
        User userProfile = null;
        ProfileAPI profileAPI = URL.getInstance().create(ProfileAPI.class);
        Call<User> call = profileAPI.getProfile(URL.token, user_id);

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
