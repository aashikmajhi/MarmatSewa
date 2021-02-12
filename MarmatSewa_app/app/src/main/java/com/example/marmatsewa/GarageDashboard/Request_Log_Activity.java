package com.example.marmatsewa.GarageDashboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.marmatsewa.GarageDashboard.Adapter.CustomerRequestAdapter;
import com.example.marmatsewa.GarageDashboard.Adapter.RequestLogAdapter;
import com.example.marmatsewa.GarageDashboard.GarageRequestDevelopment.GarageRequestBLL;
import com.example.marmatsewa.GarageDashboard.GarageRequestDevelopment.GarageRequestResponse;
import com.example.marmatsewa.R;
import com.example.marmatsewa.url.URL;

import java.util.List;

public class Request_Log_Activity extends AppCompatActivity {

    private RecyclerView rcViewHistory;
    private List<GarageRequestResponse> requestList = null;

    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_log);
        drawerLayout=findViewById(R.id.drawer_layout);
        rcViewHistory = findViewById(R.id.rcViewHistory);
        getAllRequests();

    }


    private void getAllRequests() {
        GarageRequestBLL garageRequestAPI = new GarageRequestBLL();
        URL.getStrictMode();
       // requestList = garageRequestAPI.getAcceptedRequests();

        rcViewHistory.setLayoutManager(new LinearLayoutManager(this));
       // RequestLogAdapter requestAdapter = new RequestLogAdapter(this, requestList);
       // rcViewHistory.setAdapter(requestAdapter);
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
        garageDashboard.redirectActivity(this, customerRequest.class);
    }

    public void ClickServices(View view) {
        garageDashboard.redirectActivity(this, GarageServices.class);
    }

    public void ClickLog(View view){
        recreate();
    }

    public void ClickLogout(View view){
        garageDashboard.logout(this);
    }

    protected void onPause(){
        super.onPause();
        garageDashboard.closeDrawer(drawerLayout);

    }
}