package com.example.marmatsewa.AdminInterface;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.marmatsewa.AdminInterface.GarageListDevelopment.GarageBLL;
import com.example.marmatsewa.AdminInterface.adapter.GarageListAdapter;
import com.example.marmatsewa.R;
import com.example.marmatsewa.Registration.WorkshopRegistrationDevelopment.Workshop;
import com.example.marmatsewa.url.URL;

import java.util.List;

public class admin_garage_list extends AppCompatActivity {

    private DrawerLayout drawerLayout;

    private RecyclerView rcViewAdminGarageList;
    private List<Workshop> approvedGarageList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_garage_list);

        drawerLayout = findViewById(R.id.drawer_layout);

        rcViewAdminGarageList.setLayoutManager(new LinearLayoutManager(this));
        loadApprovedGarageList();
    }

    public void  ClickMenu(View view){
        //Open Drawer
        admin_dash.openDrawer(drawerLayout);
    }

    public  void ClickLogo(View view){
        //Close drawer
        admin_dash.closeDrawer(drawerLayout);
    }

    public void ClickAdminDashboard(View view){
        admin_dash.redirectActivity(this, admin_dash.class);
    }

    public void ClickAdminGarageList(View view){
        recreate();
    }

    public void ClickAdminServices(View view) {
        admin_dash.redirectActivity(this, admin_services.class);
    }

    public void ClickAdminRequestList(View view){
        admin_dash.redirectActivity(this, admin_garage_request_list.class);
    }

    public void ClickLogout(View view){
        admin_dash.logout(this);
    }

    protected void onPause(){
        super.onPause();
        admin_dash.closeDrawer(drawerLayout);

    }

    private void loadApprovedGarageList() {
        GarageBLL garageBLL = new GarageBLL();
        URL.getStrictMode();

        approvedGarageList = garageBLL.getAllGarageList();
        for(Workshop apg : approvedGarageList) {
            if (apg.getStatus().equals("APPROVED")) {
                GarageListAdapter garageListAdapter = new GarageListAdapter(this, approvedGarageList);
                rcViewAdminGarageList.setAdapter(garageListAdapter);
            }
        }
    }

}