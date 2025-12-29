package com.example.myapplication;

import static androidx.core.content.ContextCompat.startActivities;
import static androidx.core.content.ContextCompat.startActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
// Inside your MainActivity.java or a similar class

import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;


public class user_list_adapter  extends RecyclerView.Adapter<user_list_adapter.viewholder>{
    ArrayList<Button> B1_list=new ArrayList<>();
    ArrayList<TextView> Tv_list=new ArrayList<>();
    ArrayList<String> St=new ArrayList<>();
    ArrayList<String> St2=new ArrayList<>();


    public user_list_adapter(ArrayList<String> St2,ArrayList<String>St1){

        this.St2=St2;
        St=St1;


    }





    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v1= LayoutInflater.from(parent.getContext()).inflate(R.layout.user_item,parent,false);
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
        return St2.size();
    }

    public static class viewholder extends RecyclerView.ViewHolder{
        TextView Tv;
        Button B1;

        public viewholder(@NonNull View itemView) {
            super(itemView);
            Tv=itemView.findViewById(R.id.tv_user_textview);
            B1=itemView.findViewById(R.id.btn_user_item);


        }


    }




}
