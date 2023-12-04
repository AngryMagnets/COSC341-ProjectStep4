package com.example.projectstep4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MakeListing extends AppCompatActivity {
    EditText accommodations;
    EditText numGuests;
    EditText numBeds;
    EditText numBaths;
    CheckBox laundry;
    CheckBox kitchen;
    EditText disabilityAccommodations;
    CheckBox pa;
    CheckBox ca;
    CheckBox sa;
    EditText postal;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.make_listing);
        Intent intent = getIntent();
        accommodations = findViewById(R.id.answer1);
        accommodations.setText(intent.getStringExtra("accommodations"));
        numGuests =  findViewById(R.id.guests);
        numGuests.setText(intent.getIntExtra("numGuests",1)+"");
        numBeds = findViewById(R.id.beds);
        numBeds.setText(intent.getIntExtra("numBeds",1)+"");
        numBaths = findViewById(R.id.bathrooms);
        numBaths.setText(intent.getIntExtra("numBaths",1)+"");
        laundry = findViewById(R.id.laundry);
        laundry.setChecked(intent.getBooleanExtra("laundry",false));
        kitchen = findViewById(R.id.kitchen);
        kitchen.setChecked(intent.getBooleanExtra("kitchen", false));
        disabilityAccommodations = findViewById(R.id.answer2);
        disabilityAccommodations.setText(intent.getStringExtra("disability"));
        pa = findViewById(R.id.pa);
        pa.setChecked(intent.getBooleanExtra("pa", false));
        ca = findViewById(R.id.ca);
        ca.setChecked(intent.getBooleanExtra("ca", false));
        sa = findViewById(R.id.sa);
        sa.setChecked(intent.getBooleanExtra("sa", false));
        postal = findViewById(R.id.answer);
        postal.setText(intent.getStringExtra("postal"));

    }
    public void next(View view){
        if(accommodations.getText().toString().length() < 1|| disabilityAccommodations.getText().toString().length() < 1 || postal.getText().toString().length() !=6){
            CharSequence text = "Please enter correct/complete information";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(this, text, duration);
            toast.show();
        }
        else {
            Intent intent = new Intent(this, ImageUpload.class);
            Bundle saved = new Bundle();
            saved.putString("accommodations", accommodations.getText().toString());
            saved.putInt("numGuests", Integer.parseInt(numGuests.getText().toString()));
            saved.putInt("numBeds", Integer.parseInt(numBeds.getText().toString()));
            saved.putInt("numBaths", Integer.parseInt(numBaths.getText().toString()));
            saved.putBoolean("laundry", laundry.isChecked());
            saved.putBoolean("kitchen", kitchen.isChecked());
            saved.putString("disability", disabilityAccommodations.getText().toString());
            saved.putBoolean("pa", pa.isChecked());
            saved.putBoolean("ca", ca.isChecked());
            saved.putBoolean("sa", sa.isChecked());
            saved.putString("postal", postal.getText().toString());
            intent.putExtras(saved);
            startActivity(intent);
        }
    }
    public void back(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}