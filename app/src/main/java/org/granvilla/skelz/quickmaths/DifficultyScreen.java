package org.granvilla.skelz.quickmaths;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.skelz.quickmaths.R;

public class DifficultyScreen extends AppCompatActivity {

    int mode = 0;
    boolean random = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficulty_screen);
        mode = getIntent().getIntExtra("mode", 1);
        random = getIntent().getBooleanExtra("random",false);
    }

    public void easyButtonClick(View v) {
        Intent i = new Intent(getApplicationContext(), GameScreen.class);
        i.putExtra("mode", mode);
        i.putExtra("random", random);
        i.putExtra("difficulty", 1);
        startActivity(i);
        finish();
    }

    public void mediumButtonClick(View v) {
        Intent i = new Intent(getApplicationContext(), GameScreen.class);
        i.putExtra("mode", mode);
        i.putExtra("random", random);
        i.putExtra("difficulty", 2);
        startActivity(i);
        finish();
    }

    public void hardButtonClick(View v) {
        Intent i = new Intent(getApplicationContext(), GameScreen.class);
        i.putExtra("mode", mode);
        i.putExtra("random", random);
        i.putExtra("difficulty", 3);
        startActivity(i);
        finish();
    }
}
