package com.example.projectstep4;

import java.sql.Date;

public class Message
{
    String chatID, content;
    Date timeStamp;

    public Message(String senderID, String receiverID, String c, Date t)
    {
        chatID = senderID + "_" + receiverID;
        content = c;
        timeStamp = t;
    }

    public String getChatID ()
    {
        return chatID;
    }
    public String getContent ()
    {
        return content;
    }
    public Date getTimeStamp ()
    {
        return timeStamp;
    }
}
