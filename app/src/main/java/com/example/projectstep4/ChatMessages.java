package com.example.projectstep4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;

public class ChatMessages extends AppCompatActivity
{
    RecyclerView rv;
    ArrayList<Message> messages;

    @Override
    protected void onCreate (Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_messages);

        Button send = findViewById(R.id.sendButton);
        EditText message = findViewById(R.id.typeMessageHere);

        rv = findViewById(R.id.messagesArea);
        Intent i = getIntent();
        int chatID = i.getIntExtra("Chat", -1);
        if (chatID == -1)
        {
            finish();
        }

        messages = new ArrayList<>();
        switch (chatID)
        {
            case 1:
                messages.add(new Message("0", chatID + "", "Test message 1 to contact 1"));
                messages.add(new Message(chatID + "", "0", "Test message 1 from contact 1. abcdefghijklmnopqrstuvwxyz."));
                messages.add(new Message("0", chatID + "", "Test message 2 to contact 1"));
                messages.add(new Message(chatID + "", "0", "Test message 2 from contact 1. a very incredibly stupendously ridiculously hilariously freakishly bafflingly plentifully runningoutofadverbsly long message."));
                break;
            case 2:
                messages.add(new Message("0", chatID + "", "Test message 1 to contact 2"));
                messages.add(new Message(chatID + "", "0", "Test message 1 from contact 2. abcdefghijklmnopqrstuvwxyz."));
                messages.add(new Message("0", chatID + "", "Test message 2 to contact 2"));
                messages.add(new Message(chatID + "", "0", "Test message 2 from contact 2. a very incredibly stupendously ridiculously hilariously freakishly bafflingly plentifully runningoutofadverbsly long message."));
                break;
            case 3:
                messages.add(new Message("0", chatID + "", "Test message 1 to contact 3"));
                messages.add(new Message(chatID + "", "0", "Test message 1 from contact 3. abcdefghijklmnopqrstuvwxyz."));
                messages.add(new Message("0", chatID + "", "Test message 2 to contact 3"));
                messages.add(new Message(chatID + "", "0", "Test message 2 from contact 3. a very incredibly stupendously ridiculously hilariously freakishly bafflingly plentifully runningoutofadverbsly long message."));
                break;
            case 4:
                messages.add(new Message("0", chatID + "", "Test message 1 to contact 4"));
                messages.add(new Message(chatID + "", "0", "Test message 1 from contact 4. abcdefghijklmnopqrstuvwxyz."));
                messages.add(new Message("0", chatID + "", "Test message 2 to contact 4"));
                messages.add(new Message(chatID + "", "0", "Test message 2 from contact 4. a very incredibly stupendously ridiculously hilariously freakishly bafflingly plentifully runningoutofadverbsly long message."));
                break;
            case 5:
                messages.add(new Message("0", chatID + "", "Test message 1 to contact 5"));
                messages.add(new Message(chatID + "", "0", "Test message 1 from contact 5. abcdefghijklmnopqrstuvwxyz."));
                messages.add(new Message("0", chatID + "", "Test message 2 to contact 5"));
                messages.add(new Message(chatID + "", "0", "Test message 2 from contact 5. a very incredibly stupendously ridiculously hilariously freakishly bafflingly plentifully runningoutofadverbsly long message."));
                break;
            case 6:
                messages.add(new Message("0", chatID + "", "Test message 1 to contact 6"));
                messages.add(new Message(chatID + "", "0", "Test message 1 from contact 6. abcdefghijklmnopqrstuvwxyz."));
                messages.add(new Message("0", chatID + "", "Test message 2 to contact 6"));
                messages.add(new Message(chatID + "", "0", "Test message 2 from contact 6. a very incredibly stupendously ridiculously hilariously freakishly bafflingly plentifully runningoutofadverbsly long message."));
                break;
            case 7:
                messages.add(new Message("0", chatID + "", "Test message 1 to contact 7"));
                messages.add(new Message(chatID + "", "0", "Test message 1 from contact 7. abcdefghijklmnopqrstuvwxyz."));
                messages.add(new Message("0", chatID + "", "Test message 2 to contact 7"));
                messages.add(new Message(chatID + "", "0", "Test message 2 from contact 7. a very incredibly stupendously ridiculously hilariously freakishly bafflingly plentifully runningoutofadverbsly long message."));
                break;
            default:
                // File bullshit
                break;
        }
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setStackFromEnd(true);
        rv.setLayoutManager(llm);
        MessagesAdapter ma = new MessagesAdapter(ChatMessages.this, messages, "0");
        rv.setAdapter(ma);

        send.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v)
            {
                if (!message.getText().toString().isEmpty())
                {
                    messages.add(new Message("0", chatID+"", message.getText().toString()));
                    refresh();
                }
            }
        });
    }
    public void refresh ()
    {
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setStackFromEnd(true);
        rv.setLayoutManager(llm);
        MessagesAdapter ma = new MessagesAdapter(ChatMessages.this, messages, "0");
        rv.setAdapter(ma);
    }

    public void onStop ()
    {
        super.onStop();
        FileOutputStream fos;
        File f = getApplicationContext().getFilesDir();
        try
        {
            fos = new FileOutputStream(f);
        }
        catch (IOException ioe)
        {

        }
    }
}