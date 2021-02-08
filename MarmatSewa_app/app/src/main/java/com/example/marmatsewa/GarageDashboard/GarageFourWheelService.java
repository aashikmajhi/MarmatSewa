package com.example.marmatsewa.GarageDashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.marmatsewa.AdminInterface.SeviceDevelopment.Service;
import com.example.marmatsewa.AdminInterface.SeviceDevelopment.ServiceBLL;
import com.example.marmatsewa.GarageDashboard.Adapter.GarageFourWheelServiceAdapter;
import com.example.marmatsewa.GarageDashboard.Adapter.GarageTwoWheelServiceAdapter;
import com.example.marmatsewa.R;
import com.example.marmatsewa.url.URL;

import java.util.List;

public class GarageFourWheelService extends AppCompatActivity {

    ImageView btnBack;
    private RecyclerView recyclerView;
    private List<Service> garageFourWheelServiceList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_garage_four_wheel_service);

        recyclerView = findViewById(R.id.recyclerView);
        btnBack = findViewById(R.id.btnBack);

        btnBack.setOnClickListener(view -> startActivity(new Intent(GarageFourWheelService.this,GarageServices.class)));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        loadGarageFourWheelService();
    }

    private void loadGarageFourWheelService() {
        ServiceBLL serviceBLL = new ServiceBLL();
        garageFourWheelServiceList = serviceBLL.getServices();
        URL.getStrictMode();

        GarageTwoWheelServiceAdapter garageTwoWheelServiceAdapter = new GarageTwoWheelServiceAdapter(this, garageFourWheelServiceList);
        recyclerView.setAdapter(garageTwoWheelServiceAdapter);
    }

}