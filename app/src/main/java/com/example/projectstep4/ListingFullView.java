package com.example.projectstep4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListingFullView extends AppCompatActivity
{

    @Override
    protected void onCreate (Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listing_full_view);

        Intent i = getIntent();
        ListingProfile lp = i.getSerializableExtra("Listing Profile", ListingProfile.class);

        ImageView img = findViewById(R.id.imageView3);
        TextView primary = findViewById(R.id.textView25), pets = findViewById(R.id.textView26), general = findViewById(R.id.textView27);
        String pmrStr, petStr, genStr;

        pmrStr = "Postal Code: " + lp.postalCode + "\nOwner Name: " + lp.getfName();

        petStr = "Pets Allowed: ";
        ArrayList<String> als = (ArrayList<String>) lp.petsAllowed.keySet(); ArrayList<Integer> ali = (ArrayList<Integer>) lp.petsAllowed.values();
    }

    public void back (View v)
    {
        finish();
    }
}