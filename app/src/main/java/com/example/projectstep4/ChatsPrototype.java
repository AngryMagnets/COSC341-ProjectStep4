package com.example.projectstep4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class ChatsPrototype extends AppCompatActivity
{

    @Override
    protected void onCreate (Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chats_prototype);

        int numChats = 7;
        Button[] chats = new Button[numChats];

        for (int i = 0; i < numChats; i++)
        {
            int id = getResources().getIdentifier("chat"+(i+1), "id", getPackageName());
            chats[i] = (Button) findViewById(id);
        }

        for (int i = 0; i < numChats; i++)
        {
            int finalI = i;
            chats[i].setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick (View v)
                {
                    Intent intent = new Intent(v.getContext(), ChatMessages.class);
                    intent.putExtra("Chat", finalI);
                    startActivity(intent);
                }
            });
        }
    }
}