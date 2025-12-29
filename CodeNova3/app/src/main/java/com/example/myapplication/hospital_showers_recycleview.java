package com.example.myapplication;

import android.os.Bundle;
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

public class hospital_showers_recycleview extends AppCompatActivity {
    RecyclerView R1;
    hospital_showers_adpter a1;
    ArrayList<String> st=new ArrayList<>();
    ArrayList<String> s_2=new ArrayList<>();
    private volatile boolean isActive = true;
    ExecutorService executor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_showers_recycleview);
        R1=findViewById(R.id.hopital_show_RC);
        R1.setLayoutManager(new LinearLayoutManager(this));
        R1.setHasFixedSize(true);
        a1=new hospital_showers_adpter(st,s_2);
        R1.setAdapter(a1);
        executor = Executors.newSingleThreadExecutor();
        loadDataFromDatabase();
    }

    private void loadDataFromDatabase() {
        executor.execute(() -> {

            if (!isActive) return;

            connectionclass c1 = new connectionclass();
            con_mysql m1 = new con_mysql();
            Connection conn = c1.connect();

            if (!isActive) return;

            HashMap<String, HashMap<String,String>> dataMap = null;
            if (conn != null) {
                dataMap = m1.getAllData_for_hospita_info(c1);
            }

            HashMap<String, HashMap< String,String>> finalData = dataMap;

            runOnUiThread(() -> {

                // ✅ VERY IMPORTANT CHECK
                if (!isActive || isFinishing() || isDestroyed()) return;

                if (finalData != null
                        && !finalData.isEmpty()
                        && !finalData.containsKey("CONNECTION_ERROR")
                        && !finalData.containsKey("DATA_ERROR")) {

                    st.clear();
                    s_2.clear();

                    for (Map.Entry<String,HashMap<String,String>> entry : finalData.entrySet()) {
                        st.add(entry.getKey());
                        s_2.add(entry.getValue().get("hospital_name"));
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
    protected void onDestroy() {
        super.onDestroy();

        // 🔥 mark activity as dead
        isActive = false;

        if (executor != null && !executor.isShutdown()) {
            executor.shutdown();

        }

    }
}