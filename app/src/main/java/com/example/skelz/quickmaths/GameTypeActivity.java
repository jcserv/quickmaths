package com.example.skelz.quickmaths;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;

public class GameTypeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_type);
    }

    public void addButtonClick(View v) {
        Intent i = new Intent(getApplicationContext(), GameScreen.class);
        i.putExtra("mode", 1);
        startActivity(i);
    }

    public void subButtonClick(View v) {
        Intent i = new Intent(getApplicationContext(), GameScreen.class);
        i.putExtra("mode", 2);
        startActivity(i);
    }

    public void multButtonClick(View v) {
        Intent i = new Intent(getApplicationContext(), GameScreen.class);
        i.putExtra("mode", 3);
        startActivity(i);
    }

    public void divButtonClick(View v) {
        Intent i = new Intent(getApplicationContext(), GameScreen.class);
        i.putExtra("mode", 4);
        startActivity(i);
    }
    public void randomButtonClick(View v) {
        Intent i = new Intent(getApplicationContext(), GameScreen.class);
        i.putExtra("mode", 5);
        startActivity(i);
    }
}
