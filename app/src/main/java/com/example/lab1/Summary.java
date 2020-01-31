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

public class Summary extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private item_select item1 = new item_select();
    private TextView scoreView;
    Button mainpage;
    Button quit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        Intent item_select_Intent=getIntent();
        String message = item_select_Intent.getStringExtra("msg");
        scoreView=(TextView)findViewById(R.id.score);
        scoreView.setText(message);
        scoreView.setGravity(Gravity.CENTER_VERTICAL);

        mainpage = findViewById(R.id.mainpage);
        quit = findViewById(R.id.quit);


        mainpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Summary.this, MainActivity.class);
                startActivity(intent);
            }

        });

        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Summary.this, MainActivity.class);
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
            Intent intent = new Intent(Summary.this, MainActivity.class);
            startActivity(intent);
        }

        else if (parent.getItemAtPosition(position).equals("Quit"))
        {
            Intent intent = new Intent(Summary.this, MainActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}


