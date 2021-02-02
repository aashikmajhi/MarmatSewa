package com.example.marmatsewa.UserInterface;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.marmatsewa.AdminInterface.SeviceDevelopment.Service;
import com.example.marmatsewa.AdminInterface.SeviceDevelopment.ServiceBLL;
import com.example.marmatsewa.R;
import com.example.marmatsewa.UserInterface.Adapter.FourWheelServiceAdapter;

import java.util.List;

public class user_four_wheel_services extends AppCompatActivity {
    private ImageView btnback4wheelservice;
    private RecyclerView userFourWheelServiceView;

    private List<Service> fourWheelService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_four_wheel_services);

        btnback4wheelservice=findViewById(R.id.btnback4wheelservice);
        userFourWheelServiceView = findViewById(R.id.userFourWheelServiceView);

        userFourWheelServiceView.setLayoutManager(new LinearLayoutManager(this));
        loadFourWheelService();

        btnback4wheelservice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(user_four_wheel_services.this,user_dashboard.class));
            }
        });
    }

    private void loadFourWheelService() {
        ServiceBLL serviceBLL = new ServiceBLL();
        fourWheelService = serviceBLL.getServices();

        FourWheelServiceAdapter fourWheelServiceAdapter = new FourWheelServiceAdapter(this, fourWheelService);
        userFourWheelServiceView.setAdapter(fourWheelServiceAdapter);
    }
}