package com.example.myapplication;

import static com.example.myapplication.con_mysql.downloadVideo;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class patientstores_adpater extends RecyclerView.Adapter<patientstores_adpater.viewholder>{
ArrayList<String>gg;
    public patientstores_adpater(ArrayList<String>kk)
    {
        gg=kk;

    }
    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item= LayoutInflater.from(parent.getContext()).inflate(R.layout.patientstores_cardview,parent,false);
        return new viewholder(item);
    }
    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        holder.Bl.setOnClickListener(v ->
        {
           con_mysql.downloadVideo(gg.get(position),v.getContext());
        });
        holder.Tvl.setText(String.valueOf(gg.get(position)));
    }




    @Override
    public int getItemCount() {
        return gg.size();
    }
    public class viewholder extends RecyclerView.ViewHolder{
        Button Bl;
        TextView Tvl;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            Bl=itemView.findViewById(R.id.Patient_stories_cardviewBT);
            Tvl=itemView.findViewById(R.id.Patient_stories_cardviewTV);
        }
    }
}
