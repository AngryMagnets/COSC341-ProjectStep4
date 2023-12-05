package com.example.projectstep4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Help extends AppCompatActivity
{

    @Override
    protected void onCreate (Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        Intent i = getIntent();
        int task = i.getIntExtra("Task", 0);
        TextView helpText = findViewById(R.id.helpText);

        switch (task)
        {
            case 1:
                helpText.setText("This is the information on how to use the make listing feature of this app:\n-Info\n-Info 2\n-Info 3");
                break;
            case 2:
                helpText.setText("This is the information on how to use the chats feature of this app:\n-Info\n-Info 2\n-Info 3\n\nOther Feature:\n-Info 1\n- Info 2");
                break;
            case 3:
                helpText.setText("This is the information on how to use the listing map feature of this app:\n-Info\n-Info 2\n-Info 3\n\nOther Feature:\n-Info 1\n- Info 2");
                break;
            case 4:
                helpText.setText("This is the information on how to use the news and disaster map features of this app:\n-Info\n-Info 2\n-Info 3\n\nOther Feature:\n-Info 1\n- Info 2");
                break;
            case 5:
                helpText.setText("IF IT IS AN EMERGENCY CALL THE APPROPRIATE AUTHORITIES BEFORE MAKING A REPORT\nThis is the information on how to use the disaster report feature of this app:\n-Info\n-Info 2\n-Info 3\n\nOther Feature:\n-Info 1\n- Info 2");
                break;
        }
    }

    public void back (View v)
    {
        finish();
    }
}