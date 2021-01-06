package com.example.marmatsewa.Registration;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.marmatsewa.R;
import com.example.marmatsewa.Registration.WorkshopRegistrationDevelopment.Workshop;

public class garageRegistrationBusinessInfo extends AppCompatActivity {

    private ImageView backBtn;
    private CheckBox checkBoxControlBrake, checkBoxElectrical, checkBoxFuelAir, checkBoxWheelDrives;
    private ImageView btnRegisterWorkshop;

    private boolean isCheckBoxControlBrake=false,
            isCheckBoxElectrical=false,
            isCheckBoxFuelAir=false,
            isCheckBoxWheelDrives=false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_garage_registration_business_info);


        //checkbox references
        checkBoxControlBrake = findViewById(R.id.checkBoxControlBrake);
        checkBoxElectrical = findViewById(R.id.checkBoxElectrical);
        checkBoxFuelAir = findViewById(R.id.checkBoxFuelAir);
        checkBoxWheelDrives = findViewById(R.id.checkBoxWheelDrives);

        //button reference
        btnRegisterWorkshop = findViewById(R.id.btnRegisterWorkshop);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(garageRegistrationBusinessInfo.this, garageRegistrationPersonalInfo.class);
                startActivity(intent);
            }
        });


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
//            parent.getItemAtPosition(pos)
            Spinner spinner = (Spinner) findViewById(R.id.spinner);
            spinner.setOnItemSelectedListener(this);
        }

        public void onNothingSelected(AdapterView<?> parent) {
            // Another interface callback

        }

    }
}


