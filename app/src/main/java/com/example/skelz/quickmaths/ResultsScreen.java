package com.example.skelz.quickmaths;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class ResultsScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results_screen);

        int score = getIntent().getIntExtra("score", 0);

        TextView display = findViewById(R.id.scoreDisplay);
        display.setText(String.format(Locale.getDefault(), "%d%s", score, getString(R.string.scoreString)));

        display = findViewById(R.id.messageDisplay);

        if(score<5) display.setText(getString(R.string.completionMessage1));
        else if(score < 8){display.setText(getString(R.string.completionMessage2));}
        else if(score < 10){display.setText(getString(R.string.completionMessage3));}
        else {display.setText(getString(R.string.completionMessage4));}
    }

    public void finishButtonClick (View v){
        finish();
    }

}
