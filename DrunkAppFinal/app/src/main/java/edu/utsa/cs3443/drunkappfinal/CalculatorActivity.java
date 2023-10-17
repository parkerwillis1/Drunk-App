/**
 *  @author Robert-Anthony Tellez (ece282)
 *  UTSA CS 3443 - Group Project
 *  Spring 2023
 *  CalculatorActivity.java
 *  class that handles app initial startup of the BAC Calculator
 */

package edu.utsa.cs3443.drunkappfinal;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import edu.utsa.cs3443.drunkappfinal.Controller.CalculatorController;

public class CalculatorActivity extends AppCompatActivity
{
    /**
     * variables
     */
    private CalculatorController controller;

    /**
     * Creates an instance of the BAC Calculator
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        //sets up layout
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        controller = new CalculatorController(this);

        //sets up buttons and Edittexts
        int[] buttonIDs = {R.id.button};
        for(int i = 0; i < buttonIDs.length; i++)
        {
            setupButton(buttonIDs[i]);
        }
        EditText weight = (EditText) findViewById(R.id.editTextWeight);
        EditText sex = (EditText) findViewById(R.id.editTextSex);
        EditText hours = (EditText) findViewById(R.id.editTextHours);
        EditText drink = (EditText) findViewById(R.id.editTextDrinkType);
        EditText number = (EditText) findViewById(R.id.editTextNumberDrinks);
    }

    /**
     * sets up a button
     * @param buttonID
     */
    private void setupButton(int buttonID)
    {
        Button button = findViewById(buttonID);
        button.setOnClickListener(controller);
    }
}