package com.example.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class video_upload extends AppCompatActivity {
    Button btnSelectVideo, btnUploadVideo;
    TextView txtStatus;
    EditText E1;
    Uri videoUri;
    String videoName;

    ExecutorService executorService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_upload);
        btnSelectVideo = findViewById(R.id.btnSelectVideo);
        btnUploadVideo = findViewById(R.id.btnUploadVideo);
        txtStatus = findViewById(R.id.txtStatus);
        E1=findViewById(R.id.admin_name_file);

        executorService = Executors.newSingleThreadExecutor();

        // SELECT VIDEO
        btnSelectVideo.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
            intent.setType("video/*");
            startActivityForResult(intent, 101);
        });

        // UPLOAD VIDEO NAME
        btnUploadVideo.setOnClickListener(v -> {
            if (videoName == null || videoName.isEmpty()) {
                Toast.makeText(this, "Select a video first", Toast.LENGTH_SHORT).show();
                return;
            }

            executorService.execute(() -> {
                try {

                    // Initialize MySQL connection objects inside thread
                    con_mysql c1 = new con_mysql(); // your custom class
                    connectionclass c2 = new connectionclass();
                    Connection conn = c2.connect(); // get Connection
                    InputStream inputStream = getContentResolver().openInputStream(videoUri);
                    if (conn != null) {
                        // Insert video name (optional: video binary)
                        String sql = "INSERT INTO patientstores (Videos,VideosName) VALUES (?,?)";
                        PreparedStatement stmt = conn.prepareStatement(sql);
                        stmt.setBlob(1, inputStream);
                        stmt.setString(2,E1.getText().toString());
                        stmt.executeUpdate();
                        stmt.close();
                        conn.close();

                        runOnUiThread(() -> {
                            txtStatus.setText("");
                            Toast.makeText(this, "Video name uploaded", Toast.LENGTH_SHORT).show();
                        });
                    } else {
                        runOnUiThread(() -> Toast.makeText(this, "Connection failed", Toast.LENGTH_SHORT).show());
                    }


                } catch (Exception e) {
                    e.printStackTrace();
                    runOnUiThread(() -> txtStatus.setText("Error: " + e.getMessage()));
                }
            });
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 101 && resultCode == RESULT_OK && data != null) {
            videoUri = data.getData();
            videoName = getFileName(videoUri);
            txtStatus.setText("Selected: " + videoName);
        }
    }

    private String getFileName(Uri uri) {
        String result = null;
        if (uri.getScheme().equals("content")) {
            Cursor cursor = getContentResolver().query(uri, null, null, null, null);
            try {
                if (cursor != null && cursor.moveToFirst()) {
                    int idx = cursor.getColumnIndex(MediaStore.Video.Media.DISPLAY_NAME);
                    if (idx >= 0) result = cursor.getString(idx);
                }
            } finally {
                if (cursor != null) cursor.close();
            }
        }
        if (result == null) {
            result = uri.getLastPathSegment();
        }
        return result;
    }

}