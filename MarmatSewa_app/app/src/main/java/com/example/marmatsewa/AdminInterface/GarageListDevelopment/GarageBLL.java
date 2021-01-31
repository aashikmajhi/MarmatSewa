package com.example.marmatsewa.AdminInterface.GarageListDevelopment;

import com.example.marmatsewa.Registration.WorkshopRegistrationDevelopment.Workshop;
import com.example.marmatsewa.url.URL;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class GarageBLL {

    public List<Workshop> getAllGarageList() {
        List<Workshop> garageList = null;

        GarageAPI garageAPI = URL.getInstance().create(GarageAPI.class);

        Call<List<Workshop>> g = garageAPI.getAllGarageList(URL.token);

        try {
            Response<List<Workshop>> r = g.execute();
            garageList = r.body();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return garageList;
    }
}
