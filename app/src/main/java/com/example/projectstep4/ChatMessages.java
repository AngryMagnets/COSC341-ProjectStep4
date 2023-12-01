package com.example.projectstep4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Date;

public class ChatMessages extends AppCompatActivity
{

    @Override
    protected void onCreate (Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_messages);

        RecyclerView rv = findViewById(R.id.messagesArea);
        Intent i = getIntent();
        int chatID = i.getIntExtra("Chat", -1);
        if (chatID == -1)
        {
            finish();
        }

        ArrayList<Message> messages = new ArrayList<>();
        switch (chatID)
        {
            case 1:
                messages.add(new Message("0", chatID+"", "Test message 1 to contact 1"));
                messages.add(new Message(chatID+"", "0", "Test message 1 from contact 1. abcdefghijklmnopqrstuvwxyz."));
                messages.add(new Message("0", chatID+"","Test message 2 to contact 1"));
                messages.add(new Message(chatID+"", "0","Test message 2 from contact 1. a very incredibly stupendously ridiculously hilariously freakishly bafflingly plentifully runningoutofadverbsly long message."));
                break;
            case 2:
                messages.add(new Message("0", chatID+"", "Test message 1 to contact 2"));
                messages.add(new Message(chatID+"", "0", "Test message 1 from contact 2. abcdefghijklmnopqrstuvwxyz."));
                messages.add(new Message("0", chatID+"","Test message 2 to contact 2"));
                messages.add(new Message(chatID+"", "0","Test message 2 from contact 2. a very incredibly stupendously ridiculously hilariously freakishly bafflingly plentifully runningoutofadverbsly long message."));
                break;
            case 3:
                messages.add(new Message("0", chatID+"", "Test message 1 to contact 2"));
                messages.add(new Message(chatID+"", "0", "Test message 1 from contact 2. abcdefghijklmnopqrstuvwxyz."));
                messages.add(new Message("0", chatID+"","Test message 2 to contact 2"));
                messages.add(new Message(chatID+"", "0","Test message 2 from contact 2. a very incredibly stupendously ridiculously hilariously freakishly bafflingly plentifully runningoutofadverbsly long message."));
                break;
            case 4:
                messages.add(new Message("0", chatID+"", "Test message 1 to contact 2"));
                messages.add(new Message(chatID+"", "0", "Test message 1 from contact 2. abcdefghijklmnopqrstuvwxyz."));
                messages.add(new Message("0", chatID+"","Test message 2 to contact 2"));
                messages.add(new Message(chatID+"", "0","Test message 2 from contact 2. a very incredibly stupendously ridiculously hilariously freakishly bafflingly plentifully runningoutofadverbsly long message."));
                break;
            case 5:
                messages.add(new Message("0", chatID+"", "Test message 1 to contact 2"));
                messages.add(new Message(chatID+"", "0", "Test message 1 from contact 2. abcdefghijklmnopqrstuvwxyz."));
                messages.add(new Message("0", chatID+"","Test message 2 to contact 2"));
                messages.add(new Message(chatID+"", "0","Test message 2 from contact 2. a very incredibly stupendously ridiculously hilariously freakishly bafflingly plentifully runningoutofadverbsly long message."));
                break;
            case 6:
                messages.add(new Message("0", chatID+"", "Test message 1 to contact 2"));
                messages.add(new Message(chatID+"", "0", "Test message 1 from contact 2. abcdefghijklmnopqrstuvwxyz."));
                messages.add(new Message("0", chatID+"","Test message 2 to contact 2"));
                messages.add(new Message(chatID+"", "0","Test message 2 from contact 2. a very incredibly stupendously ridiculously hilariously freakishly bafflingly plentifully runningoutofadverbsly long message."));
                break;
            case 7:
                messages.add(new Message("0", chatID+"", "Test message 1 to contact 2"));
                messages.add(new Message(chatID+"", "0", "Test message 1 from contact 2. abcdefghijklmnopqrstuvwxyz."));
                messages.add(new Message("0", chatID+"","Test message 2 to contact 2"));
                messages.add(new Message(chatID+"", "0","Test message 2 from contact 2. a very incredibly stupendously ridiculously hilariously freakishly bafflingly plentifully runningoutofadverbsly long message."));
                break;
            default:
                // File bullshit
                break;
        }
    }
}