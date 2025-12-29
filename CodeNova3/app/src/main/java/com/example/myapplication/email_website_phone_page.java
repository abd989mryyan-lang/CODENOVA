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

public class email_website_phone_page extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_email_website_phone_page);
        Button B1=findViewById(R.id.btn_phone_number1);
        B1.setOnClickListener(this);
        Button B2=findViewById(R.id.btn_email_link1);
        B2.setOnClickListener(this);
        Button B3=findViewById(R.id.btn_website_link1);
        B3.setOnClickListener(this);
}

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btn_phone_number1){
            Intent a1 = new Intent(this, contrese_phone_recycleview.class);
            startActivity(a1);
        }
        else if(v.getId()==R.id.btn_email_link1)
        {
            Intent a1 = new Intent(this, contres_email_recycleview.class);
            startActivity(a1);
        }
        else if (v.getId()==R.id.btn_website_link1) {
            Intent a1 = new Intent(this, user_recycle_view.class);
            startActivity(a1);
        }
    }
}