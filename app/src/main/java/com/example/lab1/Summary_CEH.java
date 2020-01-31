package com.example.lab1;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Summary_CEH extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private TextView scoreView_CEH;


    Button mainpage;
    Button quit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary_ceh);

        scoreView_CEH=(TextView)findViewById(R.id.score2);
        Intent item_select_Intent2=getIntent();
        String message = item_select_Intent2.getStringExtra("msg");
        scoreView_CEH.setText(message);
        scoreView_CEH.setGravity(Gravity.CENTER_VERTICAL);


        mainpage = findViewById(R.id.mainpage2);
        quit = findViewById(R.id.quit2);


        mainpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Summary_CEH.this, MainActivity.class);
                startActivity(intent);
            }

        });

        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Summary_CEH.this, MainActivity.class);
                startActivity(intent);
            }

        });


    }

    @Override

    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),text, Toast.LENGTH_SHORT).show();

        if (parent.getItemAtPosition(position).equals("Main Page"))
        {
            Intent intent = new Intent(Summary_CEH.this, MainActivity.class);
            startActivity(intent);
        }

        else if (parent.getItemAtPosition(position).equals("Quit"))
        {
            Intent intent = new Intent(Summary_CEH.this, MainActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}


