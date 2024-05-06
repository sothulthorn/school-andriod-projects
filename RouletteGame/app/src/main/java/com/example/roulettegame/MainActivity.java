package com.example.roulettegame;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView iv_roulette;
    float startDegree = 0f;
    float endDegree = 0f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv_roulette = (ImageView) findViewById(R.id.roulette);
    }

    public void rotate(View v) {
        startDegree = endDegree;

        Random rand = new Random();
        int degree_rand = rand.nextInt(360);
        float endDegree = startDegree + 360 * 3 + degree_rand;

        ObjectAnimator object = ObjectAnimator.ofFloat(iv_roulette, "rotation", startDegree, endDegree);
        object.setInterpolator(new AccelerateInterpolator());
        object.setDuration(5000);
        object.start();
    }
}