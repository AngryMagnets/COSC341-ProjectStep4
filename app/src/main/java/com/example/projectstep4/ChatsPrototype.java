package com.example.projectstep4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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
        EditText nameSearch = findViewById(R.id.typeSearchHere);

        for (int i = 0; i < numChats; i++)
        {
            int id = getResources().getIdentifier("chat"+(i+1), "id", getPackageName());
            chats[i] = (Button) findViewById(id);
        }

        for (int i = 0; i < numChats; i++)
        {
            int finalI = i+1;
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

        nameSearch.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged (CharSequence s, int start, int count, int after)
            {

            }

            @Override
            public void onTextChanged (CharSequence s, int start, int before, int count)
            {

            }

            @Override
            public void afterTextChanged (Editable s)
            {
                String t = s.toString();
                ImageView[] pfps = new ImageView[numChats];
                for (int i = 0; i < numChats; i++)
                {
                    int id = getResources().getIdentifier("chatImage"+(i+1), "id", getPackageName());
                    pfps[i] = (ImageView) findViewById(id);
                }
                for (int i = 0; i < numChats; i++)
                {
                    if (chats[i].getText().toString().toLowerCase().contains(t.toLowerCase()))
                    {
                        chats[i].setVisibility(View.VISIBLE);
                        pfps[i].setVisibility(View.VISIBLE);
                    }
                    else
                    {
                        chats[i].setVisibility(View.GONE);
                        pfps[i].setVisibility(View.GONE);
                    }
                }
            }
        });
    }
    public void back(View view)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void help (View v)
    {
        Intent i = new Intent(this, Help.class);
        i.putExtra("Task", 2);
        startActivity(i);
    }
}