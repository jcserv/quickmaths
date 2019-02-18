package com.example.skelz.quickmaths;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DifficultyScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficulty_screen);

        Integer mode = getIntent().getIntExtra("mode", 0);
        TextView display = (TextView)findViewById(R.id.textView);
        display.setText(mode.toString());
    }
}
