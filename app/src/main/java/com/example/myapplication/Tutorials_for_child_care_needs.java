package com.example.myapplication;

import android.app.SearchManager;
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

public class Tutorials_for_child_care_needs extends AppCompatActivity implements View.OnClickListener {
Button B1;
Button B2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorials_for_child_care_needs);
B1=findViewById(R.id.btn_wound_care);
B1.setOnClickListener(this);
B2=findViewById(R.id.btn_drain_care);
B2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_wound_care) {
            Intent a1 = new Intent(this, wonund_care_recycleview.class);
            startActivity(a1);
        } else if (v.getId()==R.id.btn_drain_care) {

            Intent a1 = new Intent(this, drain_care_recycleview.class);
            startActivity(a1);
        }


    }}