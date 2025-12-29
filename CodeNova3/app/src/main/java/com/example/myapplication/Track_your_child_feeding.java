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

public class Track_your_child_feeding extends AppCompatActivity {

    EditText inputStringAlt;
    Button btnSaveAlt, btnReadAlt, btnRemoveAlt;
    ListView listTextAlt;

    ArrayList<String> textItems;
    ArrayAdapter<String> textAdapter;

    String fileName = "strings_alt.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track_your_child_feeding);
        inputStringAlt = findViewById(R.id.inputStringAlt);
        btnSaveAlt = findViewById(R.id.btnSaveAlt);
        btnReadAlt = findViewById(R.id.btnReadAlt);
        btnRemoveAlt = findViewById(R.id.btnRemoveAlt);
        listTextAlt = findViewById(R.id.listTextAlt);

        textItems = new ArrayList<>();
        textAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, textItems);
        listTextAlt.setAdapter(textAdapter);

        // SAVE TEXT
        btnSaveAlt.setOnClickListener(v -> {
            String value = inputStringAlt.getText().toString().trim();

            if (value.isEmpty()) {
                Toast.makeText(this, "Please enter text", Toast.LENGTH_SHORT).show();
                return;
            }

            try {
                FileOutputStream fos = openFileOutput(fileName, MODE_APPEND);
                fos.write((value + "\n").getBytes());
                fos.close();

                Toast.makeText(this, "Text saved", Toast.LENGTH_SHORT).show();
                inputStringAlt.setText("");

            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        // LOAD TEXT
        btnReadAlt.setOnClickListener(v -> {
            textItems.clear();

            try {
                FileInputStream fis = openFileInput(fileName);
                BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
                String line;

                while ((line = reader.readLine()) != null) {
                    textItems.add(line);
                }

                reader.close();
                textAdapter.notifyDataSetChanged();

            } catch (FileNotFoundException e) {
                Toast.makeText(this, "File not found", Toast.LENGTH_SHORT).show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        // DELETE FILE
        btnRemoveAlt.setOnClickListener(v -> {
            File file = new File(getFilesDir(), fileName);

            if (file.exists() && file.delete()) {
                textItems.clear();
                textAdapter.notifyDataSetChanged();
                Toast.makeText(this, "File deleted", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "No file to delete", Toast.LENGTH_SHORT).show();
            }
        });
    }
}