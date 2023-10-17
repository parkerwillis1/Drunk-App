package edu.utsa.cs3443.drunkappfinal.Controller;

import android.content.Context;

import edu.utsa.cs3443.drunkappfinal.Model.Question;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuestionController {

    private Context context;
    private List<Question> questions;
    private int currentIndex;
    private int score;

    public QuestionController(Context context) {
        this.context = context;
        questions = new ArrayList<>();
        currentIndex = 0;
        score = 0;
        readQuestionsFromCsv();
        Collections.shuffle(questions);
    }

    public List<Question> readQuestionsFromCsv() {
        InputStream inputStream = null;

        try {
            inputStream = context.getAssets().open("Questions.csv");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] tokens = line.split(",");
                if (tokens.length < 6) {
                    continue; // Ignore malformed lines
                }

                String questionText = tokens[0];
                String[] options = new String[]{tokens[1], tokens[2], tokens[3], tokens[4]};
                String correctAnswer = tokens[5];
                questions.add(new Question(questionText, options, correctAnswer));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return questions;
    }

    public boolean moveToNextQuestion() {
        if (currentIndex + 1 < questions.size()) {
            currentIndex++;
            return true;
        }
        return false;
    }

    public Question getCurrentQuestion() {
        return questions.get(currentIndex);
    }

    public void incrementScore() {
        score++;
    }

    public int getScore() {
        return score;
    }
}