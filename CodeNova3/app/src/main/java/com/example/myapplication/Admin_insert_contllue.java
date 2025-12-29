package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Admin_insert_contllue extends AppCompatActivity implements View.OnClickListener {
    RecyclerView R1;
    private volatile boolean isActive = true;
    contllue_adapter a1;
    ArrayList<String> st = new ArrayList<>();
    ArrayList<String> s_2 = new ArrayList<>();
    con_mysql M1;
    EditText E1,E2;
    ExecutorService executor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_insert_contllue);
        R1 = findViewById(R.id.contllue_admin_RC);
        R1.setLayoutManager(new LinearLayoutManager(this));
        R1.setHasFixedSize(true);
        a1 = new contllue_adapter(s_2,st);
        R1.setAdapter(a1);
        // ✅ Create executor ONCE
        executor = Executors.newSingleThreadExecutor();
        Button B1=findViewById(R.id.btn_admin_contllue);
        B1.setOnClickListener(this);
        E1=findViewById(R.id.admin_edittext1_contllue);
        E2=findViewById(R.id.admin_edittext2_contllue);
        loadDataFromDatabase();


    }

    private void loadDataFromDatabase() {
        executor.execute(() -> {

            if (!isActive) return;

            connectionclass c1 = new connectionclass();
            con_mysql m1 = new con_mysql();
            Connection conn = c1.connect();

            if (!isActive) return;

            HashMap<String, HashMap<String, String>> dataMap = null;
            if (conn != null) {
                dataMap = m1.getalldata_for_contllue(c1);
            }

            HashMap<String, HashMap<String, String>> finalData = dataMap;

            runOnUiThread(() -> {

                // ✅ VERY IMPORTANT CHECK
                if (!isActive || isFinishing() || isDestroyed()) return;

                if (finalData != null
                        && !finalData.isEmpty()
                        && !finalData.containsKey("CONNECTION_ERROR")
                        && !finalData.containsKey("DATA_ERROR")) {

                    st.clear();
                    s_2.clear();

                    for (Map.Entry<String, HashMap<String, String>> entry : finalData.entrySet()) {
                        st.add(entry.getKey());
                        s_2.add(entry.getValue().get("email"));
                    }

                    a1.notifyDataSetChanged();

                } else {
                    Toast.makeText(this,
                            "Error or no links found!",
                            Toast.LENGTH_LONG).show();
                }
            });
        });
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_admin_contllue) {
            // Read UI data first
            String Name1 = E2.getText().toString();
            String Link1=E1.getText().toString();


            ExecutorService executorService = Executors.newSingleThreadExecutor();
            executorService.execute(() -> {
                // Initialize objects inside the thread
                con_mysql c1 = new con_mysql();
                connectionclass c2 = new connectionclass();

                // Call the method on the initialized object
                boolean s = c1.check_data_for2(Name1, "contllue", "emailName", c2);
                boolean s2=c1.check_data_for2(Link1, "contllue", "email", c2);
                // Update UI safely
                runOnUiThread(() -> {
                    Toast.makeText(Admin_insert_contllue.this, String.valueOf(s)+String.valueOf(s2), Toast.LENGTH_SHORT).show();
                });
            });
        }
    }


}