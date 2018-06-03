package com.example.marry.quiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

/**
 * Created by Mary on 03/28/2018.
 */

public class Fashion_Quiz extends Activity {

    private int total = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fashion_quiz);

    }

    private int checkAnswers() {
        /*
          finds the answer for question 1 and if it's the right one adds it to total
         */
        RadioButton q1a1radioButton = findViewById(R.id.answer_one_question_one_fashion_quiz);
        Boolean q1a1 = q1a1radioButton.isChecked();
        RadioButton q1a2radioButton = findViewById(R.id.answer_two_question_one_fashion_quiz);
        Boolean q1a2 = q1a2radioButton.isChecked();
        RadioButton q1a3radioButton = findViewById(R.id.answer_three_question_one_fashion_quiz);
        Boolean q1a3 = q1a3radioButton.isChecked();

        if (q1a1 && !q1a2 && !q1a3) {
            total++;
        }


        /*
          finds the answer for question 2 and if it's the right one adds it to total
         */
        EditText q2EditText = findViewById(R.id.answer_question_two_fashion_quiz);
        String q2 = q2EditText.getText().toString().trim().toUpperCase();
        String p = "Handbags".toUpperCase();
        String p1 = "Handbag".toUpperCase();
        String p2 = "Purses".toUpperCase();
        String p3 = "Purse".toUpperCase();

        if (q2.equals(p) || q2.equals(p1) || q2.equals(p2) || q2.equals(p3)) {
            total++;
        }

        /*
          finds the answer for question 3 and if it's the right one adds it to total
         */
        RadioButton q3a1radioButton = findViewById(R.id.answer_one_question_three_fashion_quiz);
        Boolean q3a1 = q3a1radioButton.isChecked();

        RadioButton q3a2radioButton = findViewById(R.id.answer_two_question_three_fashion_quiz);
        Boolean q3a2 = q3a2radioButton.isChecked();

        RadioButton q3a3radioButton = findViewById(R.id.answer_three_question_three_fashion_quiz);
        Boolean q3a3 = q3a3radioButton.isChecked();

        if (q3a1 && !q3a2 && !q3a3) {
            total++;
        }
        return total;
    }

    /**
     * it opens the pop up to see the results
     */
    public void seeAnswerFashionQuiz(View v) {
        Button b = findViewById(R.id.fashion_button);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Fashion_Quiz.this, Pop_Fashion.class));
            }
        });

        /*
            passes the data to the view I need: pop fashion
         */
        Intent passDataFashionQuiz = new Intent(this, Pop_Fashion.class);
        passDataFashionQuiz.putExtra("answer", checkAnswers());
        startActivity(passDataFashionQuiz);
    }
}