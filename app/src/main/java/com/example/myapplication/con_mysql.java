package com.example.myapplication;

import android.util.Log;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.compose.material3.TabPosition;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class con_mysql {
    connectionclass connectionclass;
    Connection con;
    ResultSet rs;
    private boolean af;

    public HashMap<String,HashMap<String,String>>getAllData_for_mendedheart(connectionclass c1)
    {
        // The return structure: Key is the Link (unique), Value is the row's data
        HashMap<String, HashMap<String, String>> allDataMap = new HashMap<>();
        Connection con1 = null;

        try {
            con1 = c1.connect();

            if (con1 == null) {
                // Add error flag if connection fails
                HashMap<String, String> errorDetail = new HashMap<>();
                errorDetail.put("error", "Error connecting to MySQL server");
                allDataMap.put("CONNECTION_ERROR", errorDetail);
                return allDataMap;
            }

            String query = "SELECT contweblink, contwebname FROM mendedhearts";
            Statement stmt = con1.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                // 1. Get the unique key for the row (e.g., the URL link)
                String uniqueLink = rs.getString("contweblink");

                // 2. Create a NEW HashMap for the row's details
                HashMap<String, String> rowDetails = new HashMap<>();

                // Populate the inner map with the row's details
                // You can add more columns here if your query selects them
                rowDetails.put("contwebname", rs.getString("contwebname"));

                // 3. Add the row to the main return map, using the link as the key
                allDataMap.put(uniqueLink, rowDetails);
            }

            con1.close();

            // Check if data was found only if no connection error occurred
            if (allDataMap.isEmpty()) {
                HashMap<String, String> errorDetail = new HashMap<>();
                errorDetail.put("error", "No data found");
                allDataMap.put("DATA_ERROR", errorDetail);
            }

        } catch (Exception e) {
            // Handle database exceptions
            HashMap<String, String> errorDetail = new HashMap<>();
            errorDetail.put("error", "Exception: " + e.getMessage());
            allDataMap.put("EXCEPTION", errorDetail);
        }

        return allDataMap;
    }
    public HashMap<String,HashMap<String,String>>getAllData_for_emailcopy(connectionclass c1)
    {
        // The return structure: Key is the Link (unique), Value is the row's data
        HashMap<String, HashMap<String, String>> allDataMap = new HashMap<>();
        Connection con1 = null;

        try {
            con1 = c1.connect();

            if (con1 == null) {
                // Add error flag if connection fails
                HashMap<String, String> errorDetail = new HashMap<>();
                errorDetail.put("error", "Error connecting to MySQL server");
                allDataMap.put("CONNECTION_ERROR", errorDetail);
                return allDataMap;
            }

            String query = "SELECT email, email_name FROM email_copy";
            Statement stmt = con1.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                // 1. Get the unique key for the row (e.g., the URL link)
                String uniqueLink = rs.getString("email");

                // 2. Create a NEW HashMap for the row's details
                HashMap<String, String> rowDetails = new HashMap<>();

                // Populate the inner map with the row's details
                // You can add more columns here if your query selects them
                rowDetails.put("email_name", rs.getString("email_name"));

                // 3. Add the row to the main return map, using the link as the key
                allDataMap.put(uniqueLink, rowDetails);
            }

            con1.close();

            // Check if data was found only if no connection error occurred
            if (allDataMap.isEmpty()) {
                HashMap<String, String> errorDetail = new HashMap<>();
                errorDetail.put("error", "No data found");
                allDataMap.put("DATA_ERROR", errorDetail);
            }

        } catch (Exception e) {
            // Handle database exceptions
            HashMap<String, String> errorDetail = new HashMap<>();
            errorDetail.put("error", "Exception: " + e.getMessage());
            allDataMap.put("EXCEPTION", errorDetail);
        }

        return allDataMap;
    }
    public HashMap<String,HashMap<String,String>>getAllData_for_hospita_info(connectionclass c1)
    {
        // The return structure: Key is the Link (unique), Value is the row's data
        HashMap<String, HashMap<String, String>> allDataMap = new HashMap<>();
        Connection con1 = null;

        try {
            con1 = c1.connect();

            if (con1 == null) {
                // Add error flag if connection fails
                HashMap<String, String> errorDetail = new HashMap<>();
                errorDetail.put("error", "Error connecting to MySQL server");
                allDataMap.put("CONNECTION_ERROR", errorDetail);
                return allDataMap;
            }

            String query = "SELECT hospital_loc, hospital_name FROM hospital_showers";
            Statement stmt = con1.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                // 1. Get the unique key for the row (e.g., the URL link)
                String uniqueLink = rs.getString("hospital_loc");

                // 2. Create a NEW HashMap for the row's details
                HashMap<String, String> rowDetails = new HashMap<>();

                // Populate the inner map with the row's details
                // You can add more columns here if your query selects them
                rowDetails.put("hospital_name", rs.getString("hospital_name"));

                // 3. Add the row to the main return map, using the link as the key
                allDataMap.put(uniqueLink, rowDetails);
            }

            con1.close();

            // Check if data was found only if no connection error occurred
            if (allDataMap.isEmpty()) {
                HashMap<String, String> errorDetail = new HashMap<>();
                errorDetail.put("error", "No data found");
                allDataMap.put("DATA_ERROR", errorDetail);
            }

        } catch (Exception e) {
            // Handle database exceptions
            HashMap<String, String> errorDetail = new HashMap<>();
            errorDetail.put("error", "Exception: " + e.getMessage());
            allDataMap.put("EXCEPTION", errorDetail);
        }

        return allDataMap;
    }
    public HashMap<String,HashMap<String,String>>getAllData_for_vid_of_def(connectionclass c1)
    {
        // The return structure: Key is the Link (unique), Value is the row's data
        HashMap<String, HashMap<String, String>> allDataMap = new HashMap<>();
        Connection con1 = null;

        try {
            con1 = c1.connect();

            if (con1 == null) {
                // Add error flag if connection fails
                HashMap<String, String> errorDetail = new HashMap<>();
                errorDetail.put("error", "Error connecting to MySQL server");
                allDataMap.put("CONNECTION_ERROR", errorDetail);
                return allDataMap;
            }

            String query = "SELECT VD_link, VD_name FROM videos_of_defects";
            Statement stmt = con1.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                // 1. Get the unique key for the row (e.g., the URL link)
                String uniqueLink = rs.getString("VD_link");

                // 2. Create a NEW HashMap for the row's details
                HashMap<String, String> rowDetails = new HashMap<>();

                // Populate the inner map with the row's details
                // You can add more columns here if your query selects them
                rowDetails.put("VD_name", rs.getString("VD_name"));

                // 3. Add the row to the main return map, using the link as the key
                allDataMap.put(uniqueLink, rowDetails);
            }

            con1.close();

            // Check if data was found only if no connection error occurred
            if (allDataMap.isEmpty()) {
                HashMap<String, String> errorDetail = new HashMap<>();
                errorDetail.put("error", "No data found");
                allDataMap.put("DATA_ERROR", errorDetail);
            }

        } catch (Exception e) {
            // Handle database exceptions
            HashMap<String, String> errorDetail = new HashMap<>();
            errorDetail.put("error", "Exception: " + e.getMessage());
            allDataMap.put("EXCEPTION", errorDetail);
        }

        return allDataMap;
    }
    public HashMap<String,HashMap<String,String>>getAllData_for_hewn(connectionclass c1)
    {

        HashMap<String,HashMap<String,String>>alldatamap =new HashMap<>();
        Connection con1=null;
        try{
            con1=c1.connect();
            if(con1==null){
                HashMap<String, String> errorDetail = new HashMap<>();
                errorDetail.put("error", "Error connecting to MySQL server");
                alldatamap.put("CONNECTION_ERROR", errorDetail);
                return alldatamap;
            }
            String query = "SELECT Web_hospital, Name_hospital,email_Name FROM hewn";
            Statement stmt = con1.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String uniqueKey = rs.getString("Name_hospital");

                HashMap<String, String> rowDetails = new HashMap<>();

                // ✅ Put the correct data into the correct keys
                rowDetails.put("Name_hospital", rs.getString("Name_hospital"));
                rowDetails.put("Web_hospital", rs.getString("Web_hospital")); // You need the URL!
                rowDetails.put("email_Name", rs.getString("email_Name"));

                alldatamap.put(uniqueKey, rowDetails);
            }
            con1.close();
            if (alldatamap.isEmpty()) {
                HashMap<String, String> errorDetail = new HashMap<>();
                errorDetail.put("error", "No data found");
                alldatamap.put("DATA_ERROR", errorDetail);
            }
        }catch (Exception e){
            HashMap<String, String> errorDetail = new HashMap<>();
            errorDetail.put("error", "Exception: " + e.getMessage());
            alldatamap.put("EXCEPTION", errorDetail);
        }
        return alldatamap;
    }
    public HashMap<String,HashMap<String,String>>getAllData_for_darincare(connectionclass c1)
    {

        // The return structure: Key is the Link (unique), Value is the row's data
        HashMap<String, HashMap<String, String>> allDataMap = new HashMap<>();
        Connection con1 = null;

        try {
            con1 = c1.connect();

            if (con1 == null) {
                // Add error flag if connection fails
                HashMap<String, String> errorDetail = new HashMap<>();
                errorDetail.put("error", "Error connecting to MySQL server");
                allDataMap.put("CONNECTION_ERROR", errorDetail);
                return allDataMap;
            }

            String query = "SELECT Dc_link, DC_name FROM drain_care";
            Statement stmt = con1.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                // 1. Get the unique key for the row (e.g., the URL link)
                String uniqueLink = rs.getString("Dc_link");

                // 2. Create a NEW HashMap for the row's details
                HashMap<String, String> rowDetails = new HashMap<>();

                // Populate the inner map with the row's details
                // You can add more columns here if your query selects them
                rowDetails.put("DC_name", rs.getString("DC_name"));

                // 3. Add the row to the main return map, using the link as the key
                allDataMap.put(uniqueLink, rowDetails);
            }

            con1.close();

            // Check if data was found only if no connection error occurred
            if (allDataMap.isEmpty()) {
                HashMap<String, String> errorDetail = new HashMap<>();
                errorDetail.put("error", "No data found");
                allDataMap.put("DATA_ERROR", errorDetail);
            }

        } catch (Exception e) {
            // Handle database exceptions
            HashMap<String, String> errorDetail = new HashMap<>();
            errorDetail.put("error", "Exception: " + e.getMessage());
            allDataMap.put("EXCEPTION", errorDetail);
        }

        return allDataMap;
    }
    public HashMap<String,HashMap<String,String>>getAlldata_for_wondcare(connectionclass c1)
    {

        // The return structure: Key is the Link (unique), Value is the row's data
        HashMap<String, HashMap<String, String>> allDataMap = new HashMap<>();
        Connection con1 = null;

        try {
            con1 = c1.connect();

            if (con1 == null) {
                // Add error flag if connection fails
                HashMap<String, String> errorDetail = new HashMap<>();
                errorDetail.put("error", "Error connecting to MySQL server");
                allDataMap.put("CONNECTION_ERROR", errorDetail);
                return allDataMap;
            }

            String query = "SELECT WC_link, WC_name FROM wonund_care";
            Statement stmt = con1.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                // 1. Get the unique key for the row (e.g., the URL link)
                String uniqueLink = rs.getString("WC_link");

                // 2. Create a NEW HashMap for the row's details
                HashMap<String, String> rowDetails = new HashMap<>();

                // Populate the inner map with the row's details
                // You can add more columns here if your query selects them
                rowDetails.put("WC_name", rs.getString("WC_name"));

                // 3. Add the row to the main return map, using the link as the key
                allDataMap.put(uniqueLink, rowDetails);
            }

            con1.close();

            // Check if data was found only if no connection error occurred
            if (allDataMap.isEmpty()) {
                HashMap<String, String> errorDetail = new HashMap<>();
                errorDetail.put("error", "No data found");
                allDataMap.put("DATA_ERROR", errorDetail);
            }

        } catch (Exception e) {
            // Handle database exceptions
            HashMap<String, String> errorDetail = new HashMap<>();
            errorDetail.put("error", "Exception: " + e.getMessage());
            allDataMap.put("EXCEPTION", errorDetail);
        }

        return allDataMap;
    }
    public List<String> getAllVideoNames(connectionclass c1) {
        List<String> videoNames = new ArrayList<>();

        try {
            Connection conn = c1.connect();
            if (conn != null) {
                String sql = "SELECT VideosName FROM patientstores"; // Only video names
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);

                while (rs.next()) {
                    String videoName = rs.getString("VideosName");
                    videoNames.add(videoName);
                }

                rs.close();
                stmt.close();
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return videoNames;
    }
    public static void downloadVideo(String videoName,Context c) {


                // ✅ Start download for each video (optional: could trigger only on button click)
                ExecutorService downloadExecutor = Executors.newSingleThreadExecutor();
                downloadExecutor.execute(() -> {
                    try {
                        connectionclass c1 = new connectionclass();
                        con_mysql m1 = new con_mysql();
                        Connection conn = c1.connect();

                        String sql = "SELECT Videos from patientstores WHERE VideosName = ?";
                        PreparedStatement stmt = conn.prepareStatement(sql);
                        stmt.setString(1, videoName);
                        ResultSet rs = stmt.executeQuery();

                        if (rs.next()) {
                            byte[] videoBytes =rs.getBytes("Videos");

                            File dir = new File(
                                    Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),
                                    "Videos"
                            );
                            if (!dir.exists()) dir.mkdirs();

                            File file = new File(dir, videoName + ".mp4");
                            FileOutputStream fos = new FileOutputStream(file);
                            fos.write(videoBytes);
                            fos.close();

                            showNotification(videoName,c);
                        }

                        rs.close();
                        stmt.close();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                );
        downloadExecutor.shutdown();
    }

    private static void showNotification(String videoName,Context c) {


        NotificationManager nm =
                (NotificationManager) c.getSystemService(Context.NOTIFICATION_SERVICE);

        String channelId = "download_channel";

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    channelId,
                    "Downloads",
                    NotificationManager.IMPORTANCE_HIGH
            );
            nm.createNotificationChannel(channel);
        }

        Notification notification = new NotificationCompat.Builder(c.getApplicationContext(), channelId)
                .setSmallIcon(android.R.drawable.stat_sys_download_done)
                .setContentTitle("Download Complete")
                .setContentText(videoName + " downloaded successfully")
                .setAutoCancel(true)
                .build();

        nm.notify((int) System.currentTimeMillis(), notification);
        Log.e("gsdfsf","///////////////////////////////////////////////////////////////");
    }

    public HashMap<String,HashMap<String,String>>getalldata_for_contres_website(connectionclass conn)
    {// The return structure: Key is the Link (unique), Value is the row's data
            HashMap<String, HashMap<String, String>> allDataMap = new HashMap<>();
            Connection con1 = null;

            try {
                con1 = conn.connect();

                if (con1 == null) {
                    // Add error flag if connection fails
                    HashMap<String, String> errorDetail = new HashMap<>();
                    errorDetail.put("error", "Error connecting to MySQL server");
                    allDataMap.put("CONNECTION_ERROR", errorDetail);
                    return allDataMap;
                }

                String query = "SELECT website, websiteName FROM contresw";
                Statement stmt = con1.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                while (rs.next()) {
                    // 1. Get the unique key for the row (e.g., the URL link)
                    String uniqueLink = rs.getString("website");

                    // 2. Create a NEW HashMap for the row's details
                    HashMap<String, String> rowDetails = new HashMap<>();

                    // Populate the inner map with the row's details
                    // You can add more columns here if your query selects them
                    rowDetails.put("websiteName", rs.getString("websiteName"));

                    // 3. Add the row to the main return map, using the link as the key
                    allDataMap.put(uniqueLink, rowDetails);
                }

                con1.close();

                // Check if data was found only if no connection error occurred
                if (allDataMap.isEmpty()) {
                    HashMap<String, String> errorDetail = new HashMap<>();
                    errorDetail.put("error", "No data found");
                    allDataMap.put("DATA_ERROR", errorDetail);
                }

            } catch (Exception e) {
                // Handle database exceptions
                HashMap<String, String> errorDetail = new HashMap<>();
                errorDetail.put("error", "Exception: " + e.getMessage());
                allDataMap.put("EXCEPTION", errorDetail);
            }

            return allDataMap;

    }
    public HashMap<String,HashMap<String,String>>getalldata_for_contres_email(connectionclass conn){

            // The return structure: Key is the Link (unique), Value is the row's data
            HashMap<String, HashMap<String, String>> allDataMap = new HashMap<>();
            Connection con1 = null;

            try {
                con1 = conn.connect();

                if (con1 == null) {
                    // Add error flag if connection fails
                    HashMap<String, String> errorDetail = new HashMap<>();
                    errorDetail.put("error", "Error connecting to MySQL server");
                    allDataMap.put("CONNECTION_ERROR", errorDetail);
                    return allDataMap;
                }

                String query = "SELECT email, emailName FROM contrese";
                Statement stmt = con1.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                while (rs.next()) {
                    // 1. Get the unique key for the row (e.g., the URL link)
                    String uniqueLink = rs.getString("emailName");

                    // 2. Create a NEW HashMap for the row's details
                    HashMap<String, String> rowDetails = new HashMap<>();

                    // Populate the inner map with the row's details
                    // You can add more columns here if your query selects them
                    rowDetails.put("email", rs.getString("email"));

                    // 3. Add the row to the main return map, using the link as the key
                    allDataMap.put(uniqueLink, rowDetails);
                }

                con1.close();

                // Check if data was found only if no connection error occurred
                if (allDataMap.isEmpty()) {
                    HashMap<String, String> errorDetail = new HashMap<>();
                    errorDetail.put("error", "No data found");
                    allDataMap.put("DATA_ERROR", errorDetail);
                }

            } catch (Exception e) {
                // Handle database exceptions
                HashMap<String, String> errorDetail = new HashMap<>();
                errorDetail.put("error", "Exception: " + e.getMessage());
                allDataMap.put("EXCEPTION", errorDetail);
            }

            return allDataMap;

    }
