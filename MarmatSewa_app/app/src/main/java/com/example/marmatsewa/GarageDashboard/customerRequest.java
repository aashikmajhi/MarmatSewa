package com.example.marmatsewa.GarageDashboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.marmatsewa.AdminInterface.adapter.ServiceAdapter;
import com.example.marmatsewa.GarageDashboard.Adapter.CustomerRequestAdapter;
import com.example.marmatsewa.GarageDashboard.GarageRequestDevelopment.GarageRequestBLL;
import com.example.marmatsewa.GarageDashboard.GarageRequestDevelopment.GarageRequestResponse;
import com.example.marmatsewa.R;
import com.example.marmatsewa.url.URL;

import java.util.List;

public class customerRequest extends AppCompatActivity {

    DrawerLayout drawerLayout;
    private RecyclerView rcView;
    private List<GarageRequestResponse> requestList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_request);

        drawerLayout = findViewById(R.id.drawer_layout);
        rcView = findViewById(R.id.rcView);
    }

    private void getAllRequests() {
        GarageRequestBLL garageRequestAPI = new GarageRequestBLL();
        URL.getStrictMode();
        requestList = garageRequestAPI.getGarageRequests();
        CustomerRequestAdapter serviceAdapter = new CustomerRequestAdapter(this, requestList);
        rcView.setAdapter(serviceAdapter);
    }

    public void  ClickMenu(View view){
        //Open Drawer
        garageDashboard.openDrawer(drawerLayout);
    }

    public  void ClickLogo(View view){
        //Close drawer
        garageDashboard.closeDrawer(drawerLayout);
    }

    public void ClickProfile(View view) {
        garageDashboard.redirectActivity(this, GarageProfile.class);
    }

    public void ClickDashboard(View view){
        garageDashboard.redirectActivity(this, garageDashboard.class);
    }

    public void ClickRequest(View view){
        recreate();
    }

    public void ClickServices(View view) {
        garageDashboard.redirectActivity(this, GarageServices.class);
    }

    public void ClickLog(View view){
        garageDashboard.redirectActivity(this, Request_Log_Activity.class);
    }


    public void ClickLogout(View view){
        garageDashboard.logout(this);
    }

    protected void onPause(){
        super.onPause();
        garageDashboard.closeDrawer(drawerLayout);

    }
}