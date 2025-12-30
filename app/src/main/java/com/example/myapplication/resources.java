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

public class resources extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resources);
        Button B1=findViewById(R.id.btn_outside_readings);
        B1.setOnClickListener(this);
        Button B2=findViewById(R.id.btn_chaplain_website);
        B2.setOnClickListener(this);
        Button B3=findViewById(R.id.btn_res_email);
        B3.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btn_outside_readings)
        {
            Uri ui=Uri.parse("https://www.techscience.com/journal/chd?utm_source=chatgpt.com");
            Intent i=new Intent(Intent.ACTION_VIEW,ui);
            v.getContext().startActivity(i);
        }
        else if(v.getId()==R.id.btn_chaplain_website)
        {
            Uri ui=Uri.parse("https://atriumhealth.org/medical-services/childrens-services/childrens-specialty-care/pediatric-cardiology-and-heart-surgery/congenital-heart-defects");
            Intent i=new Intent(Intent.ACTION_VIEW,ui);
            v.getContext().startActivity(i);
        }
        else if(v.getId()==R.id.btn_res_email)
        {
            startActivity(new Intent(this, email_copy_recycleview.class));
        }
    }
}