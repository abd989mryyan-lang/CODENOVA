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

public class Track_your_child_PO extends AppCompatActivity {
    EditText eText;
    Button btnAdd, btnLoad, btnDelete;
    ListView listView;

    ArrayList<String> dataList;
    ArrayAdapter<String> adapter;

    String fileName = "strings.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track_your_child_po);
        eText = findViewById(R.id.eText);
        btnAdd = findViewById(R.id.btnAdd);
        btnLoad = findViewById(R.id.btnLoad);
        btnDelete = findViewById(R.id.btnDelete);
        listView = findViewById(R.id.listView);

        dataList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, dataList);
        listView.setAdapter(adapter);

        // ADD STRING TO FILE
        btnAdd.setOnClickListener(v -> {
            String text = eText.getText().toString().trim();

            if (text.isEmpty()) {
                Toast.makeText(this, "Enter text", Toast.LENGTH_SHORT).show();
                return;
            }

            try {
                FileOutputStream fos = openFileOutput(fileName, MODE_APPEND);
                fos.write((text + "\n").getBytes());
                fos.close();

                Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();
                eText.setText("");

            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        // LOAD DATA
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

        // DELETE FILE
        btnDelete.setOnClickListener(v -> {
            File file = new File(getFilesDir(), fileName);

            if (file.exists() && file.delete()) {
                dataList.clear();
                adapter.notifyDataSetChanged();
                Toast.makeText(this, "File deleted", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "File does not exist", Toast.LENGTH_SHORT).show();
            }
        });

    }
}