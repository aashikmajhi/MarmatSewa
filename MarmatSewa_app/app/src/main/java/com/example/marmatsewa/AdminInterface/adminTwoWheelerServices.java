package com.example.marmatsewa.AdminInterface;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.marmatsewa.AdminInterface.SeviceDevelopment.Service;
import com.example.marmatsewa.AdminInterface.SeviceDevelopment.ServiceBLL;
import com.example.marmatsewa.AdminInterface.UploadImageDevelopment.ImageBLL;
import com.example.marmatsewa.AdminInterface.adapter.ServiceAdapter;
import com.example.marmatsewa.GarageDashboard.GarageServices;
import com.example.marmatsewa.R;
import com.example.marmatsewa.url.URL;

import java.util.List;

public class adminTwoWheelerServices extends AppCompatActivity {

    ImageView backbtn, btnAdd;


    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;

    private ImageView btnUploadImage;
    private EditText edtTwoWheelServiceName;
    private Button btnAddService;

    private RecyclerView twoWheerRecyclerView;
    private ImageBLL imageBLL;
    private String imagePath;
    private String featureName;
    private String image;

    private Integer CHOOSE_FROM_GALLERY = 0;
    private Integer CHOOSE_FROM_CAMERA = 1;

    private AlertDialog.Builder builder;

    private List<Service> serviceList;

    private ServiceBLL serviceBLL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_wheeler_services);

        backbtn=findViewById(R.id.btnBack);
<<<<<<<< HEAD:MarmatSewa_app/app/src/main/java/com/example/marmatsewa/AdminInterface/adminTwoWheelerServices.java
        btnAdd=findViewById(R.id.btnAdd);
========
        //btnTForm=findViewById(R.id.btnTForm);
>>>>>>>> a2068de4b85876f8d508608b492856759578b50b:MarmatSewa_app/app/src/main/java/com/example/marmatsewa/AdminInterface/TwoWheelerServices.java

        twoWheerRecyclerView = findViewById(R.id.twoWheerRecyclerView);

        twoWheerRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        getAllServices();

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(adminTwoWheelerServices.this, admin_services.class);
                startActivity(intent);
            }
        });
<<<<<<<< HEAD:MarmatSewa_app/app/src/main/java/com/example/marmatsewa/AdminInterface/adminTwoWheelerServices.java
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createNewTwoWheelerDialog();
            }
        });
========

//        btnTForm.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                createNewTwoWheelerDialog();
//            }
//        });
>>>>>>>> a2068de4b85876f8d508608b492856759578b50b:MarmatSewa_app/app/src/main/java/com/example/marmatsewa/AdminInterface/TwoWheelerServices.java
    }

    public void createNewTwoWheelerDialog() {
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
                checkCameraPermission();
                popUpSelectFromCameraOrGallery();

            }
        });

        btnAddService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //define add button here!!
                featureName = edtTwoWheelServiceName.getText().toString();
                serviceBLL = new ServiceBLL();
                serviceBLL.checkPostService(featureName, image);
                finish();
//                Log.i("btnAdd", String.valueOf(serviceBLL.checkPostService(featureName, image)));
            }
        });
    }

    private void getAllServices() {
        ServiceBLL serviceBLL = new ServiceBLL();
        URL.getStrictMode();

        serviceList = serviceBLL.getServices();
        if (serviceList.size() <= 0) return;
        ServiceAdapter serviceAdapter = new ServiceAdapter(this, serviceList);
        twoWheerRecyclerView.setAdapter(serviceAdapter);
    }
    private void checkCameraPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 0);
        }
    }

    private void popUpSelectFromCameraOrGallery() {
        final CharSequence[] options = { "Choose from Gallery","Cancel" };
        builder = new AlertDialog.Builder(adminTwoWheelerServices.this);

        builder.setTitle("Add Profile Pic!")
                .setItems(options, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.i("debug", String.valueOf(which));

                        if (which == CHOOSE_FROM_GALLERY) {
                            Intent intent = new Intent(Intent.ACTION_PICK);
                            intent.setType("image/*");
                            startActivityForResult(intent, 0);
                        }
                    }
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        imageBLL = new ImageBLL();
        if (resultCode == RESULT_OK) {
            if ( data == null ) {
                Toast.makeText(this, "Please Select Image", Toast.LENGTH_LONG).show();
            }
        }
        Uri uri = data.getData();
        imagePath = imageBLL.getRealPathFromUri(uri, getApplicationContext());
        imageBLL.previewImage(imagePath, btnUploadImage);

        if (imageBLL.checkImageUpload(imagePath))
            image = imageBLL.returnFilename();
        Toast.makeText(this, "Image Uploaded", Toast.LENGTH_SHORT).show();
    }

}