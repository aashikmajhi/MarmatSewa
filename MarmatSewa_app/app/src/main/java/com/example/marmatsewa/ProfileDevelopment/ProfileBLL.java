package com.example.marmatsewa.ProfileDevelopment;

import com.example.marmatsewa.Registration.UserRegistrationDevelopment.User;
import com.example.marmatsewa.Registration.WorkshopRegistrationDevelopment.Workshop;
import com.example.marmatsewa.url.URL;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class ProfileBLL {

    private String uid;

    public ProfileBLL(String uid) {
        this.uid = uid;
    }

    public Workshop loadGarageProfile() {
        Workshop garageProfile = null;
        ProfileAPI profileAPI = URL.getInstance().create(ProfileAPI.class);
        Call<Workshop> call = profileAPI.getGarageProfile(URL.token, uid);

        try {
            Response<Workshop> response = call.execute();
            if(response.isSuccessful()) {
                garageProfile = response.body();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return garageProfile;
    }
}
