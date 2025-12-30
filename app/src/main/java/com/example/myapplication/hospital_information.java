package com.example.myapplication;

import android.content.ContentUris;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;

public class hospital_information extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_information);
        Button B1=findViewById(R.id.btn_area_map);
        B1.setOnClickListener(this);
        Button B2=findViewById(R.id.btn_Hospital_showers);
        B2.setOnClickListener(this);
        Button B3=findViewById(R.id.btn_hospital_email);
        B3.setOnClickListener(this);
        Button B4=findViewById(R.id.btn_link_to_calendar);
        B4.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btn_area_map)
        {
            String hospitalName = "Mount Sinai Hospital, New York";
            Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + Uri.encode(hospitalName));
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
        }
        else if(v.getId()==R.id.btn_link_to_calendar)
        {

            Calendar cal = Calendar.getInstance();
            Uri.Builder builder = CalendarContract.CONTENT_URI.buildUpon();
            builder.appendPath("time");
            ContentUris.appendId(builder, cal.getTimeInMillis());
            Uri uri = builder.build();
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(uri);
            startActivity(intent);


        } else if(v.getId()==R.id.btn_Hospital_showers)
        {
            Intent a1 = new Intent(this, hospital_showers_recycleview.class);
            startActivity(a1);
        }
        else if(v.getId()==R.id.btn_hospital_email)
        {
            Intent a1 = new Intent(this, hewn_recycleview.class);
            startActivity(a1);
        }
        }


    }
