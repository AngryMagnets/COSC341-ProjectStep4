package com.example.projectstep4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.Group;
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
    ArrayList<ListingProfile> listings;

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
        listings = new ArrayList<>(3);
        UiSettings ui = mMap.getUiSettings();
        ui.setZoomControlsEnabled(true);

        double[] coordArr = {49.870198566631, -119.34375121840836};
        String[] petTypes = {"Dog", "Cat",};
        Integer[] petNums = {1, 1};
        String[] disability = {"None"};
        listings.add(new ListingProfile(1, "George", "Miller", "1462 Jayson Road", "V1P1K8", coordArr, petTypes, petNums, disability, 3, 0, false, false, false));
        coordArr[0] = 49.87146849405429; coordArr[1] = -119.3545056450083;
        petTypes = new String[]{"Reptiles"}; petNums = new Integer[]{1}; disability = new String[]{"Stair Lift"};
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
        mMap.moveCamera(CameraUpdateFactory.zoomTo(10));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(49.8801, -119.4436)));
    }

    public void search (View v)
    {
        CheckBox[] generalBoxes = {findViewById(R.id.checkBox), findViewById(R.id.checkBox2), findViewById(R.id.checkBox3)}
                 , disabilityBoxes = {findViewById(R.id.checkBox4), findViewById(R.id.checkBox5), findViewById(R.id.checkBox6), findViewById(R.id.checkBox7)};
        EditText[] petFields = {findViewById(R.id.editTextNumber), findViewById(R.id.editTextNumber2), findViewById(R.id.editTextNumber3),
                                findViewById(R.id.editTextNumber4), findViewById(R.id.editTextNumber5)};
        EditText numPeople = findViewById(R.id.editTextNumber6);
        int bus = ((Spinner)findViewById(R.id.spinner)).getSelectedItemPosition(), people = Integer.parseInt(((EditText)findViewById(R.id.editTextNumber6)).getText().toString());

        ArrayList<Boolean> general = new ArrayList<>();
        ArrayList<String> disability = new ArrayList<>(), petTypes = new ArrayList<>();
        ArrayList<Integer> petNums = new ArrayList<>();
        ListingProfile lp;

        for (CheckBox c : generalBoxes)
        {
            general.add(c.isChecked());
        }
        for (CheckBox c : disabilityBoxes)
        {
            if (c.isChecked())
            {
                disability.add(c.getText().toString());
            }
        }
        for (EditText e : petFields)
        {
            String s = e.getText().toString();
            if (!s.isEmpty())
            {
                petTypes.add(s.toString());
                int i = Integer.parseInt(s);
                petNums.add(i);
            }
        }
        String lORpc = ((EditText)findViewById(R.id.typeSearchHere)).getText().toString();
        lp = new ListingProfile(lORpc, lORpc, (String[])(petTypes.toArray()), (Integer[])(petNums.toArray()), (String[])(disability.toArray()), people, bus, general.get(0), general.get(1), general.get(2));
    }
    public void updatePins (ListingProfile searchLP)
    {
        boolean validListing;
        mMap.clear();
        for (ListingProfile lp : listings)
        {
            validListing = searchLP.postalCode.equals(lp.postalCode) || searchLP.location.equals(lp.location);
            if (validListing)
            {
                mMap.addMarker(new MarkerOptions().position(new LatLng(lp.coordinates[0], lp.coordinates[1])));
            }
        }
    }

    public void toggleFilters (View v)
    {
        Group filterParent = findViewById(R.id.searchFilterGroup);
        switch(filterParent.getVisibility())
        {
            case View.VISIBLE:
                filterParent.setVisibility(View.GONE);
                break;
            case View.GONE:
                filterParent.setVisibility(View.VISIBLE);
        }
    }
}
