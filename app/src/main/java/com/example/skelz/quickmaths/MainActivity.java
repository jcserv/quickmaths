package com.example.skelz.quickmaths;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int lower;
    private int upper;
    private int mode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int x = getRandomInRange(lower, upper);
        int y = getRandomInRange(lower, upper);
    }

    public static int getRandomInRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("Max must be greater than min");
        }
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }


}
