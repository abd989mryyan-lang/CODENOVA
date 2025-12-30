package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.security.KeyStore;
import java.util.HashMap;

public class MainActivity extends Activity implements View.OnClickListener {



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);
Intent I=getIntent();

        HashMap<String, String> M1 = (HashMap<String, String>) I.getSerializableExtra("data");
       connectionclass c1=I.getParcelableExtra("con");
        String firstValue = M1.values().iterator().next().toString();
        //String s2= String.valueOf(M1.size());
       Toast.makeText(this,firstValue,Toast.LENGTH_SHORT).show();
        Button B1 = findViewById(R.id.btn_Help);
        Button B2 = findViewById(R.id.btn_care_giver_support);
        Button B3 = findViewById(R.id.btn_chd_treatment);
        Button B4 = findViewById(R.id.btn_spiritual_needs);
        Button B5 = findViewById(R.id.btn_hospital_information);
        Button B6 = findViewById(R.id.btn_treck_your_child);
        Button B7 = findViewById(R.id.btn_tutorials_for_child);


        B1.setOnClickListener(this);
        B2.setOnClickListener(this);
        B3.setOnClickListener(this);
        B4.setOnClickListener(this);
        B5.setOnClickListener(this);
        B6.setOnClickListener(this);
        B7.setOnClickListener(this);

    }

    @Override
    public void onClick(View V) {

if (V.getId()==R.id.btn_Help){   Intent a1 = new Intent(this, Help_page.class);
    startActivity(a1);}
else if(V.getId()==R.id.btn_care_giver_support){   Intent a1 = new Intent(this, care_giver_support.class);
    startActivity(a1);}
else if(V.getId()==R.id.btn_spiritual_needs){   Intent a1 = new Intent(this, resources.class);
    startActivity(a1);}
else if(V.getId()==R.id.btn_chd_treatment){   Intent a1 = new Intent(this, child_chd_treatment_A.class);
    startActivity(a1);}
else if(V.getId()==R.id.btn_tutorials_for_child){   Intent a1 = new Intent(this, Tutorials_for_child_care_needs.class);
    startActivity(a1);}
else if(V.getId()==R.id.btn_hospital_information){   Intent a1 = new Intent(this, hospital_information.class);
    startActivity(a1);}
else if(V.getId()==R.id.btn_treck_your_child){   Intent a1 = new Intent(this, Track_your_child.class);
    startActivity(a1);}

}}
