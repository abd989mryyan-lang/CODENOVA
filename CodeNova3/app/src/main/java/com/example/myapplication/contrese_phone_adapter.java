package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class contrese_phone_adapter extends RecyclerView.Adapter<contrese_phone_adapter.viewholder>{
    ArrayList<String> st;
    ArrayList<String>st2;
    public contrese_phone_adapter(ArrayList<String>st22, ArrayList<String>st333)
    {
        st=st22;
        st2=st333;
    }
    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View V= LayoutInflater.from(parent.getContext()).inflate(R.layout.contllu_phone_card_view,parent,false);
        return new viewholder(V);
    }


    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        final String n1= String.valueOf(st.get(position));

        holder.B1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri ui=Uri.parse(n1);
                Intent i=new Intent(Intent.ACTION_DIAL,ui);
                i.setData(Uri.parse("tel:" + st.get(position)));
                v.getContext().startActivity(i);
            }
        });
        holder.Tv.setText(String.valueOf(st2.get(position)));
    }


    @Override
    public int getItemCount() {
        return st.size();
    }

    public class viewholder extends RecyclerView.ViewHolder
    {
        TextView Tv;
        Button B1;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            Tv=itemView.findViewById(R.id.contllu_phone_tv);
            B1=itemView.findViewById(R.id.contllu_phone_bt);
        }
    }
}
