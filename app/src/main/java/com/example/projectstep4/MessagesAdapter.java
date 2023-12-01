package com.example.projectstep4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MessagesAdapter extends RecyclerView.Adapter
{
    Context context;
    ArrayList<Message> messagesArrayList;

    String userID;

    int ITEM_SEND=1;
    int ITEM_RECIEVE=2;

    public MessagesAdapter(Context context, ArrayList<Message> messagesArrayList, String uID)
    {
        this.context = context;
        this.messagesArrayList = messagesArrayList;
        userID = uID;
    }

    @NonNull @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        if(viewType==ITEM_SEND)
        {
            View view= LayoutInflater.from(context).inflate(R.layout.sent_message,parent,false);
            return new SenderViewHolder(view);
        }
        else
        {
            View view= LayoutInflater.from(context).inflate(R.layout.rcvd_message,parent,false);
            return new RecieverViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position)
    {

        Message message = messagesArrayList.get(position);
        if(holder.getClass() == SenderViewHolder.class)
        {
            SenderViewHolder viewHolder=(SenderViewHolder)holder;
            viewHolder.messaage.setText(message.getContent());
            //viewHolder.timeStamp.setText(message.getTimeStamp().toString());
        }
        else
        {
            RecieverViewHolder viewHolder=(RecieverViewHolder)holder;
            viewHolder.message.setText(message.getContent());
            //viewHolder.timeStamp.setText(message.getTimeStamp().toString());
        }
    }


    @Override
    public int getItemViewType(int position)
    {
        Message messages = messagesArrayList.get(position);
        if(true /*sender ID*/)

        {
            return  ITEM_SEND;
        }
        else
        {
            return ITEM_RECIEVE;
        }
    }

    @Override
    public int getItemCount()
    {
        return messagesArrayList.size();
    }
    class SenderViewHolder extends RecyclerView.ViewHolder
    {
        TextView messaage;
        TextView timeStamp;
        public SenderViewHolder(@NonNull View itemView)
        {
            super(itemView);
            messaage=itemView.findViewById(R.id.sent_message);
        }
    }
    class RecieverViewHolder extends RecyclerView.ViewHolder
    {
        TextView message;
        TextView timeStamp;
        public RecieverViewHolder(@NonNull View itemView)
        {
            super(itemView);
            message=itemView.findViewById(R.id.rcvd_message);
        }
    }
}