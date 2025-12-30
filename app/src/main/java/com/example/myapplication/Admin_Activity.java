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

public class Admin_Activity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        Button B1=findViewById(R.id.Admin_ADD_Two_Bt);
        B1.setOnClickListener(this);
        Button B2=findViewById(R.id.Admin_Videos_Bt);
        B2.setOnClickListener(this);
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.Admin_ADD_Two_Bt)
        {
            Intent a1 = new Intent(this, Admin_main_please_work.class);
            startActivity(a1);
        }else   if(v.getId()==R.id.Admin_Videos_Bt)
        {
            Intent a1 = new Intent(this, video_upload.class);
            startActivity(a1);
        }
    }
}