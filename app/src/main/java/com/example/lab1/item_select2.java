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

public class item_select2 extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {
        Button mainpage;
        Button quit;

        private Question_db_CEH questions_db_CEH = new Question_db_CEH();
        private TextView questionsView_CEH;
        private Button buttonChoice1_CEH;
        private Button buttonChoice2_CEH;
        private Button buttonChoice3_CEH;
        private Button buttonChoice4_CEH;

        private String answer_CEH;
        private int penalty;
        TextView display1;
        TextView display2;

    private int questionNumber_CEH;


        @Override
        protected void onCreate (Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_item_select2);
            display1=findViewById(R.id.display);
            display2=findViewById(R.id.display2);


            questionsView_CEH= (TextView)findViewById(R.id.question_CEH);
            buttonChoice1_CEH= (Button)findViewById(R.id.choice1_CEH);
            buttonChoice2_CEH= (Button)findViewById(R.id.choice2_CEH);
            buttonChoice3_CEH= (Button)findViewById(R.id.choice3_CEH);
            buttonChoice4_CEH= (Button)findViewById(R.id.choice4_CEH);

            updateQuestion_CEH();

            mainpage = findViewById(R.id.mainpage);
            quit = findViewById(R.id.quit);

            buttonChoice1_CEH.setOnClickListener(this);
            buttonChoice2_CEH.setOnClickListener(this);
            buttonChoice3_CEH.setOnClickListener(this);
            buttonChoice4_CEH.setOnClickListener(this);

            onClick(questionsView_CEH);
            mainpage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent= new Intent(item_select2.this, MainActivity.class);
                    startActivity(intent);
                }
            });

            quit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent= new Intent(item_select2.this, Splash.class);
                    startActivity(intent);
                }
            });
        }

    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.choice1_CEH:
                if (buttonChoice1_CEH.getText()!=answer_CEH){
                    Toast.makeText(this,"wrong", Toast.LENGTH_SHORT).show();
                    penalty++;
                    updateQuestion_CEH();
                }
                else{
                    Toast.makeText(this,"Correct", Toast.LENGTH_SHORT).show();
                    updateQuestion_CEH();
                }
                break;
            case R.id.choice2_CEH:
                if (buttonChoice2_CEH.getText()!=answer_CEH){
                    penalty++;
                    Toast.makeText(this,"wrong", Toast.LENGTH_SHORT).show();
                    updateQuestion_CEH();
                }
                else{
                    Toast.makeText(this,"Correct", Toast.LENGTH_SHORT).show();
                    updateQuestion_CEH();

                }
                break;

            case R.id.choice3_CEH:
                if (buttonChoice3_CEH.getText()!=answer_CEH){
                    penalty++;
                    Toast.makeText(this,"wrong", Toast.LENGTH_SHORT).show();
                    updateQuestion_CEH();
                }
                else{
                    Toast.makeText(this,"Correct", Toast.LENGTH_SHORT).show();
                    updateQuestion_CEH();

                }
                break;
            case R.id.choice4_CEH:
                if (buttonChoice4_CEH.getText()!=answer_CEH){
                    penalty++;
                    Toast.makeText(this,"wrong", Toast.LENGTH_SHORT).show();
                    updateQuestion_CEH();
                }
                else{
                    Toast.makeText(this,"Correct", Toast.LENGTH_SHORT).show();
                    updateQuestion_CEH();
                }
                break;
        }
    }



    private void updateQuestion_CEH(){
            if (editText1> questionNumber_CEH) {

                questionsView_CEH.setText(questions_db_CEH.getQuestion_CEH(questionNumber_CEH));
                buttonChoice1_CEH.setText(questions_db_CEH.getChoice1_CEH(questionNumber_CEH));
                buttonChoice2_CEH.setText(questions_db_CEH.getChoice2_CEH(questionNumber_CEH));
                buttonChoice3_CEH.setText(questions_db_CEH.getChoice3_CEH(questionNumber_CEH));
                buttonChoice4_CEH.setText(questions_db_CEH.getChoice4_CEH(questionNumber_CEH));
                answer_CEH = questions_db_CEH.getAnswer_CEH(questionNumber_CEH);
                questionNumber_CEH++;
                display1.setText("Question "+questionNumber_CEH+ " of "+editText1);
                display2.setText("Passing grade : "+editText2);
            }
            else{
                Intent intent = new Intent(item_select2.this, Summary.class);
                if ((getScore_CEH()*100)/editText1>=editText2)
                {

                    intent.putExtra("msg", "You have obtained " + getScore_CEH() + "/" + editText1 + ". " + ((questionNumber_CEH - penalty) * 100) / editText1 + "%! You have passed the exam.");
                    startActivity(intent);
                }
                else {
                    intent.putExtra("msg", "You have obtained " + getScore_CEH()  + "/" + editText1+ ". " + ((questionNumber_CEH - penalty) * 100) / editText1 + "%! You failed the exam.");
                    startActivity(intent);
                }
            }

        }

    public int getScore_CEH(){
        int result= questionNumber_CEH - penalty;
        return result;
    }

    @Override

    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),text, Toast.LENGTH_SHORT).show();

        if (parent.getItemAtPosition(position).equals("Quit"))
        {
            Intent intent = new Intent(item_select2.this, Summary.class);
            startActivity(intent);
        }

        else if (parent.getItemAtPosition(position).equals("Main Page"))
        {
            Intent intent = new Intent(item_select2.this, MainActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}



