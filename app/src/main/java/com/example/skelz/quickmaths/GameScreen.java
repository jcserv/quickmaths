package com.example.skelz.quickmaths;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import java.util.Random;

public class GameScreen extends AppCompatActivity {
    private int answerIndex = 0;
    private ArrayList<String> answers;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);

        Integer gameMode = getIntent().getIntExtra("mode", 1);
        int maxRange = 10;
        int lowerRange = 1;

        StartGame(lowerRange, maxRange, gameMode);

    }

    private void StartGame(int minRange, int maxRange, int gameMode) {
        int operand1 = getRandomInRange(minRange, maxRange);
        int operand2 = getRandomInRange(minRange, maxRange);

        switch (gameMode) {
            case 1:
            case 2:
                answers = createAnswersAddSub(gameMode, minRange, maxRange, operand1, operand2);
                break;
            case 3:
            case 4:
                answers = createAnswersMulDiv(gameMode, minRange, maxRange, operand1, operand2);
                break;
            default:
                answers = createAnswersAddSub(gameMode, minRange, maxRange, operand1, operand2);
                break;
        }

        Button display = (Button) findViewById(R.id.answerButton1);
        display.setText(answers.get(0));
        display = (Button) findViewById(R.id.answerButton2);
        display.setText(answers.get(1));
        display = (Button) findViewById(R.id.answerButton3);
        display.setText(answers.get(2));
        display = (Button) findViewById(R.id.answerButton4);
        display.setText(answers.get(3));

        TextView question = (TextView) findViewById(R.id.expressionDisplay);

        switch (gameMode) {
            case 1:
                question.setText(Integer.toString(operand1) + "+" + Integer.toString(operand2));
                break;
            case 2:
                question.setText(Integer.toString(operand1) + "-" + Integer.toString(operand2));
                break;
            case 3:
                question.setText(Integer.toString(operand1) + "×" + Integer.toString(operand2));
                break;
            case 4:
                question.setText(Integer.toString(operand1) + "/" + Integer.toString(operand2));
                break;
            default:
                question.setText(Integer.toString(operand1) + "+" + Integer.toString(operand2));
                break;
        }
    }

    private ArrayList<String> createAnswersAddSub(Integer mode, int minRange, int maxRange, int operand1, int operand2) {

        ArrayList<String> answers = new ArrayList<>();
        String answer;

        switch (mode) {
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
        answer = answers.get(0);

        for (int i = 1; i < 4; i++) {
            answers.add(Integer.toString(getRandomInRange(minRange, maxRange) + Integer.parseInt(answers.get(0))));

            for (int j = 0; j < i; j++) {
                if (answers.get(j) == answers.get(i)) {
                    i--;
                    break;
                }
            }
        }

        return shuffle(answers, answer);
    }

    private ArrayList<String> shuffle(ArrayList<String> answers, String answer) {

        Collections.shuffle(answers);

        for (int k = 0; k < 3; k++) {
            if (answers.get(k) == answer) {
                answerIndex = k;
                break;
            }
        }
        return answers;
    }

    private ArrayList<String> createAnswersMulDiv(Integer mode, int minRange, int maxRange, int operand1, int operand2) {
        ArrayList<String> answers = new ArrayList<>();
        String answer = "0";
        switch (mode) {
            case 3:
                answers.add(Integer.toString(operand1 * operand2));
                answers.add(Integer.toString((operand1 - 1) * operand2));
                answers.add(Integer.toString(operand1 * (operand2 + 1)));
                answers.add(Integer.toString((operand1 - 1) * (operand2 + 1)));
                break;
            case 4:
                answers.add(Integer.toString(operand1 / operand2) + " R " + Integer.toString(operand1 % operand2));
                answers.add(Integer.toString((operand1 - 1) / operand2) + " R " + Integer.toString((operand1 - 1) % operand2));
                answers.add(Integer.toString(operand1 / (operand2 + 1)) + " R " + Integer.toString(operand1 % (operand2 + 1)));
                answers.add(Integer.toString((operand1 - 1) / (operand2 + 1)) + " R " + Integer.toString((operand1 - 1) % (operand2 + 1)));
                break;
            default:
                break;
        }
        answer = answers.get(0);
        return shuffle(answers, answer);
    }

    public static int getRandomInRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("Max must be greater than min");
        }
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
