package com.example.myapplication;

import android.app.SearchManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.text.TextUtils;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.sql.Connection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Admin_main_please_work extends AppCompatActivity implements View.OnClickListener {
    EditText E1,E2,E3,E4,E5,E6,E7,E8,E9,E10,E11,E12,E1a,E2a,E3a,E4a,E5a,E6a,E7a,E8a,E9a,E10a,E11a,E12a,E1b,E2b;
    Button B1,B2,B3,B4,B5,B6,B1a,B2a,B3a,B4a,B5a,B6a,B1b;
    ExecutorService executor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_main_please_work);
        B1=findViewById(R.id.button_1);
        B1.setOnClickListener(this);
        B2=findViewById(R.id.button_2);
        B2.setOnClickListener(this);
        B3=findViewById(R.id.button_3);
        B3.setOnClickListener(this);
        B4=findViewById(R.id.button_4);
        B4.setOnClickListener(this);
        B5=findViewById(R.id.button_5);
        B5.setOnClickListener(this);
        B6=findViewById(R.id.button_6);
        B6.setOnClickListener(this);
        B1a=findViewById(R.id.button_1a);
        B1a.setOnClickListener(this);
        B2a=findViewById(R.id.button_2a);
        B2a.setOnClickListener(this);
        B3a=findViewById(R.id.button_3a);
        B3a.setOnClickListener(this);
        B4a=findViewById(R.id.button_4a);
        B4a.setOnClickListener(this);
        B5a=findViewById(R.id.button_5a);
        B5a.setOnClickListener(this);
        B6a=findViewById(R.id.button_6a);
        B6a.setOnClickListener(this);
        B1b=findViewById(R.id.button_1b);
        B1b.setOnClickListener(this);


        E1=findViewById(R.id.edit_text_1);
        E2=findViewById(R.id.edit_text_2);
        E3=findViewById(R.id.edit_text_3);
        E4=findViewById(R.id.edit_text_4);
        E5=findViewById(R.id.edit_text_5);
        E6=findViewById(R.id.edit_text_6);
        E7=findViewById(R.id.edit_text_7);
        E8=findViewById(R.id.edit_text_8);
        E9=findViewById(R.id.edit_text_9);
        E10=findViewById(R.id.edit_text_10);
        E11=findViewById(R.id.edit_text_11);
        E12=findViewById(R.id.edit_text_12);
        E1a=findViewById(R.id.edit_text_1a);
        E2a=findViewById(R.id.edit_text_2a);
        E3a=findViewById(R.id.edit_text_3a);
        E4a=findViewById(R.id.edit_text_4a);
        E5a=findViewById(R.id.edit_text_5a);
        E6a=findViewById(R.id.edit_text_6a);
        E7a=findViewById(R.id.edit_text_7a);
        E8a=findViewById(R.id.edit_text_8a);
        E9a=findViewById(R.id.edit_text_9a);
        E10a=findViewById(R.id.edit_text_10a);
        E11a=findViewById(R.id.edit_text_11a);
        E12a=findViewById(R.id.edit_text_12a);
        E1b=findViewById(R.id.edit_text_1b);
        E2b=findViewById(R.id.edit_text_2b);
        executor = Executors.newSingleThreadExecutor();
    }

    @Override
    public void onClick(View v) {

              //  Toast.makeText(this,String.valueOf(c2==null),Toast.LENGTH_SHORT);
        if(v.getId()==R.id.button_1)
        {
            executor.execute(() -> {
                    con_mysql c1 = new con_mysql();
                    connectionclass c2 = new connectionclass();
                runOnUiThread(() -> {
                    Toast.makeText(this, String.valueOf(1), Toast.LENGTH_SHORT).show();
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.VANILLA_ICE_CREAM) {
                        if (E1.getText().isEmpty() || E2.getText().isEmpty()) {
                            Toast.makeText(this, "empty in Edit Text", Toast.LENGTH_SHORT).show();
                        } else if (!c1.check_data_for2(E1.getText().toString(), "contllue", "emailName", c2)) {
                            c1.insert_for2(E1.getText().toString(), E2.getText().toString(), "contllue", "email", "emailName", c2);
                            Toast.makeText(this, E1.getText().toString()+"added success to contllue table", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            });
        }
        else if(v.getId()==R.id.button_2)
        {
            executor.execute(() -> {
                con_mysql c1 = new con_mysql();
                connectionclass c2 = new connectionclass();
                runOnUiThread(() -> {
                    Toast.makeText(this, String.valueOf(1), Toast.LENGTH_SHORT).show();
                    if (E3.getText().isEmpty() || E4.getText().isEmpty()) {
                        Toast.makeText(this, "empty in Edit Text", Toast.LENGTH_SHORT).show();
                    } else if (!c1.check_data_for2(E3.getText().toString(), "contllupn", "phone", c2)) {
                        c1.insert_for2(E3.getText().toString(), E4.getText().toString(), "contllupn", "phone", "PhoneName", c2);
                        Toast.makeText(this, E3.getText().toString()+"added success to contllupn table", Toast.LENGTH_SHORT).show();
                    }
                });
            });
        }
        else if(v.getId()==R.id.button_3)
        {
            executor.execute(() -> {
                con_mysql c1 = new con_mysql();
                connectionclass c2 = new connectionclass();
                runOnUiThread(() -> {
                    Toast.makeText(this, String.valueOf(1), Toast.LENGTH_SHORT).show();
                    if (E5.getText().isEmpty() || E6.getText().isEmpty()) {
                        Toast.makeText(this, "empty in Edit Text", Toast.LENGTH_SHORT).show();
                    } else if (!c1.check_data_for2(E5.getText().toString(), "contrese", "email", c2)) {
                        c1.insert_for2(E5.getText().toString(), E6.getText().toString(), "contrese", "email", "emailName", c2);
                        Toast.makeText(this, E5.getText().toString()+"added success to contrese table", Toast.LENGTH_SHORT).show();
                    }
                });
            });
        }
        else if(v.getId()==R.id.button_4)
        {
            executor.execute(() -> {
                con_mysql c1 = new con_mysql();
                connectionclass c2 = new connectionclass();
                runOnUiThread(() -> {
                    Toast.makeText(this, String.valueOf(1), Toast.LENGTH_SHORT).show();
                    if (E7.getText().isEmpty() || E8.getText().isEmpty()) {
                        Toast.makeText(this, "empty in Edit Text", Toast.LENGTH_SHORT).show();
                    } else if (!c1.check_data_for2(E7.getText().toString(), "contresp", "phone", c2)) {
                        c1.insert_for2(E7.getText().toString(), E8.getText().toString(), "contresp", "phone", "PhoneName", c2);
                        Toast.makeText(this, E7.getText().toString()+"added success to contresp table", Toast.LENGTH_SHORT).show();
                    }
                });
            });
        }
        else if(v.getId()==R.id.button_5)
        {
            executor.execute(() -> {
                con_mysql c1 = new con_mysql();
                connectionclass c2 = new connectionclass();
                runOnUiThread(() -> {
                    Toast.makeText(this, String.valueOf(1), Toast.LENGTH_SHORT).show();
                    if (E9.getText().isEmpty() || E10.getText().isEmpty()) {
                        Toast.makeText(this, "empty in Edit Text", Toast.LENGTH_SHORT).show();
                    } else if (!c1.check_data_for2(E9.getText().toString(), "contresw", "website", c2)) {
                        c1.insert_for2(E9.getText().toString(), E10.getText().toString(), "contresw", "website", "websiteName", c2);
                        Toast.makeText(this, E9.getText().toString()+"added success to contresw table", Toast.LENGTH_SHORT).show();
                    }
                });
            });
        }
        else if(v.getId()==R.id.button_6)
        {
            executor.execute(() -> {
                con_mysql c1 = new con_mysql();
                connectionclass c2 = new connectionclass();
                runOnUiThread(() -> {
                    Toast.makeText(this, String.valueOf(1), Toast.LENGTH_SHORT).show();
                    if (E11.getText().isEmpty() || E12.getText().isEmpty()) {
                        Toast.makeText(this, "empty in Edit Text", Toast.LENGTH_SHORT).show();
                    } else if (!c1.check_data_for2(E11.getText().toString(), "drain_care", "Dc_link", c2)) {
                        c1.insert_for2(E11.getText().toString(), E12.getText().toString(), "drain_care", "Dc_link", "DC_name", c2);
                        Toast.makeText(this, E11.getText().toString()+"added success to drain_care table", Toast.LENGTH_SHORT).show();
                    }
                });
            });
        }
        if(v.getId()==R.id.button_1a)
        {
            executor.execute(() -> {
                con_mysql c1 = new con_mysql();
                connectionclass c2 = new connectionclass();
                runOnUiThread(() -> {
                    Toast.makeText(this, String.valueOf(1), Toast.LENGTH_SHORT).show();
                    if (E1a.getText().isEmpty() || E2a.getText().isEmpty()) {
                        Toast.makeText(this, "empty in Edit Text", Toast.LENGTH_SHORT).show();
                    } else if (!c1.check_data_for2(E1a.getText().toString(), "email_copy", "email_name", c2)) {
                        c1.insert_for2(E1a.getText().toString(), E2a.getText().toString(), "email_copy", "email", "email_name", c2);
                        Toast.makeText(this, E1a.getText().toString()+"added success to email_copy table", Toast.LENGTH_SHORT).show();
                    }
                });
            });
        }
        else if(v.getId()==R.id.button_2a)
        {
            executor.execute(() -> {
                con_mysql c1 = new con_mysql();
                connectionclass c2 = new connectionclass();
                runOnUiThread(() -> {
                    Toast.makeText(this, String.valueOf(1), Toast.LENGTH_SHORT).show();
                    if (E3a.getText().isEmpty() || E4a.getText().isEmpty()) {
                        Toast.makeText(this, "empty in Edit Text", Toast.LENGTH_SHORT).show();
                    } else if (!c1.check_data_for2(E3a.getText().toString(), "hospital_showers", "hospital_loc", c2)) {
                        c1.insert_for2(E3a.getText().toString(), E4a.getText().toString(), "hospital_showers", "hospital_loc", "hospital_name", c2);
                        Toast.makeText(this, E3a.getText().toString()+"added success to hospital_showers table", Toast.LENGTH_SHORT).show();
                    }
                });
            });
        }
        else if(v.getId()==R.id.button_3a)
        {
            executor.execute(() -> {
                con_mysql c1 = new con_mysql();
                connectionclass c2 = new connectionclass();
                runOnUiThread(() -> {
                    Toast.makeText(this, String.valueOf(1), Toast.LENGTH_SHORT).show();
                    if (E5a.getText().isEmpty() || E6a.getText().isEmpty()) {
                        Toast.makeText(this, "empty in Edit Text", Toast.LENGTH_SHORT).show();
                    } else if (!c1.check_data_for2(E5a.getText().toString(), "lhwfb", "FBLink", c2)) {
                        c1.insert_for2(E5a.getText().toString(), E6a.getText().toString(), "lhwfb", "FBLink", "FBName", c2);
                        Toast.makeText(this, E5a.getText().toString()+"added success to lhwfb table", Toast.LENGTH_SHORT).show();
                    }
                });
            });
        }
        else if(v.getId()==R.id.button_4a)
        {
            executor.execute(() -> {
                con_mysql c1 = new con_mysql();
                connectionclass c2 = new connectionclass();
                runOnUiThread(() -> {
                    Toast.makeText(this, String.valueOf(1), Toast.LENGTH_SHORT).show();
                    if (E7a.getText().isEmpty() || E8a.getText().isEmpty()) {
                        Toast.makeText(this, "empty in Edit Text", Toast.LENGTH_SHORT).show();
                    } else if (!c1.check_data_for2(E7a.getText().toString(), "lhwmwl", "LHWWLink", c2)) {
                        c1.insert_for2(E7a.getText().toString(), E8a.getText().toString(), "lhwmwl", "LHWWLink", "LHWWName", c2);
                        Toast.makeText(this, E7a.getText().toString()+"added success to lhwmwl table", Toast.LENGTH_SHORT).show();
                    }
                });
            });
        }
        else if(v.getId()==R.id.button_5a)
        {
            executor.execute(() -> {
                con_mysql c1 = new con_mysql();
                connectionclass c2 = new connectionclass();
                runOnUiThread(() -> {
                    Toast.makeText(this, String.valueOf(1), Toast.LENGTH_SHORT).show();
                    if (E9a.getText().isEmpty() || E10a.getText().isEmpty()) {
                        Toast.makeText(this, "empty in Edit Text", Toast.LENGTH_SHORT).show();
                    } else if (!c1.check_data_for2(E9a.getText().toString(), "mendedhearts", "contweblink", c2)) {
                        c1.insert_for2(E9a.getText().toString(), E10a.getText().toString(), "mendedhearts", "contweblink", "contwebname", c2);
                        Toast.makeText(this, E9a.getText().toString()+"added success to mendedhearts table", Toast.LENGTH_SHORT).show();
                    }
                });
            });
        }
        else if(v.getId()==R.id.button_6a)
        {
            executor.execute(() -> {
                con_mysql c1 = new con_mysql();
                connectionclass c2 = new connectionclass();
                runOnUiThread(() -> {
                    Toast.makeText(this, String.valueOf(1), Toast.LENGTH_SHORT).show();
                    if (E11a.getText().isEmpty() || E12a.getText().isEmpty()) {
                        Toast.makeText(this, "empty in Edit Text", Toast.LENGTH_SHORT).show();
                    } else if (!c1.check_data_for2(E11a.getText().toString(), "videos_of_defects", "VD_link", c2)) {
                        c1.insert_for2(E11a.getText().toString(), E12a.getText().toString(), "videos_of_defects", "VD_link", "VD_name", c2);
                        Toast.makeText(this, E11a.getText().toString()+"added success to videos_of_defects table", Toast.LENGTH_SHORT).show();
                    }
                });
            });
        }
        if(v.getId()==R.id.button_1b)
        {
            executor.execute(() -> {
                con_mysql c1 = new con_mysql();
                connectionclass c2 = new connectionclass();
                runOnUiThread(() -> {
                    Toast.makeText(this, String.valueOf(1), Toast.LENGTH_SHORT).show();
                    if (E1b.getText().isEmpty() || E2b.getText().isEmpty()) {
                        Toast.makeText(this, "empty in Edit Text", Toast.LENGTH_SHORT).show();
                    } else if (!c1.check_data_for2(E1b.getText().toString(), "wonund_care", "WC_link", c2)) {
                        c1.insert_for2(E1b.getText().toString(), E2b.getText().toString(), "wonund_care", "WC_link", "WC_name", c2);
                        Toast.makeText(this, E1b.getText().toString()+"added success to wonund_care table", Toast.LENGTH_SHORT).show();
                    }
                });
            });
        }
}
}