public HashMap<String,HashMap<String,String>>getalldata_for_contrese_phone(connectionclass conn){
        // The return structure: Key is the Link (unique), Value is the row's data
        HashMap<String, HashMap<String, String>> allDataMap = new HashMap<>();
        Connection con1 = null;

        try {
            con1 = conn.connect();

            if (con1 == null) {
                // Add error flag if connection fails
                HashMap<String, String> errorDetail = new HashMap<>();
                errorDetail.put("fs", "Error connecting to MySQL server");

                return allDataMap;
            }

            String query = "SELECT phone, PhoneName FROM contresp";
            Statement stmt = con1.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                // Use the phone number as a unique ID for the MAP
                String pNumber = rs.getString("phone");
                String pName = rs.getString("PhoneName");

                HashMap<String, String> row = new HashMap<>();
                row.put("NAME_KEY", pName);   // Label this clearly
                row.put("PHONE_KEY", pNumber);

                allDataMap.put(pNumber, row); // Store the row
            }

            con1.close();

            // Check if data was found only if no connection error occurred
            if (allDataMap.isEmpty()) {
                HashMap<Integer, String> errorDetail = new HashMap<>();
                errorDetail.put(404, "No data found");

            }

        } catch (Exception e) {
            // Handle database exceptions
            HashMap<Integer, String> errorDetail = new HashMap<>();
            errorDetail.put(404, "Exception: " + e.getMessage());

        }

        return allDataMap;

}
    public HashMap<String,HashMap<String,String>>getalldata_for_contllu_phone(connectionclass conn){
        // The return structure: Key is the Link (unique), Value is the row's data
        HashMap<String, HashMap<String, String>> allDataMap = new HashMap<>();
        Connection con1 = null;

        try {
            con1 = conn.connect();

            if (con1 == null) {
                // Add error flag if connection fails
                HashMap<String, String> errorDetail = new HashMap<>();
                errorDetail.put("fs", "Error connecting to MySQL server");

                return allDataMap;
            }

            String query = "SELECT phone, PhoneName FROM contllupn";
            Statement stmt = con1.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                // Use the phone number as a unique ID for the MAP
                String pNumber = rs.getString("phone");
                String pName = rs.getString("PhoneName");

                HashMap<String, String> row = new HashMap<>();
                row.put("NAME_KEY", pName);   // Label this clearly
                row.put("PHONE_KEY", pNumber);

                allDataMap.put(pNumber, row); // Store the row
            }

            con1.close();

            // Check if data was found only if no connection error occurred
            if (allDataMap.isEmpty()) {
                HashMap<Integer, String> errorDetail = new HashMap<>();
                errorDetail.put(404, "No data found");

            }

        } catch (Exception e) {
            // Handle database exceptions
            HashMap<Integer, String> errorDetail = new HashMap<>();
            errorDetail.put(404, "Exception: " + e.getMessage());

        }

        return allDataMap;
    }
    public HashMap<String,HashMap<String,String>>getalldata_for_contllue(connectionclass conn){

        // The return structure: Key is the Link (unique), Value is the row's data
        HashMap<String, HashMap<String, String>> allDataMap = new HashMap<>();
        Connection con1 = null;

        try {
            con1 = conn.connect();

            if (con1 == null) {
                // Add error flag if connection fails
                HashMap<String, String> errorDetail = new HashMap<>();
                errorDetail.put("error", "Error connecting to MySQL server");
                allDataMap.put("CONNECTION_ERROR", errorDetail);
                return allDataMap;
            }

            String query = "SELECT email, emailName FROM contllue";
            Statement stmt = con1.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                // 1. Get the unique key for the row (e.g., the URL link)
                String uniqueLink = rs.getString("emailName");

                // 2. Create a NEW HashMap for the row's details
                HashMap<String, String> rowDetails = new HashMap<>();

                // Populate the inner map with the row's details
                // You can add more columns here if your query selects them
                rowDetails.put("email", rs.getString("email"));

                // 3. Add the row to the main return map, using the link as the key
                allDataMap.put(uniqueLink, rowDetails);
            }

            con1.close();

            // Check if data was found only if no connection error occurred
            if (allDataMap.isEmpty()) {
                HashMap<String, String> errorDetail = new HashMap<>();
                errorDetail.put("error", "No data found");
                allDataMap.put("DATA_ERROR", errorDetail);
            }

        } catch (Exception e) {
            // Handle database exceptions
            HashMap<String, String> errorDetail = new HashMap<>();
            errorDetail.put("error", "Exception: " + e.getMessage());
            allDataMap.put("EXCEPTION", errorDetail);
        }

        return allDataMap;
    }
    public HashMap<String,HashMap<String,String>> getalldata_for_lhwmi(connectionclass conn){

       HashMap<String,HashMap<String,String>>alldatamap =new HashMap<>();
       Connection con1=null;
       try{
           con1=conn.connect();
           if(con1==null){
               HashMap<String, String> errorDetail = new HashMap<>();
               errorDetail.put("error", "Error connecting to MySQL server");
               alldatamap.put("CONNECTION_ERROR", errorDetail);
               return alldatamap;
           }
           String query = "SELECT LHWMILink, LHWMIName,LHWMIDate FROM lhwmi";
           Statement stmt = con1.createStatement();
           ResultSet rs = stmt.executeQuery(query);
           while (rs.next()) {
               String uniqueKey = rs.getString("LHWMIName");

               HashMap<String, String> rowDetails = new HashMap<>();

               // ✅ Put the correct data into the correct keys
               rowDetails.put("LHWMIName", rs.getString("LHWMIName"));
               rowDetails.put("LHWMILink", rs.getString("LHWMILink")); // You need the URL!
               rowDetails.put("LHWMIDate", rs.getString("LHWMIDate"));

               alldatamap.put(uniqueKey, rowDetails);
           }
           con1.close();
           if (alldatamap.isEmpty()) {
               HashMap<String, String> errorDetail = new HashMap<>();
               errorDetail.put("error", "No data found");
               alldatamap.put("DATA_ERROR", errorDetail);
           }
       }catch (Exception e){
           HashMap<String, String> errorDetail = new HashMap<>();
           errorDetail.put("error", "Exception: " + e.getMessage());
           alldatamap.put("EXCEPTION", errorDetail);
       }
       return alldatamap;
    }
    public HashMap<String,HashMap<String,String>>getalldata_for_lhwfb(connectionclass conn)
    {

        // The return structure: Key is the Link (unique), Value is the row's data
        HashMap<String, HashMap<String, String>> allDataMap = new HashMap<>();
        Connection con1 = null;

        try {
            con1 = conn.connect();

            if (con1 == null) {
                // Add error flag if connection fails
                HashMap<String, String> errorDetail = new HashMap<>();
                errorDetail.put("error", "Error connecting to MySQL server");
                allDataMap.put("CONNECTION_ERROR", errorDetail);
                return allDataMap;
            }

            String query = "SELECT FBLink, FBName FROM lhwfb";
            Statement stmt = con1.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                // 1. Get the unique key for the row (e.g., the URL link)
                String uniqueLink = rs.getString("FBLink");

                // 2. Create a NEW HashMap for the row's details
                HashMap<String, String> rowDetails = new HashMap<>();

                // Populate the inner map with the row's details
                // You can add more columns here if your query selects them
                rowDetails.put("FBName", rs.getString("FBName"));

                // 3. Add the row to the main return map, using the link as the key
                allDataMap.put(uniqueLink, rowDetails);
            }

            con1.close();

            // Check if data was found only if no connection error occurred
            if (allDataMap.isEmpty()) {
                HashMap<String, String> errorDetail = new HashMap<>();
                errorDetail.put("error", "No data found");
                allDataMap.put("DATA_ERROR", errorDetail);
            }

        } catch (Exception e) {
            // Handle database exceptions
            HashMap<String, String> errorDetail = new HashMap<>();
            errorDetail.put("error", "Exception: " + e.getMessage());
            allDataMap.put("EXCEPTION", errorDetail);
        }

        return allDataMap;
    }

    public HashMap<String, HashMap<String, String>> getAllData_AsMap(connectionclass conn) {

        // The return structure: Key is the Link (unique), Value is the row's data
        HashMap<String, HashMap<String, String>> allDataMap = new HashMap<>();
        Connection con1 = null;

        try {
            con1 = conn.connect();

            if (con1 == null) {
                // Add error flag if connection fails
                HashMap<String, String> errorDetail = new HashMap<>();
                errorDetail.put("error", "Error connecting to MySQL server");
                allDataMap.put("CONNECTION_ERROR", errorDetail);
                return allDataMap;
            }

            String query = "SELECT LHWWLink, LHWWName FROM lhwmwl";
            Statement stmt = con1.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                // 1. Get the unique key for the row (e.g., the URL link)
                String uniqueLink = rs.getString("LHWWLink");

                // 2. Create a NEW HashMap for the row's details
                HashMap<String, String> rowDetails = new HashMap<>();

                // Populate the inner map with the row's details
                // You can add more columns here if your query selects them
                rowDetails.put("LHWWName", rs.getString("LHWWName"));

                // 3. Add the row to the main return map, using the link as the key
                allDataMap.put(uniqueLink, rowDetails);
            }

            con1.close();

            // Check if data was found only if no connection error occurred
            if (allDataMap.isEmpty()) {
                HashMap<String, String> errorDetail = new HashMap<>();
                errorDetail.put("error", "No data found");
                allDataMap.put("DATA_ERROR", errorDetail);
            }

        } catch (Exception e) {
            // Handle database exceptions
            HashMap<String, String> errorDetail = new HashMap<>();
            errorDetail.put("error", "Exception: " + e.getMessage());
            allDataMap.put("EXCEPTION", errorDetail);
        }

        return allDataMap;
    }
    public HashMap<String, String> getUserData(String userName) {

        HashMap<String, String> data = new HashMap<>();

        try {
          con = connectionclass.connect();

            if (con == null) {
                data.put("error", "Error connecting to MySQL server");
                return data;
            }

            String query = "SELECT UserNameF, UserChildNF, UserChildNL, UserPassw, gender " +
                    "FROM cnusers WHERE UserNameF = '" + userName + "'";

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            if (rs.next()) {
                data.put("UserNameF", rs.getString("UserNameF"));
                data.put("UserChildNF", rs.getString("UserChildNF"));
                data.put("UserChildNL", rs.getString("UserChildNL"));
                data.put("UserPassw", rs.getString("UserPassw"));
                data.put("gender", String.valueOf(rs.getInt("gender")));
            } else {
                data.put("error", "User not found");
            }

            con.close();

        } catch (Exception e) {
            data.put("error", "Exception: " + e.getMessage());
        }

        return data;
    }

    public HashMap<String, String> getUserData(String userName, String password,connectionclass cong) {

        HashMap<String, String> data = new HashMap<>();


            try {
                Connection con = cong.connect();

                if (con == null) {
                    data.put("error", "Error connecting to MySQL server");
                    return data;
                }

                // Query matching both username and password
                String query = "SELECT UserNameF, UserChildNF, UserChildNL, UserPassw, gender " +
                        "FROM cnusers " +
                        "WHERE UserNameF = '" + userName + "' AND UserPassw = '" + password + "'";

                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                if (rs.next()) {
                    data.put("UserNameF", rs.getString("UserNameF"));
                    data.put("UserChildNF", rs.getString("UserChildNF"));
                    data.put("UserChildNL", rs.getString("UserChildNL"));
                    data.put("UserPassw", rs.getString("UserPassw"));
                    data.put("gender", String.valueOf(rs.getInt("gender")));
                } else {
                    data.put("error", "User not found or password incorrect");
                }

                con.close();

            } catch (Exception e) {
                data.put("error", "Exception: " + e.getMessage());
            }

        return data;


    }
    public void insert_for2(String Link,String Name,String table_name,String p1,String p2,connectionclass c1)
    {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(() -> {
            String useDB = "USE codenova;";
            String insertQuery = "INSERT INTO " + table_name + " (" + p1 + ", " + p2 + ") VALUES (?, ?)";
Connection cc=c1.connect();
            PreparedStatement ps = null;
            try {
                ps = cc.prepareStatement(insertQuery);
                ps.setString(1, Link);
                ps.setString(2, Name);
                ps.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public boolean check_data_for2(String Name, String Table_name, String p, connectionclass c) {
        boolean af = false;
        if (Objects.equals(Table_name, "contllue")) {
            con_mysql a = new con_mysql();
            HashMap<String, HashMap<String, String>> z = a.getalldata_for_contllue(c);
Log.e("ss",String.valueOf(z.size()));
            if (z.containsValue(Name)||z.containsKey(Name)) {
             af=true;
            }
        }
        else if(Objects.equals(Table_name, "contllupn"))
        {
            con_mysql a = new con_mysql();
            HashMap<String, HashMap<String, String>> z = a.getalldata_for_contllu_phone(c);
            Log.e("ss",String.valueOf(z.size()));
            if (z.containsValue(Name)||z.containsKey(Name)) {
                af=true;
            }
        }
        else if(Objects.equals(Table_name, "contrese"))
        {
            con_mysql a = new con_mysql();
            HashMap<String, HashMap<String, String>> z = a.getalldata_for_contres_email(c);
            Log.e("ss",String.valueOf(z.size()));
            if (z.containsValue(Name)||z.containsKey(Name)) {
                af=true;
            }
        }
        else if(Objects.equals(Table_name, "contresp"))
        {
            con_mysql a = new con_mysql();
            HashMap<String, HashMap<String, String>> z = a.getalldata_for_contrese_phone(c);
            Log.e("ss",String.valueOf(z.size()));
            if (z.containsValue(Name)||z.containsKey(Name)) {
                af=true;
            }
        }
        else if(Objects.equals(Table_name, "contresw"))
        {
            con_mysql a = new con_mysql();
            HashMap<String, HashMap<String, String>> z = a.getalldata_for_contres_website(c);
            Log.e("ss",String.valueOf(z.size()));
            if (z.containsValue(Name)||z.containsKey(Name)) {
                af=true;
            }
        }
        else if(Objects.equals(Table_name, "drain_care"))
        {
            con_mysql a = new con_mysql();
            HashMap<String, HashMap<String, String>> z = a.getAllData_for_darincare(c);
            Log.e("ss",String.valueOf(z.size()));
            if (z.containsValue(Name)||z.containsKey(Name)) {
                af=true;
            }
        }
        else if(Objects.equals(Table_name, "email_copy"))
        {
            con_mysql a = new con_mysql();
            HashMap<String, HashMap<String, String>> z = a.getAllData_for_emailcopy(c);
            Log.e("ss",String.valueOf(z.size()));
            if (z.containsValue(Name)||z.containsKey(Name)) {
                af=true;
            }
        }
        else if(Objects.equals(Table_name, "hospital_showers"))
        {
            con_mysql a = new con_mysql();
            HashMap<String, HashMap<String, String>> z = a.getAllData_for_hospita_info(c);
            Log.e("ss",String.valueOf(z.size()));
            if (z.containsValue(Name)||z.containsKey(Name)) {
                af=true;
            }
        }
        else if(Objects.equals(Table_name, "lhwfb"))
        {
            con_mysql a = new con_mysql();
            HashMap<String, HashMap<String, String>> z = a.getalldata_for_lhwfb(c);
            Log.e("ss",String.valueOf(z.size()));
            if (z.containsValue(Name)||z.containsKey(Name)) {
                af=true;
            }
        }
        else if(Objects.equals(Table_name, "lhwmwl"))
        {
            con_mysql a = new con_mysql();
            HashMap<String, HashMap<String, String>> z = a.getAllData_AsMap(c);
            Log.e("ss",String.valueOf(z.size()));
            if (z.containsValue(Name)||z.containsKey(Name)) {
                af=true;
            }
        }
        else if(Objects.equals(Table_name, "mendedhearts"))
        {
            con_mysql a = new con_mysql();
            HashMap<String, HashMap<String, String>> z = a.getAllData_for_mendedheart(c);
            Log.e("ss",String.valueOf(z.size()));
            if (z.containsValue(Name)||z.containsKey(Name)) {
                af=true;
            }
        }
        else if(Objects.equals(Table_name, "videos_of_defects"))
        {
            con_mysql a = new con_mysql();
            HashMap<String, HashMap<String, String>> z = a.getAllData_for_vid_of_def(c);
            Log.e("ss",String.valueOf(z.size()));
            if (z.containsValue(Name)||z.containsKey(Name)) {
                af=true;
            }
        }
        else if(Objects.equals(Table_name, "wonund_care"))
        {
            con_mysql a = new con_mysql();
            HashMap<String, HashMap<String, String>> z = a.getAlldata_for_wondcare(c);
            Log.e("ss",String.valueOf(z.size()));
            if (z.containsValue(Name)||z.containsKey(Name)) {
                af=true;
            }
        }
        else if(Objects.equals(Table_name, "hewn"))
        {
            con_mysql a = new con_mysql();
            HashMap<String, HashMap<String, String>> z = a.getAllData_for_hewn(c);
            Log.e("ss",String.valueOf(z.size()));
            if (z.containsValue(Name)||z.containsKey(Name)) {
                af=true;
            }
        }
        else if(Objects.equals(Table_name, "lhwmi"))
        {
            con_mysql a = new con_mysql();
            HashMap<String, HashMap<String, String>> z = a.getalldata_for_lhwmi(c);
            Log.e("ss",String.valueOf(z.size()));
            if (z.containsValue(Name)||z.containsKey(Name)) {
                af=true;
            }
        }

        return af;
    }
    public void registerUser(String userName, String childNameF, String childNameL,
                             String password, int gender,connectionclass c) {

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(() -> {
            String str;

            try {
                 con = c.connect();
Log.e("correct1","corrrreeeeeectttttt1");
                if (con == null) {
                    str = "Error connecting to MySQL server";
                } else {

                    // Check if username exists
                    String checkQuery = "SELECT * FROM cnusers WHERE UserNameF = '" + userName + "'";
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery(checkQuery);

                    if (rs.next() && rs.getInt(1) > 0) {
                        Log.e("sfdsf", String.valueOf(Toast.LENGTH_SHORT));
                    }

                    // Insert new user
                    String useDB = "USE codenova;";
                    String insertQuery = "INSERT INTO cnusers (UserNameF, UserChildNF, UserChildNL, UserPassw, gender) " +
                            "VALUES ('" + userName + "', '" + childNameF + "', '" + childNameL + "', '" + password + "', " + gender + ")";

                    try {
                        Statement st = con.createStatement();
                        st.executeQuery(useDB);

                        Statement st2 = con.createStatement();
                        st2.executeUpdate(insertQuery);
                        con.commit();
                        con.close();

                        str = "User registered successfully";

                    } catch (SQLException e) {
                        str = "Error inserting user";
                    }
                }

            } catch (Exception e) {
                str = "Exception: " + e.getMessage();
            }

            String finalStr = str;
            Log.e("sfdsf",str);
        });
    }
    public boolean isUserExists(String userName,connectionclass c) {

        boolean exists = false;

        try {
            Connection con = c.connect();

            if (con == null) {
                return false;   // Could also throw error if you prefer
            }

            String query = "SELECT UserNameF FROM cnusers WHERE UserNameF = '" + userName + "'";

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            if (rs.next()) {
                exists = true;   // User found
            }

            con.close();

        } catch (Exception e) {
            return false;   // If exception happens, treat as not exists
        }

        return exists;
    }

}
