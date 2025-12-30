package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.compose.material3.ButtonColors;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.mysql.jdbc.SQLError;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class signup extends AppCompatActivity implements View.OnClickListener {
    connectionclass connectionclass1;
    Connection con;
    ResultSet rs;
    String name,str;
    Button B1;
    Button B2;
    RadioButton R1;
    RadioButton R2;
    EditText E1;
    EditText E2;
    EditText E3;
    EditText E4;
    ExecutorService executor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        connectionclass1=new connectionclass();

        B1=findViewById(R.id.btn_sign_up);
 B2=findViewById(R.id.btn_Back_login);
 R1=findViewById(R.id.rb_female);
 R2=findViewById(R.id.rb_male);
 E1=findViewById(R.id.Username);
 E2=findViewById(R.id.child_name);
 E3=findViewById(R.id.last_name_child);
 E4=findViewById(R.id.Password);
        B1.setOnClickListener(this);
        B2.setOnClickListener(this);


    }
    /*public void connect(){
        if(E1.getText().toString().isEmpty()||E2.getText().toString().isEmpty()||E3.getText().toString().isEmpty()||E4.getText().toString().isEmpty())
        {
            if(R1.isChecked()!=true)
            {
                if(R2.isChecked()!=true)
                {
            str = "empty feiled";
            Toast.makeText(this, str, Toast.LENGTH_SHORT).show();

                }
                str = "empty feiled";
                Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
            }
            str = "empty feiled";
            Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
        }
        else{
        ExecutorService executerserveic= Executors.newSingleThreadExecutor();
        executerserveic.execute(()->{
            try {
                con=connectionclass.connect();
                if(con==null) {
                    str = "Error in connection with mysql server";

                }
                else
                {

                    String name = E1.getText().toString().trim();
                    String query = "SELECT * FROM cnusers WHERE UserNameF = '" + name + "'";

                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery(query);

                    if (rs.next() && rs.getInt(1) > 0)
                    {
                        Toast.makeText(this, "Name already exists!", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                      str="connected to mysql server";
                      if(R1.isChecked()) {
                        String query123 = "use codenova;";
                        String query2 = "INSERT INTO cnusers (UserNameF,UserChildNF,UserChildNL, UserPassw,gender) VALUES ('" + E1.getText().toString() + "', '" + E2.getText().toString() + "', '" + E3.getText().toString() + "','" + E4.getText().toString() + "',1)";
                        try {
                            java.sql.Statement st = null;
                            st = con.createStatement();
                            rs = st.executeQuery(query123);
                            Log.e("ff", "correct*******************1111111");
                            try {
                                java.sql.Statement st2 = null;
                                st2 = con.createStatement();
                                st2.executeUpdate(query2);
                                Log.e("ff", "correct*******************222222");
                                con.close();
                            } catch (SQLException e) {
                                throw new RuntimeException(e);
                            }

                        } catch (SQLException e) {
                            Log.e("ff", "errrorrrrrrrrr");
                            throw new RuntimeException(e);
                        }

                    }
                    else if(R2.isChecked())
                    {          String query6 ="use codenova;";
                          String query22 ="INSERT INTO cnusers (UserNameF,UserChildNF,UserChildNL, UserPassw,gender) VALUES ('"+ E1.getText().toString() + "', '" + E2.getText().toString() + "', '" + E3.getText().toString() + "','" + E4.getText().toString() + "',0)";
                          try {
                              java.sql.Statement st = null;
                              st = con.createStatement();
                              rs = st.executeQuery(query6);
                              Log.e("ff","correct*******************1111111");
                              try {
                                  java.sql.Statement st2=null;
                                  st2 = con.createStatement();
                                  st2.executeUpdate(query22);
                                  Log.e("ff","correct*******************222222");
                                  con.close();
                              } catch (SQLException e) {
                                  throw new RuntimeException(e);
                              }

                          } catch (SQLException e) {
                              Log.e("ff","errrorrrrrrrrr");
                              throw new RuntimeException(e);
                          }

                    }
                }
                }


            }catch (Exception e){throw new RuntimeException(e);}
            runOnUiThread(()->{
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
            });
        });
    }
    }
    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    public void connect2(){

        executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            con_mysql c1=new con_mysql();
            boolean b1 = c1.isUserExists(E1.getText().toString(), connectionclass1);
            runOnUiThread(() -> {

                if (b1) {
                    str = "feiled!!!!!!!!!!!!!!!!!!!!!!!!!";
                    Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
                    // heeeeeeeeeeerrrrrrrrrrrrrrrrreeeeeeeeeeeeeeee
                } else if (E1.getText().toString().isEmpty() || E2.getText().toString().isEmpty() || E3.getText().toString().isEmpty() || E4.getText().toString().isEmpty()||(R1.isChecked()&&R2.isChecked())) {
                    str = "empty feiled";
                    Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
                } else {
                    con_mysql c = new con_mysql();

                    str = "sucsess !!!!";
                    Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
                    if (R1.isChecked()) {
                        c.registerUser(E1.getText().toString(), E2.getText().toString(), E3.getText().toString(), E4.getText().toString(), 0, connectionclass1);
                    } else if (R2.isChecked()) {
                        c.registerUser(E1.getText().toString(), E2.getText().toString(), E3.getText().toString(), E4.getText().toString(), 1, connectionclass1);
                    }

                }
            });
        });
    }
    @Override
    public void onClick(View v) {


        if(v.getId()==R.id.btn_sign_up){
     connect2();
        }
        else if(v.getId()==R.id.btn_Back_login){
             startActivity(new Intent(this,signin_activity.class));
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (executor != null && !executor.isShutdown()) {
            executor.shutdownNow();
        }
    }
}