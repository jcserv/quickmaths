package com.example.skelz.quickmaths;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

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
        setRanges(i, 1, 15, 1, 10);
        startActivity(i);
    }

    public void mediumButtonClick(View v) {
        Intent i = new Intent(getApplicationContext(), DifficultyScreen.class);
        i.putExtra("mode", mode);
        setRanges(i, 15, 30, 7, 12);
        startActivity(i);
    }

    public void hardButtonClick(View v) {
        Intent i = new Intent(getApplicationContext(), DifficultyScreen.class);
        i.putExtra("mode", mode);
        setRanges(i, 30, 50,7, 15);
        startActivity(i);
    }

    public void setRanges(Intent i, int addSubLower, int addSubUpper, int multDivLower, int multDivUpper) {
        switch(mode) {
            case 1:
            case 2:
                i.putExtra("minRange", addSubLower);
                i.putExtra("maxRange", addSubUpper);
                break;
            case 3:
            case 4:
                i.putExtra("minRange", multDivLower);
                i.putExtra("maxRange", multDivUpper);
                break;

        }
    }
}
