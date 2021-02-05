package com.example.marmatsewa.GarageDashboard;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.marmatsewa.AdminInterface.SeviceDevelopment.Service;
import com.example.marmatsewa.AdminInterface.SeviceDevelopment.ServiceBLL;
import com.example.marmatsewa.GarageDashboard.Adapter.GarageTwoWheelServiceAdapter;
import com.example.marmatsewa.R;
import com.example.marmatsewa.url.URL;

import java.util.List;

public class GarageTwoWheelService extends AppCompatActivity {

    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;

    private RecyclerView recyclerView;
    private List<Service> garageTwoWheelServiceList;

    private RecyclerView two_wheel_popup_rcview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_garage_two_wheel_service);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        loadGarageTwoWheelService();
    }

    public void createNewFourWheelerDialog(){
        dialogBuilder = new AlertDialog.Builder(this);
        final View twoWheelerFormView = getLayoutInflater().inflate(R.layout.popup_twowheeler_form, null);

        dialogBuilder.setView(twoWheelerFormView);
        dialog = dialogBuilder.create();
        dialog.show();

    }

    private void loadGarageTwoWheelService() {
        ServiceBLL serviceBLL = new ServiceBLL();
        garageTwoWheelServiceList = serviceBLL.getServices();
        URL.getStrictMode();

        GarageTwoWheelServiceAdapter garageTwoWheelServiceAdapter = new GarageTwoWheelServiceAdapter(this, garageTwoWheelServiceList);
        recyclerView.setAdapter(garageTwoWheelServiceAdapter);
    }

}