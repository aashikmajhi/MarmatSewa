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
import com.example.marmatsewa.UserInterface.Adapter.TwoWheelServiceAdater;
import com.example.marmatsewa.url.URL;

import java.util.List;

public class user_two_wheel_services extends AppCompatActivity {

    private ImageView btnback2wheelservice;
    private RecyclerView userTwoWheelServiceView;
    private List<Service> serviceListForTwoWheel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_two_wheel_services);

        btnback2wheelservice=findViewById(R.id.btnback2wheelservice);
        userTwoWheelServiceView = findViewById(R.id.userTwoWheelServiceView);

        userTwoWheelServiceView.setLayoutManager(new LinearLayoutManager(this));
        loadTwoWheelService();

        btnback2wheelservice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(user_two_wheel_services.this,user_dashboard.class));
            }
        });
    }

    private void loadTwoWheelService() {
        ServiceBLL serviceBLL = new ServiceBLL();
        serviceListForTwoWheel = serviceBLL.getServices();
        URL.getStrictMode();
        TwoWheelServiceAdater twoWheelServiceAdater = new TwoWheelServiceAdater(this, serviceListForTwoWheel);
        userTwoWheelServiceView.setAdapter(twoWheelServiceAdater);
    }
}