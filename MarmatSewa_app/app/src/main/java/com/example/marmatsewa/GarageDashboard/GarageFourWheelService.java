package com.example.marmatsewa.GarageDashboard;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.marmatsewa.R;

public class GarageFourWheelService extends AppCompatActivity {

    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;

    TextView fourWheelServiceName;

    ImageView btnAdd;

    ImageView fourWheelServiceImage;

    private RecyclerView four_wheel_popup_rcview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_garage_four_wheel_service);
    }

    public void createNewFourWheelerDialog(){
        dialogBuilder = new AlertDialog.Builder(this);
        final View fourWheelerFormView = getLayoutInflater().inflate(R.layout.popup_twowheeler_form, null);
        fourWheelServiceImage = (ImageView) fourWheelerFormView.findViewById(R.id.fourWheelServiceImage);

        btnAdd = (ImageView) fourWheelerFormView.findViewById(R.id.btnAdd);

        dialogBuilder.setView(fourWheelerFormView);
        dialog = dialogBuilder.create();
        dialog.show();

        fourWheelServiceImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //define upload button here!!

            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //define add button here!!
            }
        });


    }

}