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

public class Contacts_activity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        Button B1=findViewById(R.id.btn_phone_number_emails);
        B1.setOnClickListener(this);
Button B2=findViewById(R.id.btn_local_res);
B2.setOnClickListener(this);
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btn_phone_number_emails)
        {
               Intent a1 = new Intent(this, contllu_email_user.class);
                startActivity(a1);
        }
        else {
            Intent a1 = new Intent(this, email_website_phone_page.class);
            startActivity(a1);
        }
    }
}