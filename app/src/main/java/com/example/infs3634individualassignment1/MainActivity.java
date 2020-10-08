package com.example.infs3634individualassignment1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //Define Max Number
    public static final int MAX_NUMBER = 100;
    //Random Number Generator
    public static final Random RANDOM = new Random();

    //Define Variables
    private TextView msgTv;
    private EditText inputtedNumber;
    private Button check;
    private int solution;
    private int numberOfGuesses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        msgTv = (TextView) findViewById(R.id.msg);
        inputtedNumber = (EditText) findViewById(R.id.inputtedNumber);
        //Checker When Clicked for Validation Button
        check = (Button) findViewById(R.id.check);
        check.setOnClickListener(this);
        //Start New Game Method
        newGame();
    }
    @Override
    public void onClick(View view) {
        //onClick Method for when the User Clicks the Check Button
        if (view == check) {
            check();
        }
    }
    private void check() {
        //n = The Number the User Inputs
        int n = Integer.parseInt(inputtedNumber.getText().toString());
        //Number of Guesses
        numberOfGuesses++;

        //Results if Code is Guessed Within 5 Attempts - Long Toasts are Used to Improve UI and UX (Long = 3.5s, which is more user-friendly compared to short's 2s display)
        if (n == solution) {
            Toast.makeText(this, "Congratulations! You Guessed The Correct Number Of " + solution , Toast.LENGTH_LONG).show();
            newGame();
        } else if (n > solution) {
            msgTv.setText(R.string.high);
        } else if (n < solution) {
            msgTv.setText(R.string.low);
        }
        //Result if User Runs Out of Guesses
        if (numberOfGuesses == 5) {
            Toast.makeText(this, "Out of Guesses! The Correct Solution Was " + solution, Toast.LENGTH_LONG).show();
            newGame();

        }
    }
    //Starting a New game
    private void newGame() {
        solution = RANDOM.nextInt(MAX_NUMBER);
        msgTv.setText(R.string.title);
        inputtedNumber.setText("");
     //Resetting Number of Guesses
        numberOfGuesses = 0;
    }
}