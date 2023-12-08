package com.example.projectstep4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Toast;
import android.widget.EditText;

public class MakeReport extends AppCompatActivity {

    String disaster;
    boolean next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_report);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK && data != null){
            Uri selectedImage = data.getData();
            ImageButton button = findViewById(R.id.imageButton);
            button.setImageURI(selectedImage);
        }
    }

    public void back(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void next(View view) {
        RadioButton fire = findViewById(R.id.fire);
        RadioButton flood = findViewById(R.id.flood);
        RadioButton earthquake = findViewById(R.id.earthquake);
        RadioButton other = findViewById(R.id.other);
        EditText otherType = findViewById(R.id.otherType);
        if (!other.isChecked()) {
            if (fire.isChecked()) {
                disaster = "Fire";
                next = true;
            } else if (flood.isChecked()) {
                disaster = "Flood";
                next = true;
            } else if (earthquake.isChecked()) {
                disaster = "Earthquake";
                next = true;
            } else {

                CharSequence text = "Select a disaster type";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(this, text, duration);
                toast.show();
                next = false;
            }
        }
        else{
            if(otherType.getText().toString().length() > 0){
               disaster = otherType.getText().toString();
               next = true;
            }
            else{
                CharSequence text = "Explain the disaster";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(this, text, duration);
                toast.show();
                next = false;
            }
        }
        if (next) {
            Intent intent = new Intent(this, MakeReport2.class);
            Bundle extras = new Bundle();
            extras.putString("name",disaster);
            intent.putExtras(extras);
            startActivity(intent);
        }
    }
    public void upload(View view)
    {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, 3);
    }
    public void help (View v)
    {
        Intent i = new Intent(this, Help.class);
        i.putExtra("Task", 5);
        startActivity(i);
    }
}