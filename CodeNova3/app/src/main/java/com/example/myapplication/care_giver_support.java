package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class care_giver_support extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_care_giver_support);
        Button B1=findViewById(R.id.btn_Patient_stories);
        Button B2=findViewById(R.id.btn_support_groups1);
        Button B3=findViewById(R.id.btn_contacts);
        Button B4=findViewById(R.id.btn_Personal_contacts);
        B1.setOnClickListener(this);
        B2.setOnClickListener(this);
        B3.setOnClickListener(this);
        B4.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.btn_Patient_stories){
            Intent a=new Intent(this, PatientStoriesActivity.class);
            startActivity(a);

        }else if (v.getId()==R.id.btn_support_groups1){
           Intent a=new Intent(this, support_groups.class);
            startActivity(a);
        }
        else if (v.getId()==R.id.btn_contacts){
            Intent a=new Intent(this, Contacts_activity.class);
            startActivity(a);
        }
        else if (v.getId()==R.id.btn_Personal_contacts){
            Intent a=new Intent(this, personal_contacts.class);
            startActivity(a);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}