package com.example.projectstep4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class ChatMessages extends AppCompatActivity
{

    @Override
    protected void onCreate (Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_messages);

        Intent i = getIntent();
        int chatID = i.getIntExtra("Chat", -1);
        if (chatID == -1)
        {
            finish();
        }

        ArrayList<String> yourMessages = new ArrayList<>()
                        , theirMessages = new ArrayList<>();
        switch (chatID)
        {
            case 1:
                yourMessages.add("Test message 1 to contact 1");
                theirMessages.add("Test message 1 from contact 1. abcdefghijklmnopqrstuvwxyz.");
                yourMessages.add("Test message 2 to contact 1");
                theirMessages.add("Test message 2 from contact 1. a very incredibly stupendously ridiculously hilariously freakishly bafflingly plentifully runningoutofadverbsly long message .");
                break;
            case 2:
                yourMessages.add("Test message 1 to contact 2");
                theirMessages.add("Test message 1 from contact 2. abcdefghijklmnopqrstuvwxyz.");
                yourMessages.add("Test message 2 to contact 2");
                theirMessages.add("Test message 2 from contact 2. a very incredibly stupendously ridiculously hilariously freakishly bafflingly plentifully runningoutofadverbsly long message .");
                break;
            case 3:
                yourMessages.add("Test message 1 to contact 3");
                theirMessages.add("Test message 1 from contact 3. abcdefghijklmnopqrstuvwxyz.");
                yourMessages.add("Test message 2 to contact 3");
                theirMessages.add("Test message 2 from contact 3. a very incredibly stupendously ridiculously hilariously freakishly bafflingly plentifully runningoutofadverbsly long message .");
                break;
            case 4:
                yourMessages.add("Test message 1 to contact 4");
                theirMessages.add("Test message 1 from contact 4. abcdefghijklmnopqrstuvwxyz.");
                yourMessages.add("Test message 2 to contact 4");
                theirMessages.add("Test message 2 from contact 4. a very incredibly stupendously ridiculously hilariously freakishly bafflingly plentifully runningoutofadverbsly long message .");
                break;
            case 5:
                yourMessages.add("Test message 1 to contact 5");
                theirMessages.add("Test message 1 from contact 5. abcdefghijklmnopqrstuvwxyz.");
                yourMessages.add("Test message 2 to contact 5");
                theirMessages.add("Test message 2 from contact 5. a very incredibly stupendously ridiculously hilariously freakishly bafflingly plentifully runningoutofadverbsly long message .");
                break;
            case 6:
                yourMessages.add("Test message 1 to contact 6");
                theirMessages.add("Test message 1 from contact 6. abcdefghijklmnopqrstuvwxyz.");
                yourMessages.add("Test message 2 to contact 6");
                theirMessages.add("Test message 2 from contact 6. a very incredibly stupendously ridiculously hilariously freakishly bafflingly plentifully runningoutofadverbsly long message .");
                break;
            case 7:
                yourMessages.add("Test message 1 to contact 7");
                theirMessages.add("Test message 1 from contact 7. abcdefghijklmnopqrstuvwxyz.");
                yourMessages.add("Test message 2 to contact 7");
                theirMessages.add("Test message 2 from contact 7. a very incredibly stupendously ridiculously hilariously freakishly bafflingly plentifully runningoutofadverbsly long message .");
                break;
        }
    }
}