package com.example.marmatsewa.ProfileDevelopment;

import com.example.marmatsewa.Registration.UserRegistrationDevelopment.User;
import com.example.marmatsewa.Registration.WorkshopRegistrationDevelopment.Workshop;
import com.example.marmatsewa.url.URL;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class ProfileBLL {

    private String uid;
    private boolean isSuccess;

    private ProfileAPI profileAPI = URL.getInstance().create(ProfileAPI.class);

    public ProfileBLL(String uid) {
        this.uid = uid;
    }

    public Workshop getGarageProfile() {
        Workshop garageProfile = null;

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

    public boolean updateGarageProfile(Workshop garageProfile) {
        isSuccess = false;
        Call<Void> call = profileAPI.updateGarageProfile(URL.token, uid, garageProfile);

        try {
            Response<Void> updateResponse = call.execute();
            if (updateResponse.isSuccessful()){
                isSuccess = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return isSuccess;
    }
}
