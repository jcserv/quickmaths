package org.granvilla.skelz.quickmaths;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.skelz.quickmaths.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class GameScreen extends AppCompatActivity {
//    private int answerIndex = 0;
    private boolean random = false;
    private int minRange = 1;
    private int difficulty = 1;
    private String correctAnswer = "0";
    private int maxRange = 10;
    private int turn = 0;
    private Integer gameMode = 1;
    private ArrayList<String> answers = new ArrayList<>();
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);

        gameMode = getIntent().getIntExtra("mode", 1);
        difficulty = getIntent().getIntExtra("difficulty", 1);
        random = getIntent().getBooleanExtra("random", false);

        setRanges();
        StartGame();
    }

    private void StartGame() {
        if(random) {
            gameMode = getRandomInRange(1,4);
            switch (gameMode) {
                case 1:
                case 2:
                    setRanges();
                    break;
                case 3:
                case 4:
                    setRanges();
                    break;
            }
        }
        int operand1 = getRandomInRange(minRange, maxRange);
        int operand2 = getRandomInRange(minRange, maxRange);
        switch (gameMode) {
            case 1:
            case 2:
                createAnswersAddSub(operand1, operand2);
                break;
            case 3:
            case 4:
                createAnswersMulDiv(operand1, operand2);
                break;
            default:
                createAnswersAddSub(operand1, operand2);
                break;
        }

        Button display = findViewById(R.id.answerButton1);
        display.setText(answers.get(0));
        display = findViewById(R.id.answerButton2);
        display.setText(answers.get(1));
        display = findViewById(R.id.answerButton3);
        display.setText(answers.get(2));
        display = findViewById(R.id.answerButton4);
        display.setText(answers.get(3));

        TextView question = findViewById(R.id.expressionDisplay);

        switch (gameMode) {
            case 1:
                question.setText(Integer.toString(operand1) + " + " + Integer.toString(operand2));
                break;
            case 2:
                question.setText(Integer.toString(operand1) + " - " + Integer.toString(operand2));
                break;
            case 3:
                question.setText(Integer.toString(operand1) + " × " + Integer.toString(operand2));
                break;
            case 4:
                question.setText(Integer.toString(operand1) + " / " + Integer.toString(operand2));
                break;
            default:
                question.setText(Integer.toString(operand1) + " + " + Integer.toString(operand2));
                break;
        }

    }

    private void createAnswersAddSub(int operand1, int operand2) {

        answers.clear();

        switch (gameMode) {
            case 1:
                answers.add(Integer.toString(operand1 + operand2));
                break;
            case 2:
                answers.add(Integer.toString(operand1 - operand2));
                break;
            default:
                answers.add("0");
                break;
        }
        correctAnswer = answers.get(0);

        for (int i = 1; i < 4; i++) {
            answers.add(Integer.toString(getRandomInRange(-10, 10) + Integer.parseInt(answers.get(0))));

            for (int j = 0; j < i; j++) {//remove and get new number if already part of answers.
                if (answers.get(j).equals(answers.get(i))) {
                    answers.remove(i);
                    i--;
                    break;
                }
            }
        }
        Collections.shuffle(answers);
    }

    private void createAnswersMulDiv(int operand1, int operand2) {

        answers.clear();
        switch (gameMode) {
            case 3:
                answers.add(Integer.toString(operand1 * operand2));
                answers.add(Integer.toString((operand1 - 1) * operand2));
                answers.add(Integer.toString(operand1 * (operand2 + 1)));
                answers.add(Integer.toString((operand1 - 1) * (operand2 + 1)));
                break;
            case 4:
                answers.add(Integer.toString(operand1 / operand2) + " R " + Integer.toString(operand1 % operand2));
                answers.add(Integer.toString((operand1 - 2) / operand2) + " R " + Integer.toString((operand1 - 2) % operand2));
                answers.add(Integer.toString(operand1 / (operand2 + 1)) + " R " + Integer.toString(operand1 % (operand2 + 1)));
                answers.add(Integer.toString((operand1 - 2) / (operand2 + 1)) + " R " + Integer.toString((operand1 - 2) % (operand2 + 1)));
                break;
            default:
                break;
        }
        correctAnswer = answers.get(0);
        Collections.shuffle(answers);
    }

    public static int getRandomInRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("Max must be greater than min");
        }
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public void answerButtonClick(View v) {
        Button buttonPressed = (Button) v;
        turn++;
        if(buttonPressed.getText().equals(correctAnswer)){
            score++;
        }

        if(turn < 10) {
            StartGame();
        }
        else{
            Intent i = new Intent(getApplicationContext(), ResultsScreen.class);
            i.putExtra("score", score);
            startActivity(i);
            finish();
        }
    }

    public void setRanges() {
        switch(gameMode) {
            case 1:
            case 2:
                switch(difficulty){
                    case 1:
                        minRange = 1;
                        maxRange = 15;
                        break;
                    case 2:
                        minRange = 15;
                        maxRange = 30;
                        break;
                    case 3:
                        minRange = 30;
                        maxRange = 50;
                        break;
                }
                break;
            case 3:
            case 4:
                switch(difficulty){
                    case 1:
                        minRange = 1;
                        maxRange = 10;
                        break;
                    case 2:
                        minRange = 3;
                        maxRange = 12;
                        break;
                    case 3:
                        minRange = 3;
                        maxRange = 15;
                        break;
                }
                break;
        }
    }

    @Override
    public void onBackPressed(){}//disables back button.
}