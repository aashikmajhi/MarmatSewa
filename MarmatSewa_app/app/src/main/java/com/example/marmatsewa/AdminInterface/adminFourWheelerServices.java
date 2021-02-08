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
import com.example.marmatsewa.R;
import com.example.marmatsewa.url.URL;

import java.util.List;

public class adminFourWheelerServices extends AppCompatActivity {

    private ImageView btnBack2,btnFForm;
    private String imagePath;
    private String image;

    private AlertDialog.Builder dialogBuilder, builder;
    private AlertDialog dialog;

    private ImageView btnUploadImage;
    private EditText edtFourWheelServiceName;
    private Button btnAddService;

    private RecyclerView recyclerView;
    private List<Service> serviceList;

    private String featureName;

    private ServiceBLL serviceBLL;
    private ImageBLL imageBLL;

    private Integer CHOOSE_FROM_GALLERY = 0;
    private Integer CHOOSE_FROM_CAMERA = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four_wheeler_services);

        btnBack2 = findViewById(R.id.btnBack2);
        btnFForm=findViewById(R.id.btnFForm);

        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        getAllServices();

        btnBack2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(adminFourWheelerServices.this, admin_services.class);
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

    public void createNewFourWheelerDialog() {
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
                checkCameraPermission();
                popUpSelectFromCameraOrGallery();

            }
        });

        btnAddService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                featureName = edtFourWheelServiceName.getText().toString();
                serviceBLL = new ServiceBLL();
                serviceBLL.checkPostService(featureName, image);
                finish();
                //define add button here!!
            }
        });
    }

    private void getAllServices() {
        ServiceBLL serviceBLL = new ServiceBLL();
        URL.getStrictMode();

        serviceList = serviceBLL.getServices();
        ServiceAdapter serviceAdapter = new ServiceAdapter(this, serviceList);
        recyclerView.setAdapter(serviceAdapter);
    }

    private void checkCameraPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 0);
        }
    }

    private void popUpSelectFromCameraOrGallery() {
        final CharSequence[] options = {"Choose from Gallery", "Cancel"};
        builder = new AlertDialog.Builder(adminFourWheelerServices.this);

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
            if (data == null) {
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