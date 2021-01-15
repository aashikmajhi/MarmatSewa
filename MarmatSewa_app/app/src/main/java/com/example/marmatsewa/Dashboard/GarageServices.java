package com.example.marmatsewa.Dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.marmatsewa.R;

public class GarageServices extends AppCompatActivity {

    ImageView ImgCar, ImgBike;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_garage_services);

        ImgBike=findViewById(R.id.btnTwoWheeler);
        ImgCar=findViewById(R.id.btnFourWheeler);

    }

//    Image click handler on Services

    public void onCardClicker(View v)
    {
        Intent i;

        switch (v.getId()){
            case R.id.btnTwoWheeler:
                i=new Intent(this,TwoWheelerServices.class);
                startActivity(i);
                break;

            case R.id.btnFourWheeler:
                i=new Intent(this,FourWheelerServices.class);
                startActivity(i);
                break;

            default:
                break;
        }

    }
}