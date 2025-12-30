package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class contllue_adapter extends RecyclerView.Adapter<contllue_adapter.viewholder>{
    ArrayList<String> St=new ArrayList<>();
    ArrayList<String> St2=new ArrayList<>();

   public contllue_adapter(ArrayList<String>A1,ArrayList<String>A2){
       St=A1;
       St2=A2;

   }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View V= LayoutInflater.from(parent.getContext()).inflate(R.layout.contllue_cardview,parent,false);
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

    public class viewholder extends RecyclerView.ViewHolder
    {
TextView Tv1;
TextView Tv2;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            Tv1=itemView.findViewById(R.id.contllue_tv_email);
            Tv2=itemView.findViewById(R.id.contllue_tv_name);
        }
    }
}
