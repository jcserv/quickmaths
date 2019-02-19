package com.example.skelz.quickmaths;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DifficultyScreen extends AppCompatActivity {

    int mode = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficulty_screen);

        mode = getIntent().getIntExtra("mode", 1);
    }

    public void easyButtonClick(View v) {
        Intent i = new Intent(getApplicationContext(), DifficultyScreen.class);
        i.putExtra("mode", mode);
        i.putExtra("minRange", 1);
        i.putExtra("maxRange", 10);
        startActivity(i);
    }

    public void mediumButtonClick(View v) {
        Intent i = new Intent(getApplicationContext(), DifficultyScreen.class);
        i.putExtra("mode", mode);
        i.putExtra("minRange", 10);
        i.putExtra("maxRange", 20);
        startActivity(i);
    }

    public void hardButtonClick(View v) {
        Intent i = new Intent(getApplicationContext(), DifficultyScreen.class);
        i.putExtra("mode", mode);
        i.putExtra("minRange", 20);
        i.putExtra("maxRange", 30);
        startActivity(i);
    }
}
