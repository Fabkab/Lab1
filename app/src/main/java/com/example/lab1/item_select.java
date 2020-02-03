package com.example.lab1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.lab1.MainActivity.editText1;
import static com.example.lab1.MainActivity.editText2;


public class item_select extends AppCompatActivity implements AdapterView.OnItemSelectedListener,View.OnClickListener {
    Button quit;
    Button mainpage;


    private Questions_db questions_db = new Questions_db();
    private Settings settings = new Settings();
    private TextView questionsView;
    private Button buttonChoice1;
    private Button buttonChoice2;
    private Button buttonChoice3;
    private Button buttonChoice4;

    private String answer;
    private int penalty;
    private int questionNumber;

    TextView display1;
    TextView display2;


    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_select);


        display1=findViewById(R.id.display);
        display2=findViewById(R.id.display2);


        questionsView= (TextView)findViewById(R.id.question);
        buttonChoice1= (Button)findViewById(R.id.choice1);
        buttonChoice2= (Button)findViewById(R.id.choice2);
        buttonChoice3= (Button)findViewById(R.id.choice3);
        buttonChoice4= (Button)findViewById(R.id.choice4);

        updateQuestion();

        quit = findViewById(R.id.quit);
        mainpage= findViewById(R.id.mainpage);

        buttonChoice1.setOnClickListener(this);
        buttonChoice2.setOnClickListener(this);
        buttonChoice3.setOnClickListener(this);
        buttonChoice4.setOnClickListener(this);

        onClick(questionsView);


        mainpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(item_select.this, MainActivity.class);
                startActivity(intent);
            }

        });

        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(item_select.this, Splash.class);

                startActivity(intent);
                finish();
                System.exit(0);
            }

        });

    }

    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.choice1:
                //do something
                if (buttonChoice1.getText()!=answer){
                    Toast.makeText(this,"wrong", Toast.LENGTH_SHORT).show();
                    penalty++;
                    updateQuestion();
                }
                else{
                    Toast.makeText(this,"Correct", Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
                break;
            case R.id.choice2:
                //do something
                if (buttonChoice2.getText()!=answer){
                    penalty++;
                    Toast.makeText(this,"wrong", Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
                else{
                    Toast.makeText(this,"Correct", Toast.LENGTH_SHORT).show();
                    updateQuestion();

                }
                break;

            case R.id.choice3:
                //do something
                if (buttonChoice3.getText()!=answer){
                    penalty++;
                    Toast.makeText(this,"wrong", Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
                else{
                    Toast.makeText(this,"Correct", Toast.LENGTH_SHORT).show();
                    updateQuestion();

                }
                break;
            case R.id.choice4:
                //do something
                if (buttonChoice4.getText()!=answer){
                    penalty++;
                    Toast.makeText(this,"wrong", Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
                else{
                    Toast.makeText(this,"Correct", Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
                break;
        }
    }

    private void updateQuestion(){

        if (editText1> questionNumber) {
            questionsView.setText(questions_db.getQuestion(questionNumber));
            buttonChoice1.setText(questions_db.getChoice1(questionNumber));
            buttonChoice2.setText(questions_db.getChoice2(questionNumber));
            buttonChoice3.setText(questions_db.getChoice3(questionNumber));
            buttonChoice4.setText(questions_db.getChoice4(questionNumber));
            answer = questions_db.getAnswer(questionNumber);
            questionNumber++;
            display1.setText("Question "+questionNumber+" of "+editText1);
            display2.setText("Passing grade: "+editText2);

        }
        else{
            Toast.makeText(item_select.this,"correct", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(item_select.this, Summary.class);

            if ((getScore()*100)/editText1>=editText2)
            {

                intent.putExtra("msg", "You have obtained " + getScore() + "/" + editText1+ ". " + ((questionNumber - penalty) * 100) / editText1 + "%! You have passed the exam.");
                startActivity(intent);
            }
            else {
                intent.putExtra("msg", "You have obtained " +getScore()+ "/" + editText1 + ". " + ((questionNumber - penalty) * 100) / editText1 + "%! You failed the exam.");
                startActivity(intent);
            }
        }
    }

    public int getScore(){
        int result= questionNumber - penalty;
        return result;
    }

    @Override

    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),text, Toast.LENGTH_SHORT).show();

        if (parent.getItemAtPosition(position).equals("Quit"))
        {
            Intent intent = new Intent(item_select.this, Summary.class);
            startActivity(intent);
        }

        else if (parent.getItemAtPosition(position).equals("Main Page"))
        {
            Intent intent = new Intent(item_select.this, MainActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


}
