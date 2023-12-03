package com.example.projectstep4;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
import java.util.Arrays;


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

        double[] coordArr = {49.9246018490676, -119.39788471603666};
        String[] petTypes = {"Dogs", "Cats",};
        Integer[] petNums = {1, 1};
        String[] disability = {"None"};
        listings.add(new ListingProfile(1, "George", "Miller", "2550 Hollywood Rd N", "V1V2S6", coordArr, petTypes, petNums, disability, 3, 0, false, false, false));
        coordArr[0] = 49.87146513845679; coordArr[1] = -119.35451099325275;
        petTypes = new String[]{"Reptiles"}; petNums = new Integer[]{1}; disability = new String[]{"Stair Lift"};
        listings.add(new ListingProfile(2, "Cucumberpatch", "Bundersnunds", "1650 Wilmot Avenue", "V1P1M8", coordArr, petTypes, petNums, disability, 4, 1, true, false, true));
        coordArr[0] = 49.88512587673185; coordArr[1] = -119.47984105852287;
        petTypes = new String[]{"Rodents", "Birds"}; petNums = new Integer[]{3, 3}; disability = new String[]{"Braille"};
        listings.add(new ListingProfile(3, "Lee-Harvey", "Oswald", "1650 Wilmot Avenue", "V1Y6M3", coordArr, petTypes, petNums, disability, 1, 0, false, true, false));

        LatLng[] ll = {new LatLng(listings.get(0).coordinates[0], listings.get(0).coordinates[1]),
                       new LatLng(listings.get(1).coordinates[0], listings.get(1).coordinates[1]),
                       new LatLng(listings.get(2).coordinates[0], listings.get(2).coordinates[1])};
        mMap.addMarker(new MarkerOptions().position(ll[0]).title(listings.get(0).location));
        mMap.addMarker(new MarkerOptions().position(ll[1]).title(listings.get(1).location));
        mMap.addMarker(new MarkerOptions().position(ll[2]).title(listings.get(2).location));

//        mMap.addMarker(new MarkerOptions().position(Kelowna).title("Marker"));
        mMap.moveCamera(CameraUpdateFactory.zoomTo(10));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(49.8801, -119.4436)));
    }
    public void back (View v)
    {
        finish();
    }
    public void search (View v)
    {
        CheckBox[] generalBoxes = {findViewById(R.id.checkBox), findViewById(R.id.checkBox2), findViewById(R.id.checkBox3)}
                 , disabilityBoxes = {findViewById(R.id.checkBox4), findViewById(R.id.checkBox5), findViewById(R.id.checkBox6), findViewById(R.id.checkBox7)};
        EditText[] petFields = {findViewById(R.id.editTextNumber), findViewById(R.id.editTextNumber2), findViewById(R.id.editTextNumber3),
                                findViewById(R.id.editTextNumber4), findViewById(R.id.editTextNumber5)};
        EditText numPeople = findViewById(R.id.editTextNumber6);
        int bus = ((Spinner)findViewById(R.id.spinner)).getSelectedItemPosition()
                , people = (((EditText)findViewById(R.id.editTextNumber6)).getText().toString()).equals("") ? 1 : Integer.parseInt(((EditText)findViewById(R.id.editTextNumber6)).getText().toString());

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
        String lORpc = ((EditText)findViewById(R.id.editTextText)).getText().toString();
        lp = new ListingProfile(lORpc, lORpc, (petTypes.toArray(new String[petTypes.size()])), (petNums.toArray(new Integer[petNums.size()])), (disability.toArray(new String[disability.size()])), people, bus, general.get(0), general.get(1), general.get(2));
        updatePins(lp);
        toggleFilters();
    }
    public void updatePins (ListingProfile searchLP)
    {
        boolean validListing;
        mMap.clear();
        for (ListingProfile lp : listings)
        {
            validListing = (lp.postalCode.contains(searchLP.postalCode) || lp.location.contains(searchLP.location) || searchLP.postalCode.isEmpty()) &&
                           (searchLP.childrenAllowed == lp.childrenAllowed || searchLP.childrenAllowed == false) &&
                            searchLP.smokingAllowed == lp.smokingAllowed &&
                           (searchLP.willHelpMoveItems == lp.willHelpMoveItems || searchLP.willHelpMoveItems == true) &&
                            searchLP.peopleAllowed <= lp.peopleAllowed && searchLP.proximityToBus >= lp.proximityToBus;
            if (searchLP.getPetsAllowed().containsKey("Dogs"))
            {
                if (lp.petsAllowed.containsKey("Dogs"))
                {
                    validListing = validListing && lp.petsAllowed.get("Dogs") >= searchLP.petsAllowed.get("Dogs");
                }
                else
                {
                    validListing = false;
                }
            }
            if (searchLP.getPetsAllowed().containsKey("Cats"))
            {
                if (lp.petsAllowed.containsKey("Cats"))
                {
                    validListing = validListing && lp.petsAllowed.get("Cats") >= searchLP.petsAllowed.get("Cats");
                }
                else
                {
                    validListing = false;
                }
            }
            if (searchLP.getPetsAllowed().containsKey("Birds"))
            {
                if (lp.petsAllowed.containsKey("Birds"))
                {
                    validListing = validListing && lp.petsAllowed.get("Birds") >= searchLP.petsAllowed.get("Birds");
                }
                else
                {
                    validListing = false;
                }
            }
            if (searchLP.getPetsAllowed().containsKey("Reptiles"))
            {
                if (lp.petsAllowed.containsKey("Reptiles"))
                {
                    validListing = validListing && lp.petsAllowed.get("Reptiles") >= searchLP.petsAllowed.get("Reptiles");
                }
                else
                {
                    validListing = false;
                }
            }
            if (searchLP.getPetsAllowed().containsKey("Rodents"))
            {
                if (lp.petsAllowed.containsKey("Rodents"))
                {
                    validListing = validListing && lp.petsAllowed.get("Rodents") >= searchLP.petsAllowed.get("Rodents");
                }
                else
                {
                    validListing = false;
                }
            }
            for (int i = 0; i < searchLP.disabilityAccommodations.length; i++)
            {
                for (int j = 0; j < lp.disabilityAccommodations.length; i++)
                {
                    if (searchLP.disabilityAccommodations[i].equals(lp.disabilityAccommodations[j]))
                    {
                        validListing = validListing;
                    }
                    else if (j == lp.disabilityAccommodations.length - 1)
                    {
                        validListing = false;
                        break;
                    }
                }
            }
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
    public void toggleFilters ()
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
