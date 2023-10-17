package edu.utsa.cs3443.drunkappfinal;

import androidx.appcompat.app.AppCompatActivity;
import edu.utsa.cs3443.drunkappfinal.Controller.MainController;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{

    /**
     * declaring variables
     */
    private MainController controller;

    /**
     * creates an instance of MainActivity
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int[] buttonIDs = {R.id.button2, R.id.button3};

        controller = new MainController(this);

        for(int i = 0; i < buttonIDs.length; i++)
        {
            setupButton(buttonIDs[i]);
        }
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

    /**
     * Restarts the activity
     */
    @Override
    protected void onRestart() {
        super.onRestart();
    }
}