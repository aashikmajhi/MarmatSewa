package com.example.marmatsewa.GarageDashboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.marmatsewa.GarageDashboard.Adapter.CustomerRequestAdapter;
import com.example.marmatsewa.GarageDashboard.GarageRequestDevelopment.GarageRequestBLL;
import com.example.marmatsewa.GarageDashboard.GarageRequestDevelopment.GarageRequestResponse;
import com.example.marmatsewa.R;
import com.example.marmatsewa.notificationChannel.createChannel;
import com.example.marmatsewa.url.URL;

import java.util.List;

public class customerRequest extends AppCompatActivity {

    DrawerLayout drawerLayout;
    private RecyclerView rcView;
    private List<GarageRequestResponse> requestList = null;

    //notification
    NotificationManagerCompat notificationManagerCompat;
    private androidx.appcompat.app.AlertDialog.Builder dialogBuilder;
    private androidx.appcompat.app.AlertDialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_request);

        //notification
        notificationManagerCompat = NotificationManagerCompat.from(this);

        createChannel c = new createChannel(this);
        c.createChannel();

        if(getIntent().getExtras() !=  null){
            if (getIntent().getExtras().getString("Username").equals("true")){
                NewRequest();
            }
        }

        drawerLayout = findViewById(R.id.drawer_layout);
        rcView = findViewById(R.id.rcView);
        rcView.setLayoutManager(new LinearLayoutManager(this));
        //api call is fired ...
        getAllRequests();
    }

    public void getAllRequests() {
        GarageRequestBLL garageRequestAPI = new GarageRequestBLL();
        URL.getStrictMode();
        requestList = garageRequestAPI.getPendingRequests();
        //if no data is fetched from api call returns void ...
        if (requestList.size() <= 0) {
//            Toast.makeText(this, "no requests have been received ...", Toast.LENGTH_SHORT).show();
            return;
        }
        CustomerRequestAdapter requestAdapter = new CustomerRequestAdapter(this, requestList);
        rcView.setAdapter(requestAdapter);
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

    //notification for new Request
    public void newRequest(){
        dialogBuilder = new androidx.appcompat.app.AlertDialog.Builder(this);
        final View notificationView = getLayoutInflater().inflate(R.layout.notification_popup, null);

        //TODO: assign notification card here

        dialogBuilder.setView(notificationView);
        dialog = dialogBuilder.create();
        dialog.show();

    }

    private void NewRequest(){
        NotificationCompat.Builder notification = new NotificationCompat.Builder(this,createChannel.hire)
                .setSmallIcon(R.drawable.ic_baseline_notifications_24)
                .setContentTitle("New Request")
                .setContentText("New Request from : Username")
                .setCategory(NotificationCompat.CATEGORY_MESSAGE);

        notificationManagerCompat.notify(1,notification.build());
    }
}