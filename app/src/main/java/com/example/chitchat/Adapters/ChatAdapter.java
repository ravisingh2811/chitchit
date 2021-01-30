package com.example.chitchat.Adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chitchat.Models.MessageModel;
import com.example.chitchat.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.time.Year;
import java.util.ArrayList;

public class ChatAdapter extends RecyclerView.Adapter{

    ArrayList<MessageModel> messageModels;
    Context context;
    int SENDER_VIEW_TYPE = 1;
    int RECEIVER_VIEW_TYPE = 2;

    public ChatAdapter(ArrayList<MessageModel> messageModels, Context context) {
        this.messageModels = messageModels;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType == SENDER_VIEW_TYPE)
        {
           View view = LayoutInflater.from(context).inflate(R.layout.sample_sender , parent , false) ;
           return new SenderViewHolder(view);
        }
        else
        {
            View view = LayoutInflater.from(context).inflate(R.layout.sample_reciever , parent , false) ;
            return new RecieverViewHolder(view);
        }
    }

    @Override
    public int getItemViewType(int position){

        if(messageModels.get(position).getuId().equals(FirebaseAuth.getInstance().getUid()))
        {
            return SENDER_VIEW_TYPE;

        }
        else
        {
            return RECEIVER_VIEW_TYPE;
        }
    }


    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        MessageModel messageModel = messageModels.get(position);


        if(holder.getClass() == SenderViewHolder.class){
            ((SenderViewHolder)holder).senderMsg.setText(messageModel.getMessage());



        }
        else {
            ((RecieverViewHolder)holder).recieverMsg.setText(messageModel.getMessage());
        }


    }

    @Override
    public int getItemCount() {
        return messageModels.size();
    }

    public class RecieverViewHolder extends RecyclerView.ViewHolder {

        TextView recieverMsg , recievertime;

        public RecieverViewHolder(@NonNull View itemView) {
            super(itemView);

           recieverMsg = itemView.findViewById(R.id.recieverText) ;
            recievertime= itemView.findViewById(R.id.recieverTime) ;
        }
    }
    public class SenderViewHolder extends RecyclerView.ViewHolder {

        TextView senderMsg , senderTime;

        public SenderViewHolder(@NonNull View itemView) {


            super(itemView);
            senderMsg = itemView.findViewById(R.id.senderText);
            senderTime = itemView.findViewById(R.id.senderTime);

        }
    }

}
