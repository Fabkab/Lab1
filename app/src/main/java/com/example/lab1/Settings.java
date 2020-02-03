package com.example.lab1;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.renderscript.Sampler;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Settings extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    public static final  String NUMBER1= "com.example.lab1";
    public static final  String NUMBER2="com.example.lab1_";

    private  Questions_db questions_db= new Questions_db();
    Button btnSubmit;
    EditText number_of_questions;
    EditText passing_grade;


    TextView result;
    TextView txtView;

    Button mainpage;
    Button quit;
    int editText1;
    double editText2;
    Handler setDelay;
    Runnable startDelay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        setDelay=new Handler();

        number_of_questions=(EditText)findViewById(R.id.number_of_questions);
        passing_grade = (EditText)findViewById(R.id.passing_grade);

        btnSubmit = (Button)findViewById(R.id.btnSend);
        result = (TextView)findViewById(R.id.resultView);
        txtView = (TextView)findViewById(R.id.txtView);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (number_of_questions.getText().toString().isEmpty() || passing_grade.getText().toString().isEmpty() ) {
                    result.setText("Please Fill All the Details");
                }

                else if(Integer.parseInt(number_of_questions.getText().toString())>questions_db.getLength()) {
                    result.setText("Invalid number of questions. Please Fill question number atleast from 1 up to " + questions_db.getLength());

                }
                else if(Double.parseDouble(passing_grade.getText().toString())>100 || Double.parseDouble(passing_grade.getText().toString())<=1) {
                    result.setText("Invalid passing grade. Please Fill passing grade atleast from 1% up to 100% ");
                }
                    else
                 {

                            editText1=Integer.parseInt(number_of_questions.getText().toString());
                            editText2= Double.parseDouble(passing_grade.getText().toString());

                            result.setText("Number of questions is  " + editText1 + " \n" + "Passing grade is  " + editText2);
                            txtView.setText("User sets the number of questions to "+ editText1+ " and the passing grade to "+ editText2+ "%");

                    startDelay = new Runnable(){

                        @Override
                        public void run() {
                            Intent intent = new Intent(Settings.this, MainActivity.class);
                            intent.putExtra(NUMBER1, editText1);
                            intent.putExtra(NUMBER2, editText2);

                            startActivity(intent);
                        }
                        };
                    setDelay.postDelayed(startDelay, 2000);
                    }
            }
        });

        mainpage = findViewById(R.id.mainpage);
        quit = findViewById(R.id.quit);

        mainpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Settings.this, MainActivity.class);
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
            Intent intent = new Intent(Settings.this, MainActivity.class);
            startActivity(intent);
        }

        else if (parent.getItemAtPosition(position).equals("Quit"))
        {
            Intent intent = new Intent(Settings.this, MainActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

