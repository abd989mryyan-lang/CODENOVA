package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class signin_activity extends AppCompatActivity implements View.OnClickListener {
Button B1;
EditText E1;
EditText E2;
ExecutorService executorService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signin);
        TextView T=findViewById(R.id.signup);
        T.setOnClickListener(this);
        B1=findViewById(R.id.btnLogin1);
        B1.setOnClickListener(this);
        E1=findViewById(R.id.Username);
        E2=findViewById(R.id.Password);



    }
    private void connect_to_MainActivity(){
        String St=E1.getText().toString();
        String St2=E2.getText().toString();
        if(St.isEmpty()&&St2.isEmpty())
        {
            Toast.makeText(this,"Empty Username or Password",Toast.LENGTH_SHORT).show();
        }
        else {

        executorService = Executors.newSingleThreadExecutor();
        executorService.execute(() -> {

            con_mysql c1=new con_mysql();
            connectionclass c2=new connectionclass();

        HashMap<String,String> M1;
        M1=c1.getUserData(E1.getText().toString(),E2.getText().toString(),c2);
            runOnUiThread(()->{

                String v=M1.get("UserNameF");
            if (!M1.containsKey("error")){
                if(M1.size()>1){
                if("admin".equals(v))
                {
                    Intent I=new Intent(this, Admin_Activity.class);
                    I.putExtra("data1",M1);
                    startActivity(I);
                    finish();

                }
                else
                {
                  Intent I=new Intent(this, MainActivity.class);
                   //  Toast.makeText(this,"Welcome Back",Toast.LENGTH_SHORT).show();
                   I.putExtra("data",M1);
                   startActivity(I);
                   finish();
                }
                }
        }else {
            Toast.makeText(this,"Wrong Username or Password",Toast.LENGTH_SHORT).show();
        }
        });
        });
        executorService.shutdown();
        }
    }


    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.signup){
        startActivity(new Intent(this, signup.class));
    }
        else if(v.getId()==R.id.btnLogin1){
     connect_to_MainActivity();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if ( executorService != null && ! executorService.isShutdown()) {
            executorService.shutdownNow();
        }
    }
}