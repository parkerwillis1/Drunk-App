package edu.utsa.cs3443.drunkappfinal.Controller;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import edu.utsa.cs3443.drunkappfinal.CalculatorActivity;
import edu.utsa.cs3443.drunkappfinal.QuestionActivity;

public class MainController implements View.OnClickListener
{
    /**
     * variables
     */
    private Activity activity;
    private static String key = "zone";

    /**
     * MainController constructor
     * @param activity
     */
    public MainController(Activity activity)
    {
        this.activity = activity;
    }

    /**
     * action for when a button is clicked
     * @param view
     */
    @Override
    public void onClick(View view)
    {
        Button clickedButton = (Button) view;

        if(clickedButton.getText().toString().equals("Take Quiz"))
        {
            Intent intent = new Intent(activity, QuestionActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            activity.startActivity(intent);
        }
        if(clickedButton.getText().toString().equals("Drink Calculator"))
        {
            Intent intent = new Intent(activity, CalculatorActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            activity.startActivity(intent);
        }
    }
}