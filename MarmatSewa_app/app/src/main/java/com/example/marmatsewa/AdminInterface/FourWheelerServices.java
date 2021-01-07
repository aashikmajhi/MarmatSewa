package com.example.marmatsewa.AdminInterface;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.marmatsewa.R;

public class FourWheelerServices extends AppCompatActivity {

    ImageView btnBack2, btnFForm;

    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;

    private ImageView btnUploadImage;
    private EditText edtFourWheelServiceName;
    private Button btnAddService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four_wheeler_services);

        btnFForm=findViewById(R.id.btnFForm);

        btnBack2=findViewById(R.id.btnBack2);

        btnBack2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(FourWheelerServices.this, admin_services.class);
                startActivity(i);
            }
        });

        btnFForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createNewFourWheelerDialog();
            }
        });
    }

    public void createNewFourWheelerDialog(){
        dialogBuilder = new AlertDialog.Builder(this);
        final View fourWheelerFormView = getLayoutInflater().inflate(R.layout.popup_fourwheeler_form, null);
        edtFourWheelServiceName = (EditText) fourWheelerFormView.findViewById(R.id.edtFourWheelServiceName);
        btnUploadImage = (ImageView) fourWheelerFormView.findViewById(R.id.btnUploadImage);

        btnAddService = (Button) fourWheelerFormView.findViewById(R.id.btnAddService);

        dialogBuilder.setView(fourWheelerFormView);
        dialog = dialogBuilder.create();
        dialog.show();

        btnUploadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //define upload button here!!

            }
        });

        btnAddService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //define add button here!!
            }
        });


    }

}