package com.example.projectstep4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class DisasterMap extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disaster_map);
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
        mMap.moveCamera(CameraUpdateFactory.zoomTo(10));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Kelowna));
        int i = 0;
        String[] line;
        while((line = FileReader.read("reports.txt",this,i))!=null){
            String name = line[0];
            double lat = Double.parseDouble(line[1]);
            double lng = Double.parseDouble(line[2]);
            LatLng here = new LatLng(lat,lng);
            mMap.addMarker(new MarkerOptions().position(here).title(name));
            i++;
        }
    }

    public void back(View view){
        Intent intent = new Intent(this, NewsActivity.class);
        startActivity(intent);
    }
}