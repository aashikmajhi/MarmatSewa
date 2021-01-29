package com.example.marmatsewa.AdminInterface.SeviceDevelopment;

import com.example.marmatsewa.Registration.LoginDevelopment.LoginResponse;
import com.example.marmatsewa.url.URL;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class ServiceBLL {

    private ServiceAPI serviceAPI = URL.getInstance().create(ServiceAPI.class);

    public ServiceBLL() {
    }

    public List<Service> getServices() {
        List<Service> serviceList = null;

        Call<List<Service>> call = serviceAPI.getAllService(URL.token);

        try {
            Response<List<Service>> response = call.execute();
            if(response.isSuccessful()) {
                serviceList = response.body();
                for (Service service: serviceList) {
                    System.out.println(service);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return serviceList;
    }

    public boolean checkPostService(String feature, String image ) {
        ServiceAPI serviceAPI = URL.getInstance().create(ServiceAPI.class);
        Service service = new Service(feature, image);
        Call<Void> call = serviceAPI.postService(URL.token, service);

        try {
            Response<Void> response = call.execute();
            return response.isSuccessful();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
