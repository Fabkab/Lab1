package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static com.example.lab1.Settings.NUMBER1;
import static com.example.lab1.Settings.NUMBER2;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Button settings;
    TextView display1;
    TextView display2;
    public static int editText1 = 5;
    public static double editText2 =75;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        display1=findViewById(R.id.txtview);
        display2=findViewById(R.id.txtview2);

        Intent intent= getIntent();
        Bundle extras= intent.getExtras();


        if (extras !=null){


            editText1= extras.getInt(NUMBER1);
            editText2=extras.getDouble(NUMBER2);
            display1.setText("Number of questions "+editText1);
            display2.setText("Passing grade "+editText2);
        }

        Spinner spinner =findViewById(R.id.spinner1);


        settings= findViewById(R.id.settings);

        settings.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Settings.class);
                startActivity(intent);

            }

        });


        List<String> certifications = new ArrayList<>();
        certifications.add(0, "Select");
        certifications.add("OCSF");
        certifications.add("CEH");
        //Style and populate
        ArrayAdapter<String> dataAdapter;
        dataAdapter= new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, certifications);

        //Dropdown layout style
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),text, Toast.LENGTH_SHORT).show();

        if (parent.getItemAtPosition(position).equals("OCSF"))
        {
            Intent intent = new Intent(MainActivity.this, item_select.class);
            intent.putExtra(NUMBER1, editText1);
            intent.putExtra(NUMBER2, editText2);
            startActivity(intent);
        }

        else if (parent.getItemAtPosition(position).equals("CEH"))
        {
            Intent intent = new Intent(MainActivity.this, item_select2.class);
            startActivity(intent);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}
