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

public class Culture_Quiz extends Activity {

    int total = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.culture_quiz);
    }

    private int checkAnswers() {
        /*
          finds the answer for question 1 and if it's the right one adds it to total
         */
        EditText q1EditText = findViewById(R.id.answer_question_one_culture_quiz);
        String q1 = q1EditText.getText().toString().trim().toUpperCase();

        String b = "Bucharest".toUpperCase();

        if (q1.equals(b)) {
            total++;
        }


        /*
          finds the answer for question 2 and if it's the right one adds it to total
         */
        RadioButton q2a1RadioButton = findViewById(R.id.answer_one_question_two_culture_quiz);
        Boolean q2a1 = q2a1RadioButton.isChecked();

        RadioButton q2a2RadioButton = findViewById(R.id.answer_two_question_two_culture_quiz);
        Boolean q2a2 = q2a2RadioButton.isChecked();

        RadioButton q2a3RadioButton = findViewById(R.id.answer_three_question_two_culture_quiz);
        Boolean q2a3 = q2a3RadioButton.isChecked();

        if (!q2a1 && q2a2 && !q2a3) {
            total++;
        }

        /*
          finds the answer for question 3 and if it's the right one adds it to total
         */
        CheckBox q3a1CheckBox = findViewById(R.id.answer_one_question_three_culture_quiz);
        Boolean q3a1 = q3a1CheckBox.isChecked();

        CheckBox q3a2CheckBox = findViewById(R.id.answer_two_question_three_culture_quiz);
        Boolean q3a2 = q3a2CheckBox.isChecked();

        CheckBox q3a3RadioButton = findViewById(R.id.answer_three_question_three_culture_quiz);
        Boolean q3a3 = q3a3RadioButton.isChecked();

        if (q3a1 && q3a2 && q3a3) {
            total++;
        }
        return total;
    }

    /**
     * it opens the pop up to see the results
     */
    public void seeAnswerSportsQuiz(View v) {
        Button b = findViewById(R.id.culture_button);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Culture_Quiz.this, Pop_Culture.class));
            }
        });

        /*
            passes the data to the view I need: pop fashion
         */
        Intent passDataCultureQuiz = new Intent(Culture_Quiz.this, Pop_Culture.class);
        passDataCultureQuiz.putExtra("answer", checkAnswers());
        startActivity(passDataCultureQuiz);
    }
}