package edu.utsa.cs3443.drunkappfinal.Controller;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import edu.utsa.cs3443.drunkappfinal.CalculatorActivity;
import edu.utsa.cs3443.drunkappfinal.MainActivity;
import edu.utsa.cs3443.drunkappfinal.Model.Question;
import edu.utsa.cs3443.drunkappfinal.ResultActivity;

public class ResultController implements View.OnClickListener {
    private final ResultActivity activity;

    public ResultController(ResultActivity activity) {
        this.activity = activity;
    }

    public void onClick(View view) {
        Button clickedButton = (Button) view;
        Intent intent;
        if (clickedButton.getText().toString().equals("Home")) {
            intent = new Intent(activity, MainActivity.class);
        } else {
            intent = new Intent(activity, CalculatorActivity.class);

        }
        activity.startActivity(intent);
    }

    public void updateText(int quizScore) {
        InputStream in;
        Scanner scan = null;
        String filename = "Quotes.csv";
        ArrayList<String> quotes = new ArrayList<>();

        try {
            in = activity.getAssets().open(filename);
            scan = new Scanner(in);
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                quotes.add(line);
            }
            in.close();
            scan.close();

            int index = new Random().nextInt(quotes.size());
            int quoteViewId = activity.getResources().getIdentifier("quote", "id", activity.getPackageName());
            TextView quoteView = activity.findViewById(quoteViewId);
            quoteView.setText(quotes.get(index));

        }catch (IOException e){
            throw new RuntimeException(e);
        }

        int quipViewId = activity.getResources().getIdentifier("quip", "id", activity.getPackageName());
        TextView quipView = activity.findViewById(quipViewId);
        if(quizScore <= 2){
            quipView.setText("Bartender, cut this person off!");
        }
        else if(quizScore <= 5) {
            quipView.setText("You gave it your best shot (from the bottom shelf)");
        }
        else if(quizScore <= 8){
            quipView.setText("Not bad, the night must be young!");
        }
        else{
            quipView.setText("Show off.");
        }
    }
}
