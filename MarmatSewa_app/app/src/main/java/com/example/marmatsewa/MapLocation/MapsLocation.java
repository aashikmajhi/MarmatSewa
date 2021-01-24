package com.example.marmatsewa.MapLocation;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.example.marmatsewa.R;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsLocation extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private CameraUpdate zoom, center;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_location);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng Softwarica = new LatLng(27.7062581,85.3278125);
        LatLng Boudha = new LatLng(27.7231762,85.3510666);
        LatLng Chisapani = new LatLng(27.7474555,85.2525451);
        LatLng Siddhapokhari = new LatLng(27.6719705,85.4182473);
        LatLng GOD = new LatLng(27.7141308,85.3123154);

        mMap.addMarker(new MarkerOptions().position(Softwarica).title("Marker in Softwarica"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Softwarica));

        mMap.addMarker(new MarkerOptions().position(Boudha).title("Marker in Boudha"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Boudha));

        mMap.addMarker(new MarkerOptions().position(Chisapani).title("Marker in Chisapani"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Chisapani));

        mMap.addMarker(new MarkerOptions().position(Siddhapokhari).title("Marker in Siddhapokhari"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Siddhapokhari));

        mMap.addMarker(new MarkerOptions().position(GOD).title("Marker in Garden Of Dreams"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(GOD));

        zoom=CameraUpdateFactory.zoomTo(12);
        center=CameraUpdateFactory.newLatLng(new LatLng(27.7215109, 85.3598087));
        mMap.moveCamera(center);
        mMap.animateCamera(zoom);
        mMap.getUiSettings().setZoomControlsEnabled(true);
    }
}