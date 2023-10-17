package edu.utsa.cs3443.drunkappfinal;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import edu.utsa.cs3443.drunkappfinal.Controller.ResultController;
import edu.utsa.cs3443.drunkappfinal.Controller.QuestionController;

public class ResultActivity extends AppCompatActivity
{

    private ResultController controller;

    private Button homeButton;
    private Button calcButton;
    private TextView score;
    private TextView quip;
    private TextView quote;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        homeButton = findViewById(R.id.homeButton);
        calcButton = findViewById(R.id.calcButton);
        score = findViewById(R.id.score);
        quip = findViewById(R.id.quip);
        quote = findViewById(R.id.quote);

        Intent intent = getIntent();
        int quizScore = intent.getIntExtra("score", 0);


        controller = new ResultController(this);
        score.setText("You got " + quizScore + " questions right!");
        homeButton.setOnClickListener(controller);
        calcButton.setOnClickListener(controller);

        controller.updateText(quizScore);
    }
}
