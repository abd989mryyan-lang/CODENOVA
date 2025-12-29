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

public class Track_your_child_wegit extends AppCompatActivity {
    EditText eNumber;
    Button btnAdd, btnLoad, btnDelete;
    ListView listView;

    ArrayList<String> dataList;
    ArrayAdapter<String> adapter;

    String fileName = "numbers_single.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track_your_child_wegit);
        eNumber = findViewById(R.id.eNumber);
        btnAdd = findViewById(R.id.btnAdd);
        btnLoad = findViewById(R.id.btnLoad);
        btnDelete = findViewById(R.id.btnDelete);
        listView = findViewById(R.id.listView);

        dataList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, dataList);
        listView.setAdapter(adapter);

        // ADD NUMBER
        btnAdd.setOnClickListener(v -> {
            String number = eNumber.getText().toString().trim();

            if (number.isEmpty()) {
                Toast.makeText(this, "Enter a number", Toast.LENGTH_SHORT).show();
                return;
            }

            try {
                FileOutputStream fos = openFileOutput(fileName, MODE_APPEND);
                fos.write(("weight = "+number + "\n").getBytes());
                fos.close();

                Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();
                eNumber.setText("");

            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        // LOAD NUMBERS
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