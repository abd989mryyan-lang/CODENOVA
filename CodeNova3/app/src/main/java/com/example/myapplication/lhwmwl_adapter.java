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

public class lhwmwl_adapter extends RecyclerView.Adapter<lhwmwl_adapter.viewholder> {
    ArrayList<String> A1=new ArrayList<>();
    ArrayList<String> A2=new ArrayList<>();
    public lhwmwl_adapter(ArrayList<String>st22,ArrayList<String>st33)
    {
A1=st22;
A2=st33;
    }
    @NonNull
    @Override

    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item= LayoutInflater.from(parent.getContext()).inflate(R.layout.lhwmwl_cardview,parent,false);
        return new viewholder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        final String n1= String.valueOf(A1.get(position));
        ArrayList<String> tvTextList = new ArrayList<>();
        holder.Bl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri ui=Uri.parse(n1);
                Intent i=new Intent(Intent.ACTION_VIEW,ui);
                v.getContext().startActivity(i);
            }
        });
        holder.Tvl.setText(String.valueOf(A2.get(position)));
    }

    @Override
    public int getItemCount() {
        return A1.size();
    }

    public class viewholder extends RecyclerView.ViewHolder
    {
        Button Bl;
        TextView Tvl;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            Bl=itemView.findViewById(R.id.lhwmwl_bt);
            Tvl=itemView.findViewById(R.id.lhwmwl_tv);
        }
    }
}
