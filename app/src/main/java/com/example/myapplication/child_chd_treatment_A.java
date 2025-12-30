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

public class child_chd_treatment_A extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_chd_treatment);
        Button B1=findViewById(R.id.btn_medications);
        Button B2=findViewById(R.id.btn_reliable_websites);

        Button B4=findViewById(R.id.btn_Videos_defects);
        B1.setOnClickListener(this);
        B2.setOnClickListener(this);

        B4.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btn_medications){
            Intent a1 = new Intent(this, med_treat.class);
            startActivity(a1);
        }
        else if(v.getId()==R.id.btn_reliable_websites){startActivity(new Intent(this, Chd_treatment.class));}

        else if(v.getId()==R.id.btn_Videos_defects){
            startActivity(new Intent(this, videos_of_defects_recycleview.class));
        }
    }
}