package edu.utsa.cs3443.drunkappfinal;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import edu.utsa.cs3443.drunkappfinal.R;
import edu.utsa.cs3443.drunkappfinal.Controller.QuestionController;
import edu.utsa.cs3443.drunkappfinal.Model.Question;

public class QuestionActivity extends AppCompatActivity {
    private TextView questionTextView;
    private RadioGroup radioGroup;
    private RadioButton optionA, optionB, optionC, optionD;

    private QuestionController questionController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        questionController = new QuestionController(this);

        questionTextView = findViewById(R.id.question_text_view);
        radioGroup = findViewById(R.id.radio_group);
        optionA = findViewById(R.id.option_a);
        optionB = findViewById(R.id.option_b);
        optionC = findViewById(R.id.option_c);
        optionD = findViewById(R.id.option_d);

        displayQuestion();

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // Unregister the listener to avoid triggering it when clearing the check state
                radioGroup.setOnCheckedChangeListener(null);

                RadioButton selectedOption = findViewById(checkedId);
                String selectedAnswer = selectedOption.getText().toString();
                Question currentQuestion = questionController.getCurrentQuestion();

                if (selectedAnswer.equals(currentQuestion.getCorrectAnswer())) {
                    questionController.incrementScore();
                }

                if (questionController.moveToNextQuestion()) {
                    displayQuestion();
                } else {
                    // Handle the end of the quiz, show results or navigate to another activity
                    Intent intent = new Intent(QuestionActivity.this, ResultActivity.class);
                    intent.putExtra("score", questionController.getScore());
                    startActivity(intent);
                    finish();
                }

                radioGroup.clearCheck();

                // Register the listener again
                radioGroup.setOnCheckedChangeListener(this);
            }
        });
    }

    private void displayQuestion() {
        Question currentQuestion = questionController.getCurrentQuestion();
        questionTextView.setText(currentQuestion.getQuestion());

        String[] options = currentQuestion.getOptions();
        optionA.setText(options[0]);
        optionB.setText(options[1]);
        optionC.setText(options[2]);
        optionD.setText(options[3]);
    }
}