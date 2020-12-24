package com.example.marmatsewa.GarageDashboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.marmatsewa.Dashboard.GarageServices;
import com.example.marmatsewa.R;

public class GarageProfile extends AppCompatActivity {

    DrawerLayout drawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_garage_profile);

        drawerLayout = findViewById(R.id.drawer_layout);

        //Dropdown list for the garage registration form..

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.vehicleType, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);

    }

    public class SpinnerActivity extends Activity implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent, View view,
                                   int pos, long id) {
            // An item was selected. You can retrieve the selected item using
            // parent.getItemAtPosition(pos)
            Spinner spinner = (Spinner) findViewById(R.id.spinner);
            spinner.setOnItemSelectedListener(this);
        }

        public void onNothingSelected(AdapterView<?> parent) {
            // Another interface callback

        }

    }


    public void ClickMenu(View view) {
        //Open Drawer
        garageDashboard.openDrawer(drawerLayout);
    }

    public void ClickLogo(View view) {
        //Close drawer
        garageDashboard.closeDrawer(drawerLayout);
    }

    public void ClickProfile(View view){
        recreate();
    }


    public void ClickDashboard(View view) {
        garageDashboard.redirectActivity(this, garageDashboard.class);
    }

    public void ClickRequest(View view) {
        garageDashboard.redirectActivity(this, customerRequest.class);
    }

    public void ClickServices(View view) {
        garageDashboard.redirectActivity(this, GarageServices.class);
    }

    public void ClickLog(View view) {
        garageDashboard.redirectActivity(this, Request_Log_Activity.class);
    }


    public void ClickLogout(View view) {
        garageDashboard.logout(this);
    }

    protected void onPause() {
        super.onPause();
        garageDashboard.closeDrawer(drawerLayout);
    }
}