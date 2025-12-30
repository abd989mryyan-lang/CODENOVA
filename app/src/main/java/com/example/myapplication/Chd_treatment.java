package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Chd_treatment extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chd_treatment);
        Button B1=findViewById(R.id.btn_CDC);
        B1.setOnClickListener(this);
        Button B2=findViewById(R.id.btn_AHA);
        B2.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btn_CDC)
        {
            Uri ui=Uri.parse("https://www.cdc.gov/heart-defects/index.html");
            Intent i=new Intent(Intent.ACTION_VIEW,ui);
            v.getContext().startActivity(i);
        }
        else
        {
            Uri ui=Uri.parse("https://www.heart.org/en/health-topics/congenital-heart-defects");
            Intent i=new Intent(Intent.ACTION_VIEW,ui);
            v.getContext().startActivity(i);
        }
    }
}