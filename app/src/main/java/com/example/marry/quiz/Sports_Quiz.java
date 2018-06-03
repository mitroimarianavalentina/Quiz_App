package com.example.marry.quiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

/**
 * Created by Mary on 03/28/2018.
 */

public class Sports_Quiz extends Activity {

    int total = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sports_quiz);
    }

    private int checkAnswers() {
        /*
          finds the answer for question 3 and if it's the right one adds it to total
         */
        RadioButton q1a1RadioButton = findViewById(R.id.answer_one_question_one_sports_quiz);
        Boolean q1a1 = q1a1RadioButton.isChecked();

        RadioButton q1a2RadioButton = findViewById(R.id.answer_two_question_one_sports_quiz);
        Boolean q1a2 = q1a2RadioButton.isChecked();

        RadioButton q1a3RadioButton = findViewById(R.id.answer_three_question_one_sports_quiz);
        Boolean q1a3 = q1a3RadioButton.isChecked();

        if (!q1a1 && !q1a2 && q1a3) {
            total++;
        }

        /*
          finds the answer for question 3 and if it's the right one adds it to total
         */
        EditText q2EditText = findViewById(R.id.answer_question_two_sports_quiz);
        String q2 = q2EditText.getText().toString().trim().toUpperCase();

        String n = "34";
        String n1 = "Thirty Four".toUpperCase();


        if (q2.equals(n) || q2.equals(n1)) {
            total++;
        }

        /*
          finds the answer for question 3 and if it's the right one adds it to total
         */
        CheckBox q3a1CheckBox = findViewById(R.id.answer_one_question_three_sports_quiz);
        Boolean q3a1 = q3a1CheckBox.isChecked();

        CheckBox q3a2CheckBox = findViewById(R.id.answer_two_question_three_sports_quiz);
        Boolean q3a2 = q3a2CheckBox.isChecked();

        CheckBox q3a3CheckBox = findViewById(R.id.answer_three_question_three_sports_quiz);
        Boolean q3a3 = q3a3CheckBox.isChecked();

        if (q3a1 && q3a2 && !q3a3) {
            total++;
        }

        /*
          finds the answer for question 3 and if it's the right one adds it to total
         */
        RadioButton q4a1RadioButton = findViewById(R.id.answer_one_question_four_sports_quiz);
        Boolean q4a1 = q4a1RadioButton.isChecked();

        RadioButton q4a2RadioButton = findViewById(R.id.answer_two_question_four_sports_quiz);
        Boolean q4a2 = q4a2RadioButton.isChecked();

        RadioButton q4a3RadioButton = findViewById(R.id.answer_three_question_four_sports_quiz);
        Boolean q4a3 = q4a3RadioButton.isChecked();

        if (q4a1 && !q4a2 && !q4a3) {
            total++;
        }
        return total;
    }

    /**
     * it opens the pop up to see the results
     */
    public void seeAnswerSportsQuiz(View v) {
        Button b = findViewById(R.id.sports_button);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Sports_Quiz.this, Pop_Sports.class));
            }
        });

        /*
            passes the data to the view I need: pop fashion
         */
        Intent passDataSportsQuiz = new Intent(Sports_Quiz.this, Pop_Sports.class);
        passDataSportsQuiz.putExtra("answer", checkAnswers());
        startActivity(passDataSportsQuiz);
    }
}