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

public class hewn_adpater extends RecyclerView.Adapter<hewn_adpater.viewholder>{
    ArrayList<String> St=new ArrayList<>();
    ArrayList<String> St2=new ArrayList<>();
    ArrayList<String>St3=new ArrayList<>();
    public hewn_adpater(ArrayList<String>S1,ArrayList<String> S2,ArrayList<String> S3)
    {
        St=S1;
        St2=S2;
        St3=S3;
    }
    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View V= LayoutInflater.from(parent.getContext()).inflate(R.layout.hewn_cardview,parent,false);
        return new viewholder(V);
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

        holder.TV1.setText(String.valueOf(St2.get(position)));
        holder.Tv2.setText(String.valueOf(St3.get(position)));
    }

    @Override
    public int getItemCount() {
        return St.size();
    }

    public class viewholder extends RecyclerView.ViewHolder{
        Button B1;
        TextView TV1;
        TextView Tv2;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            B1=itemView.findViewById(R.id.hewn_BT);
            TV1=itemView.findViewById(R.id.hewn_TV1);
            Tv2=itemView.findViewById(R.id.hewn_TV2);
        }
    }
}
