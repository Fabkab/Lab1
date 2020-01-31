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
    public static final  String NUMBER2="com.example.lab1";

    private  Questions_db questions_db= new Questions_db();
    private  Question_db_CEH questions_db_CEH= new Question_db_CEH();

    Button btnSubmit;
    EditText number_of_questions;
    EditText passing_grade;


    TextView result;
    TextView txtView;


    Button mainpage;
    Button quit;
    int editText1;
    int editText2;
    Handler setDelay;
    Runnable startDelay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        setDelay=new Handler();
        Intent item_select_Intent=getIntent();
        //String message = item_select_Intent.getStringExtra("msg");

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
                } else {

                            editText1=Integer.parseInt(number_of_questions.getText().toString());
                            editText2= Integer.parseInt(passing_grade.getText().toString());

                            result.setText("Number of questions -  " + editText1 + " \n" + "Passing grade -  " + editText2);
                            txtView.setText("User sets the number of questions to "+ editText1+ " and the passing grade to "+ editText2+ "%");

                    startDelay = new Runnable(){

                        @Override
                        public void run() {
                            editText1=Integer.parseInt(number_of_questions.getText().toString());
                            editText2= Integer.parseInt(passing_grade.getText().toString());
                            Intent intent = new Intent(Settings.this, Settings.class);
                            //Settings.this, Settings.class

                            intent.putExtra(NUMBER1,editText1);
                            intent.putExtra(NUMBER2,editText2);

                            startActivity(intent);
                        }
                        };
                    setDelay.postDelayed(startDelay, 5000);
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

      /*  quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Settings.this, MainActivity.class);
                startActivity(intent);
            }

        }); */


    }
    public String getQuestion_number(){

        return number_of_questions.getText().toString();
    }
    public String getPassing_grade(){
        return passing_grade.getText().toString();
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

