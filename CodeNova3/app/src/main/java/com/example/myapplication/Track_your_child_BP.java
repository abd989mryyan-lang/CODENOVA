package com.example.myapplication;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Track_your_child_BP extends AppCompatActivity {
    EditText e1, e2;
    Button btnAdd, btnLoad,btnDelete;
    ListView listView;
    ArrayAdapter<String> adapter;
    ArrayList<String> dataList;

    String fileName = "numbers.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track_your_child_bp);


        e1 = findViewById(R.id.e1);
        e2 = findViewById(R.id.e2);
        btnAdd = findViewById(R.id.btnAdd);
        btnLoad = findViewById(R.id.btnLoad);
        btnDelete = findViewById(R.id.btnDelete);
        listView = findViewById(R.id.listView);

        dataList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, dataList);
        listView.setAdapter(adapter);

        // ADD DATA TO FILE (APPEND)
        btnAdd.setOnClickListener(v -> {
            String n1 = e1.getText().toString();
            String n2 = e2.getText().toString();

            if (n1.isEmpty() || n2.isEmpty()) {
                Toast.makeText(this, "Enter both numbers", Toast.LENGTH_SHORT).show();
                return;
            }

            String line = "blood pressure "+n1 + " / " + n2 + "\n";

            try {
                FileOutputStream fos = openFileOutput(fileName, MODE_APPEND);
                fos.write(line.getBytes());
                fos.close();

                Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();
                e1.setText("");
                e2.setText("");

            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        // LOAD DATA FROM FILE
        btnLoad.setOnClickListener(v -> {
            dataList.clear();

            try {
                FileInputStream fis = openFileInput(fileName);
                BufferedReader br = new BufferedReader(new InputStreamReader(fis));
                String line;

                while ((line = br.readLine()) != null) {
                    dataList.add(line);
                }

                br.close();
                adapter.notifyDataSetChanged();

            } catch (FileNotFoundException e) {
                Toast.makeText(this, "File not found", Toast.LENGTH_SHORT).show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        btnDelete.setOnClickListener(v -> {

            File file = new File(getFilesDir(), fileName);

            if (file.exists()) {
                boolean deleted = file.delete();

                if (deleted) {
                    dataList.clear();
                    adapter.notifyDataSetChanged();
                    Toast.makeText(this, "File deleted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Failed to delete file", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "File does not exist", Toast.LENGTH_SHORT).show();
            }
        });
    }

    }
