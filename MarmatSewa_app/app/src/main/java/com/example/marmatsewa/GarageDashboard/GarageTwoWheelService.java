package com.example.marmatsewa.GarageDashboard;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.marmatsewa.AdminInterface.SeviceDevelopment.Service;
import com.example.marmatsewa.AdminInterface.SeviceDevelopment.ServiceBLL;
import com.example.marmatsewa.GarageDashboard.Adapter.GarageTwoWheelServiceAdapter;
import com.example.marmatsewa.R;
import com.example.marmatsewa.url.URL;

import java.util.List;

public class GarageTwoWheelService extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Service> garageTwoWheelServiceList;
    private ImageView btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_garage_two_wheel_service);

        btnBack=findViewById(R.id.btnBack);

        btnBack.setOnClickListener(view -> {
            startActivity(new Intent(GarageTwoWheelService.this,GarageServices.class));
        });

        recyclerView=findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        loadGarageTwoWheelService();
    }


    private void loadGarageTwoWheelService() {
        ServiceBLL serviceBLL = new ServiceBLL();
        garageTwoWheelServiceList = serviceBLL.getServices();
        URL.getStrictMode();

        GarageTwoWheelServiceAdapter garageTwoWheelServiceAdapter = new GarageTwoWheelServiceAdapter(this, garageTwoWheelServiceList);
        recyclerView.setAdapter(garageTwoWheelServiceAdapter);
    }
}