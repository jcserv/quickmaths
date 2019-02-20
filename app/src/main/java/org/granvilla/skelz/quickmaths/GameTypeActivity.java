package org.granvilla.skelz.quickmaths;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.skelz.quickmaths.R;

public class GameTypeActivity extends AppCompatActivity {
    AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_type);
    }

    public void addButtonClick(View v) {
        Intent i = new Intent(getApplicationContext(), DifficultyScreen.class);
        i.putExtra("mode", 1);
        startActivity(i);
    }

    public void subButtonClick(View v) {
        Intent i = new Intent(getApplicationContext(), DifficultyScreen.class);
        i.putExtra("mode", 2);
        i.putExtra("random", false);
        startActivity(i);
    }

    public void multButtonClick(View v) {
        Intent i = new Intent(getApplicationContext(), DifficultyScreen.class);
        i.putExtra("mode", 3);
        i.putExtra("random", false);
        startActivity(i);
    }

    public void divButtonClick(View v) {
        Intent i = new Intent(getApplicationContext(), DifficultyScreen.class);
        i.putExtra("mode", 4);
        i.putExtra("random", false);
        startActivity(i);
    }
    public void randomButtonClick(View v) {
        Intent i = new Intent(getApplicationContext(), DifficultyScreen.class);
        i.putExtra("mode", 1);
        i.putExtra("random", true);
        startActivity(i);
    }

    public void creditsButtonClick(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(GameTypeActivity.this);
        View mView = getLayoutInflater().inflate(R.layout.credits_dialog, null);
        builder.setView(mView);
        dialog = builder.create();
        dialog.show();
        dialog.getWindow().setLayout(1000, 800);
    }

    public void dismissButtonClick(View v) {
        dialog.hide();
    }

    @Override
    public void onBackPressed(){moveTaskToBack(true);}//disables back button.
}
