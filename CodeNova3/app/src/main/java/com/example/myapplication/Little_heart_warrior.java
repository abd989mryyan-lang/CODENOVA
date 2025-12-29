package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Little_heart_warrior extends AppCompatActivity implements View.OnClickListener
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_little_heart_warrior);
        Button B1=findViewById(R.id.btn_Meetting_information);
        B1.setOnClickListener(this);
        Button B2=findViewById(R.id.btn_Feacbook_link);
        B2.setOnClickListener(this);
        Button B3=findViewById(R.id.btn_website_link);
        B3.setOnClickListener(this);

    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {

        if (v.getId()==R.id.btn_Feacbook_link){
            Intent intent=new Intent(this, lhwfb_recycle_view.class);
            startActivity(intent);
        }
        else if (v.getId()==R.id.btn_website_link){
            Intent intent=new Intent(Little_heart_warrior.this,user_recycle_view.class);
            startActivity(intent);
        }
        else if(v.getId()==R.id.btn_Meetting_information)
        {
            Intent intent=new Intent(Little_heart_warrior.this, lhwmi_recycle_view.class);
            startActivity(intent);
        }
    }
}