package com.example.marmatsewa.AdminInterface;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.marmatsewa.GarageDashboard.GarageServices;
import com.example.marmatsewa.R;

public class TwoWheelerServices extends AppCompatActivity {

    ImageView backbtn, btnTForm;


    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;

    private ImageView btnUploadImage;
    private EditText edtTwoWheelServiceName;
    private Button btnAddService;

    private RecyclerView twoWheerRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_wheeler_services);

        backbtn=findViewById(R.id.btnBack);
        btnTForm=findViewById(R.id.btnTForm);

        twoWheerRecyclerView = findViewById(R.id.twoWheerRecyclerView);

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(TwoWheelerServices.this, GarageServices.class);
                startActivity(intent);
            }
        });

        btnTForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createNewTwoWheelerDialog();
            }
        });
    }

    public void createNewTwoWheelerDialog(){
        dialogBuilder = new AlertDialog.Builder(this);
        final View twoWheelerFormView = getLayoutInflater().inflate(R.layout.popup_twowheeler_form, null);
        edtTwoWheelServiceName = (EditText) twoWheelerFormView.findViewById(R.id.edtTwoWheelServiceName);
        btnUploadImage = (ImageView) twoWheelerFormView.findViewById(R.id.btnUploadImage);

        btnAddService = (Button) twoWheelerFormView.findViewById(R.id.btnAddService);

        dialogBuilder.setView(twoWheelerFormView);
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