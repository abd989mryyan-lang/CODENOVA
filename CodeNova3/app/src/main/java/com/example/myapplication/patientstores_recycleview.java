package com.example.myapplication;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class patientstores_recycleview extends AppCompatActivity {
    RecyclerView R1;
    private volatile boolean isActive = true;
 patientstores_adpater a1;

    ArrayList<String> st = new ArrayList<>();
    ArrayList<String> s_2 = new ArrayList<>();
    ArrayList<String> s_3 = new ArrayList<>();

    ExecutorService executor;

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 100) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Permission granted", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Permission denied", Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_patientstores_recycleview);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    != android.content.pm.PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);
            }
        }
        R1=findViewById(R.id.Patient_stories_cardviewRc);
        R1.setLayoutManager(new LinearLayoutManager(this));
        R1.setHasFixedSize(true);
        a1=new patientstores_adpater(st);
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

           List<String> dataMap = null;
            if (conn != null) {
                dataMap = m1.getAllVideoNames(c1);
            }

           List<String> finalData = dataMap;

            runOnUiThread(() -> {

                // ✅ VERY IMPORTANT CHECK
                if (!isActive || isFinishing() || isDestroyed()) return;

                if (finalData != null
                        && !finalData.isEmpty()) {

                    st.clear();
                    s_2.clear();
                    st.clear();
                   // Add all video names to your adapter's list
                    st.addAll(finalData);
                    // If you have a secondary list (s_2), fill it as needed, or leave empty
                    s_2.clear();
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

  

    
