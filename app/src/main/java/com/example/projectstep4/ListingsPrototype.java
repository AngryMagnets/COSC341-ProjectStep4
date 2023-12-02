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

import java.util.ArrayList;


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
        ArrayList<ListingProfile> listings = new ArrayList<>(3);
        UiSettings ui = mMap.getUiSettings();
        ui.setZoomControlsEnabled(true);

        double[] coordArr = {49.870198566631, -119.34375121840836};
        String[] petTypes = {"Dog", "Cat",};
        Integer[] petNums = {1, 1};
        String[] disability = {"None"};
        listings.add(new ListingProfile(1, "George", "Miller", "1462 Jayson Road", "V1P1K8", coordArr, petTypes, petNums, disability, 3, 0, false, false, false));
        coordArr[0] = 49.87146849405429; coordArr[1] = -119.3545056450083;
        petTypes = new String[]{"Fishtank"}; petNums = new Integer[]{1}; disability = new String[]{"Stair Lift"};
        listings.add(new ListingProfile(2, "Cucumberpatch", "Bundersnunds", "1650 Wilmot Avenue", "V1P1M8", coordArr, petTypes, petNums, disability, 4, 1, true, false, true));
        coordArr[0] = 49.88512587673185; coordArr[1] = -119.47984105852287;
        petTypes = new String[]{"Rodent", "Bird"}; petNums = new Integer[]{3, 3}; disability = new String[]{"Braille"};
        listings.add(new ListingProfile(3, "Lee-Harvey", "Oswald", "1650 Wilmot Avenue", "V1Y6M3", coordArr, petTypes, petNums, disability, 1, 0, false, true, false));

        for (ListingProfile lp : listings)
        {
            LatLng ll = new LatLng(lp.coordinates[0], lp.coordinates[1]);
            mMap.addMarker(new MarkerOptions().position(ll).title(lp.location));
        }
//        mMap.addMarker(new MarkerOptions().position(Kelowna).title("Marker"));
//        mMap.moveCamera(CameraUpdateFactory.zoomTo(10));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng());
    }
}
