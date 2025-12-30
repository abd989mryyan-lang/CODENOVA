package com.example.myapplication;

import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Objects;

public class connectionclass {
    //private static final String Host="localhost";
    protected static String databaseN="codenova";
    protected static  String Port="3306";
    protected static  String User="root";
    protected static  String ip= "10.0.2.2";
    protected static  String password="Zedge.2002.2.16";//Password="AVNS_--tSCYvfs0eRiTdLC4a";
    public Connection connect() {
        Connection conn =null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String connectionstring="jdbc:mysql://"+ip+":"+Port+"/"+databaseN;
            conn= DriverManager.getConnection(connectionstring,User,password);
            Log.e("erro", "corrrrrrrrrrrectttttttttt0");

        }
        catch (Exception e){
            Log.e("erro", Objects.requireNonNull(e.getMessage()));
        }

        return conn;
    }

}
