package com.example.projectstep4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

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
        Set<String> ALS = lp.petsAllowed.keySet();
        String[] als = new String[5]; als = ALS.toArray(als);
        Collection<Integer> ALI = lp.petsAllowed.values();
        Integer[] ali = new Integer[5]; ali = ALI.toArray(ali);
        for(int j = 0; j < lp.petsAllowed.size(); j++)
        {
            petStr += "\n" + als[j] + ": " + ali[j];
        }

        genStr = "General Info: ";
        genStr += "\nChildren Allowed: " + lp.childrenAllowed
                + "\nSmoking Allowed: " + lp.smokingAllowed
                + "\nWill Help Move Items: " + lp.willHelpMoveItems + "\n"
                + "\nDisability Accommodations: ";
        for (String s : lp.disabilityAccommodations)
        {
            genStr += "\n" + s;
        }
        primary.setText(pmrStr); pets.setText(petStr); general.setText(genStr);

        try (BufferedReader br = new BufferedReader(new FileReader(new File(this.getFilesDir().getPath()))))
        {
            AtomicInteger id  = new AtomicInteger();
            br.lines().forEach(s -> {
                id.getAndIncrement();
                if (id.intValue()+3  == lp.getpID())
                {
                    String u = s.substring(s.lastIndexOf('>') + 1);
                    img.setImageURI(Uri.parse(u));
                }
            });
        }
        catch (FileNotFoundException e)
        {
            throw new RuntimeException(e);
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
//        Uri u = Uri.parse();
//        img.setImageURI(u);
    }

    public void back (View v)
    {
        finish();
    }
}