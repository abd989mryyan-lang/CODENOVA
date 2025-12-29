package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

public class support_groups extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support_groups);
        Button B1=findViewById(R.id.btn_Mended_Hearts);
        Button B2=findViewById(R.id.btn_Little_heart_warrior);
        B1.setOnClickListener(this);
        B2.setOnClickListener(this);
       // getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
          //  @Override
//public void handleOnBackPressed() {



             //   Intent intent =new Intent(support_groups.this, Little_heart_warrior.class);
             //   startActivity(intent);
        //    }
      //  });
    }
    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.btn_Mended_Hearts){
            Intent a=new Intent(this, mendedhearts_recycleview.class);
            startActivity(a);
        }
        else if(v.getId()==R.id.btn_Little_heart_warrior){
            Intent a=new Intent(support_groups.this, Little_heart_warrior.class);
           startActivity(a);
        }
    }


}