package com.example.marmatsewa.Registration.WorkshopRegistrationDevelopment;

import com.example.marmatsewa.url.URL;

import retrofit2.Call;
import retrofit2.Response;

public class WorkshopBLL {

    private Workshop workshop;

    private boolean isSuccess = false;

    public WorkshopBLL(Workshop workshop) {
        this.workshop = workshop;
    }

    public boolean isRegisterWorkshop() {
        WorkshopAPI workshopAPI = URL.getInstance().create(WorkshopAPI.class);

        Call<Void> call = workshopAPI.registerWorkshop(workshop);

        try {
            Response<Void> r = call.execute();
            if (!r.isSuccessful()) return false;

            isSuccess = true;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return isSuccess;
    }
}
