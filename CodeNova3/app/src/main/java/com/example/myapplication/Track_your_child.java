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

public class Track_your_child extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track_your_child);
        Button B1=findViewById(R.id.btn_blood_pressure);
        B1.setOnClickListener(this);
        Button B2=findViewById(R.id.btn_pulse_ox);
        B2.setOnClickListener(this);
        Button B3=findViewById(R.id.btn_weight);
        B3.setOnClickListener(this);
        Button B4=findViewById(R.id.btn_feeding);
        B4.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btn_blood_pressure)
        {
            Intent a1 = new Intent(this, Track_your_child_BP.class);
            startActivity(a1);
        }
        else if(v.getId()==R.id.btn_pulse_ox)
        {
            Intent a1 = new Intent(this, Track_your_child_PO.class);
            startActivity(a1);
        } else if (v.getId()==R.id.btn_weight) {
            Intent a1 = new Intent(this, Track_your_child_wegit.class);
            startActivity(a1);
        }
         else if (v.getId()==R.id.btn_feeding) {
        Intent a1 = new Intent(this, Track_your_child_feeding.class);
        startActivity(a1);
         }
    }
}