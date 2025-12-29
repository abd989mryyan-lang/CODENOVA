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

public class Help_page extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_page);
        Button B1=findViewById(R.id.btn_tot);
        B1.setOnClickListener(this);
        Button B2=findViewById(R.id.btn_toe);
        B2.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btn_toe)
        {
            Uri ui=Uri.parse("https://www.youtube.com/watch?v=EiG1__WSXIo");
            Intent i=new Intent(Intent.ACTION_VIEW,ui);
            v.getContext().startActivity(i);
        }
        else
        {
            Uri ui=Uri.parse("https://www.youtube.com/watch?v=cracmPo3iYo");
            Intent i=new Intent(Intent.ACTION_VIEW,ui);
            v.getContext().startActivity(i);
        }
    }
}