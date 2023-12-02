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
import com.example.projectstep4.databinding.ActivityListingsPrototypeBinding;


public class ListingsPrototype extends FragmentActivity implements OnMapReadyCallback
{

    private GoogleMap mMap;
    private ActivityListingsPrototypeBinding binding;

    @Override
    protected void onCreate (Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listings_prototype);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady (GoogleMap googleMap)
    {
        mMap = googleMap;
        UiSettings ui = mMap.getUiSettings();
        ui.setZoomControlsEnabled(true);
        LatLng Kelowna = new LatLng(49.8801, -119.4436);
        mMap.addMarker(new MarkerOptions().position(Kelowna).title("Marker"));
        mMap.moveCamera(CameraUpdateFactory.zoomTo(10));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Kelowna));
    }
}
