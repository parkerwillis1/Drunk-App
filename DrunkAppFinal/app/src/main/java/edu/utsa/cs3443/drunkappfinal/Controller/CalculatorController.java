/**
 *  @author Robert-Anthony Tellez (ece282)
 *  UTSA CS 3443 - Group Project
 *  Spring 2023
 *  CalculatorController.java
 *  class that handles app actions of the BAC Calculator
 */

package edu.utsa.cs3443.drunkappfinal.Controller;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import edu.utsa.cs3443.drunkappfinal.Model.Calculate;
import edu.utsa.cs3443.drunkappfinal.R;

public class CalculatorController implements View.OnClickListener
{
    /**
     * variables
     */
    private Activity activity;
    private static String weight;
    private static String sex;
    private static String hours;
    private static String drink;

    /**
     * CalculatorController constructor
     * @param activity
     */
    public CalculatorController(Activity activity)
    {
        this.activity = activity;
    }

    /**
     * action for when a button is clicked
     * @param view
     */
    public void onClick(View view)
    {
        Button clickedButton = (Button) view;

        if(clickedButton.getText().toString().equals("Calculate"))
        {
            EditText weight = (EditText) activity.findViewById(R.id.editTextWeight);
            EditText sex = (EditText) activity.findViewById(R.id.editTextSex);
            EditText number = (EditText) activity.findViewById(R.id.editTextNumberDrinks);
            EditText drink = (EditText) activity.findViewById(R.id.editTextDrinkType);
            EditText hours = (EditText) activity.findViewById(R.id.editTextHours);
            double x = 0;
            int y = 0;
            x = Calculate.calculate(weight.getText().toString(), sex.getText().toString(),
                    hours.getText().toString(), drink.getText().toString(), number.getText().toString());
            y = Calculate.legalLimit(x);
            if(x != 0)
            {
                Toast.makeText(view.getContext(), "Your BAC is " + x, Toast.LENGTH_LONG).show();
                if(y == 1)
                {
                    Toast.makeText(view.getContext(), "It is illegal to drive in Texas. ", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(view.getContext(), "It is legal to drive in Texas. ", Toast.LENGTH_LONG).show();
                }

            }else
            {
                Toast.makeText(view.getContext(), "Error: invalid information entered", Toast.LENGTH_LONG).show();
            }
        }
    }
}