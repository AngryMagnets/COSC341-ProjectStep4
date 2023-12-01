package com.example.projectstep4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.projectstep4.databinding.ActivityMakeReport2Binding;


public class MakeReport2 extends FragmentActivity implements OnMapReadyCallback{

    private GoogleMap mMap;
    private ActivityMakeReport2Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_report2);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        UiSettings ui = mMap.getUiSettings();
        ui.setZoomControlsEnabled(true);
        // Add a marker in Sydney and move the camera
        LatLng Kelowna = new LatLng(49.8801, -119.4436);
        mMap.addMarker(new MarkerOptions().position(Kelowna).title("Hold Marker to Drag").draggable(true));
        mMap.moveCamera(CameraUpdateFactory.zoomTo(10));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Kelowna));
    }

    public void back(View view){
        Intent intent = new Intent(this, MakeReport.class);
        startActivity(intent);
    }

    public void submit(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}