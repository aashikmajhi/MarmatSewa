package com.example.marmatsewa.Registration;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.marmatsewa.R;
import com.example.marmatsewa.Registration.WorkshopRegistrationDevelopment.Workshop;
import com.example.marmatsewa.Registration.WorkshopRegistrationDevelopment.WorkshopBLL;
import com.example.marmatsewa.url.URL;

public class garageRegistration extends AppCompatActivity {

    private ImageView backBtn, btnUploadDocument;
    private EditText garageName, edtRegType, edtLocation, edtContactName, edtNumber, edtPanNo;
    private CheckBox checkBoxControlBrake, checkBoxElectrical, checkBoxFuelAir, checkBoxWheelDrives;
    private TextView btnRegisterWorkshop;

    private boolean isCheckBoxControlBrake=false,
            isCheckBoxElectrical=false,
            isCheckBoxFuelAir=false,
            isCheckBoxWheelDrives=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_garage_registration);

        //edit text references
        garageName = findViewById(R.id.garageName);
        edtRegType = findViewById(R.id.edtRegType);
        edtLocation = findViewById(R.id.edtLocation);
        edtContactName = findViewById(R.id.edtContactName);
        edtNumber = findViewById(R.id.edtNumber);
        edtPanNo = findViewById(R.id.edtPanNo);

        //checkbox references
        checkBoxControlBrake = findViewById(R.id.checkBoxControlBrake);
        checkBoxElectrical = findViewById(R.id.checkBoxElectrical);
        checkBoxFuelAir = findViewById(R.id.checkBoxFuelAir);
        checkBoxWheelDrives = findViewById(R.id.checkBoxWheelDrives);

        //imageview references
        btnUploadDocument = findViewById(R.id.btnUploadDocument);

        //button reference
        btnRegisterWorkshop = findViewById(R.id.btnRegisterWorkshop);


        //Dropdown list for the garage registration form..

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.vehicleType, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        backBtn = findViewById(R.id.backBtn);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(garageRegistration.this, RegistrationType.class);
                startActivity(intent);
            }
        });

        btnRegisterWorkshop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(checkBoxControlBrake.isChecked()){
                    isCheckBoxControlBrake = true;
                }
                if(checkBoxElectrical.isChecked()) {
                    isCheckBoxElectrical = true;
                }
                if(checkBoxFuelAir.isChecked()) {
                    isCheckBoxFuelAir = true;
                }
                if(checkBoxWheelDrives.isChecked()) {
                    isCheckBoxWheelDrives = true;
                }
                registerWorkshop();
                Toast.makeText(garageRegistration.this, "workshop registered", Toast.LENGTH_SHORT).show();

            }
        });
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

    private void registerWorkshop() {

        Workshop workshop = new Workshop(
                garageName.getText().toString(),
                edtContactName.getText().toString(),
                "email@abc.com",
                "password",
                edtLocation.getText().toString(),
                edtNumber.getText().toString(),
                edtRegType.getText().toString(),
                edtPanNo.getText().toString(),
                "registrationdoc",
                isCheckBoxControlBrake,
                isCheckBoxElectrical,
                isCheckBoxFuelAir,
                isCheckBoxWheelDrives
                );

        WorkshopBLL workshopBLL = new WorkshopBLL(workshop);
        URL.getStrictMode();

        if (workshopBLL.isRegisterWorkshop()) {
            Toast.makeText(this, "Workshop registered successfully!", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "error: something went wrong!", Toast.LENGTH_SHORT).show();
        }
    }
}