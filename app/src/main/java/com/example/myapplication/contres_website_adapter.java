package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class contres_website_adapter extends RecyclerView.Adapter<contres_website_adapter.viewholder>{
    ArrayList<String> St=new ArrayList<>();
    ArrayList<String> St2=new ArrayList<>();
    public contres_website_adapter(ArrayList<String>sgg,ArrayList<String>sgggg)
    {
        St=sgggg;
        St2=sgg;

    }
    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v1= LayoutInflater.from(parent.getContext()).inflate(R.layout.contres_website_cardview,parent,false);
        return new viewholder(v1);
    }


    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        final String n1= String.valueOf(St.get(position));
        ArrayList<String> tvTextList = new ArrayList<>();
        holder.B1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri ui=Uri.parse(n1);
                Intent i=new Intent(Intent.ACTION_VIEW,ui);
                v.getContext().startActivity(i);
            }
        });

        holder.Tv.setText(String.valueOf(St2.get(position)));
    }


    @Override
    public int getItemCount() {
        return St.size();
    }

    public class viewholder extends RecyclerView.ViewHolder
    {
        TextView Tv;
        Button B1;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            Tv=itemView.findViewById(R.id.contres_website_Tv);
            B1=itemView.findViewById(R.id.contres_website_Bt);
        }
    }
}
