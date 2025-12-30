package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.compose.material3.tokens.DialogTokens;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class personal_contacts extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_contacts);
        Button B1=findViewById(R.id.btn_Emargency);
        B1.setOnClickListener(this);
        Button B2=findViewById(R.id.btn_link_to_contacs);
        B2.setOnClickListener(this);

    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btn_Emargency)
        {
            Uri ui = Uri.parse("tel:911");
            Intent i = new Intent(Intent.ACTION_DIAL);
            i.setData(ui);
            v.getContext().startActivity(i);
        }
        else if(v.getId()==R.id.btn_link_to_contacs)
        {

            Intent intent = new Intent(Intent.ACTION_PICK);
            intent.setData(ContactsContract.Contacts.CONTENT_URI);
            startActivity(intent);
        }
    }
}