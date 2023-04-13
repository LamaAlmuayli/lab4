package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    // make a reference to buttons
    Button btn_add;
    Switch sw_active;
    EditText et_name, et_age;
    DataBaseHelper dataBaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // on create, give value
        btn_add = findViewById(R.id.btn_add);
        et_age=findViewById(R.id.et_age);
        et_name = findViewById(R.id.et_name);
        sw_active = findViewById(R.id.sw_active);

        dataBaseHelper = new DataBaseHelper(MainActivity.this);


        btn_add.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // create model
                Model studentMod;
                try {
                    studentMod = new Model(-1, et_name.getText().toString(), Integer.parseInt(et_age.getText().toString()), sw_active.isChecked());
                    Toast.makeText(MainActivity.this, "Added", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Enter Valid input", Toast.LENGTH_SHORT).show();
                    studentMod = new Model(-1, "ERROR", 0, false);
                }

                DataBaseHelper dataBaseHelper = new DataBaseHelper(MainActivity.this);
                boolean b = dataBaseHelper.addOne(studentMod);
                Toast.makeText(MainActivity.this, "SUCCESS= "+ b, Toast.LENGTH_SHORT).show();

            }
        });


    }
}
