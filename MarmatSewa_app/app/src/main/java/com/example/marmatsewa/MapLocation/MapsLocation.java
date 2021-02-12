package com.example.marmatsewa.MapLocation;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.marmatsewa.R;
import com.example.marmatsewa.UserInterface.ServiceGarageOwner.ServiceGarageOwnerBLL;
import com.example.marmatsewa.UserInterface.ServiceGarageOwner.*;
import com.example.marmatsewa.UserInterface.user_hiring_page;
import com.example.marmatsewa.url.URL;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MapsLocation extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private CameraUpdate zoom, center;
    private String feature_id;
    ArrayList<ServiceGarageOwnerResponse> garageList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_location);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        getFeatureIdFromIntent();
        // Add a marker in Sydney and move the camera
        LatLng GOD = new LatLng(27.7141308,85.3123154);

        feature_id = getFeatureIdFromIntent();
        if (feature_id.isEmpty()) {
            Toast.makeText(this, "No feature id is received from Intent", Toast.LENGTH_SHORT).show();
            return;
        }
        getGarageOwnerWithSelectedFeatures(mMap);

        mMap.addMarker(new MarkerOptions().position(GOD).title("Marker in Garden Of Dreams"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(GOD));

        zoom=CameraUpdateFactory.zoomTo(12);
        center=CameraUpdateFactory.newLatLng(new LatLng(27.7215109, 85.3598087));
        mMap.moveCamera(center);
        mMap.animateCamera(zoom);
        mMap.getUiSettings().setZoomControlsEnabled(true);
    }

    private String getFeatureIdFromIntent() {
        try {
            return getIntent().getStringExtra("service_id");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "";
    }

    private void getGarageOwnerWithSelectedFeatures(GoogleMap mMap) {
        ServiceGarageOwnerBLL serviceGarageOwnerBLL = new ServiceGarageOwnerBLL(feature_id);
        URL.getStrictMode();

        garageList = new ArrayList<>(serviceGarageOwnerBLL.getGarageInfo());
        for (int i = 0; i < garageList.size(); i++) {
            Double lat = Double.parseDouble(garageList.get(i).garageOwner.getLatitude());
            Double longs = Double.parseDouble(garageList.get(i).garageOwner.getLongitude());
            LatLng latLng = new LatLng(lat, longs);
            String nameOfGarage = garageList.get(i).garageOwner.getBusinessName();
            String garage_id = garageList.get(i).garageOwner.get_id();
            String feature_id = garageList.get(i).getFeature().get_id();
            String nameOfFeature = garageList.get(i).getFeature().getFeature();
            String garagePhone = garageList.get(i).getGarageOwner().getContactNo();
            String garageAddress = garageList.get(i).getGarageOwner().getAddress();

            placeMarkerOnMap(mMap, latLng, nameOfGarage, garage_id, feature_id, nameOfFeature ,garagePhone, garageAddress);
        }

    }

    private void placeMarkerOnMap(GoogleMap mMap, LatLng latLng, String nameOfGarage, String garage_id, String feature_id, String nameOfFeature, String phoneNo, String garageAddress) {
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                Intent intent = new Intent(getApplicationContext(), user_hiring_page.class);
                intent.putExtra("name", nameOfGarage);
                intent.putExtra("garage_id", garage_id);
                intent.putExtra("feature_id", feature_id);
                intent.putExtra("feature_name", nameOfFeature);
                intent.putExtra("garage_phone", phoneNo);
                intent.putExtra("garage_address", garageAddress);
                startActivity(intent);
                return false;
            }
        });
         mMap.addMarker(new MarkerOptions().position(latLng).title(nameOfGarage));
    }
}