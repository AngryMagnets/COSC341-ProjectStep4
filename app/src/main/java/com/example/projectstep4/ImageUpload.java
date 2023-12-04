package com.example.projectstep4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.Toast;

public class ImageUpload extends AppCompatActivity {
    String accommodations;
    int numGuests;
    int numBeds;
    int numBaths;
    boolean laundry;
    boolean kitchen;
    String disability;
    boolean pa, ca, sa;
    String postal;
    Uri selectedImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_upload);
        Intent intent = getIntent();
        accommodations = intent.getStringExtra("accommodations");
        numGuests = intent.getIntExtra("numGuests",1);
        numBeds = intent.getIntExtra("numBeds",1);
        numBaths = intent.getIntExtra("numBaths",1);
        laundry = intent.getBooleanExtra("laundry",false);
        kitchen = intent.getBooleanExtra("kitchen", false);
        disability = intent.getStringExtra("disability");
        pa = intent.getBooleanExtra("pa", false);
        ca = intent.getBooleanExtra("ca", false);
        sa = intent.getBooleanExtra("sa", false);
        postal = intent.getStringExtra("postal");
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK && data != null){
            selectedImage = data.getData();
            ImageButton button = findViewById(R.id.imageButton);
            button.setImageURI(selectedImage);
        }
    }
    public void back(View view){
        Intent intent = new Intent(this, MakeListing.class);
        Bundle saved = new Bundle();
        saved.putString("accommodations",accommodations);
        saved.putInt("numGuests",numGuests);
        saved.putInt("numBeds",numBeds);
        saved.putInt("numBaths",numBaths);
        saved.putBoolean("laundry",laundry);
        saved.putBoolean("kitchen", kitchen);
        saved.putString("disability", disability);
        saved.putBoolean("pa", pa);
        saved.putBoolean("ca", ca);
        saved.putBoolean("sa", sa);
        saved.putString("postal", postal);
        intent.putExtras(saved);
        startActivity(intent);
    }

    public void upload(View view){
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, 3);
    }

    public void submit(View view){
        CheckBox checkBox = findViewById(R.id.checkBox8);
        if(checkBox.isChecked()) {
            FileWriter.write("listings.txt", accommodations + ">" + numGuests + ">" + numBeds + ">" + numBaths + ">" + laundry + ">" + kitchen + ">" +
                    disability + ">" + pa + ">" + ca + ">" + sa + ">" + postal + ">" + selectedImage+"\n", this);
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        else{
            CharSequence text = "confirm that the information is accurate";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(this, text, duration);
            toast.show();
        }
    }
}