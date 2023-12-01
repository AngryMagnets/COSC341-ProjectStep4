package com.example.projectstep4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate (Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button list = findViewById(R.id.listingSearchButton), chat = findViewById(R.id.chatsButton);

        list.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View view)
            {
                Intent i = new Intent(view.getContext(), ListingsPrototype.class);
                startActivity(i);
            }
        });
        chat.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View view)
            {
                Intent i = new Intent(view.getContext(), ChatsPrototype.class);
                startActivity(i);
            }
        });
    }

    public void task1(View view){
        Intent intent = new Intent(this, MakeListing.class);
        startActivity(intent);
    }
    public void task4(View view){
        Intent intent = new Intent(this, NewsActivity.class);
        startActivity(intent);
    }
    public void task5(View view){

    }
}