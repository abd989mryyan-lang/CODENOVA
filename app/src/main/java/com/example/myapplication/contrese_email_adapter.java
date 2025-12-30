package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class contrese_email_adapter extends RecyclerView.Adapter<contrese_email_adapter.viewholder>{
    ArrayList<String> St=new ArrayList<>();
    ArrayList<String> St2=new ArrayList<>();
    public contrese_email_adapter(ArrayList<String>ss,ArrayList<String>ss2)
    {
    St=ss;
    St2=ss2;
    }
    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View V= LayoutInflater.from(parent.getContext()).inflate(R.layout.contres_email_cardview,parent,false);
        return new viewholder(V);
    }


    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        holder.Tv1.setText(String.valueOf(St2.get(position)));
        holder.Tv2.setText(String.valueOf(St.get(position)));
    }


    @Override
    public int getItemCount() {
        return St.size();
    }

    public class viewholder extends RecyclerView.ViewHolder{
        TextView Tv1;
        TextView Tv2;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            Tv1=itemView.findViewById(R.id.contres_email_tvN);
            Tv2=itemView.findViewById(R.id.contres_email_tvE);
        }
    }
}
