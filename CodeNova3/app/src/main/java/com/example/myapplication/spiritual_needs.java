package com.example.myapplication;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class spiritual_needs extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spiritual_needs);

        Button B1=findViewById(R.id.btn_resources);
        Button B2=findViewById(R.id.btn_Devotionals);
        B1.setOnClickListener(this);
        B2.setOnClickListener(this);
    }
    public void onClick(View v) {
        if(v.getId()==R.id.btn_resources){
            startActivity(new Intent(this, resources.class));
        }else if(v.getId()==R.id.btn_Devotionals){
            startActivity(new Intent(this, devotionals.class));
        }}
}