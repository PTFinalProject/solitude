package com.example.plattechfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class breathing_exercise_calming extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breathing_exercise_calming);

        final Button nextButton = (Button) findViewById(R.id.nextButton);
        final Button startButton = (Button) findViewById(R.id.startBreathingBtn);
        final ImageView imageView = findViewById(R.id.breathingImgGuide);
        final TextView txtGuide = findViewById(R.id.guideText);
        final Integer[] animationCount = {0};

        ObjectAnimator scaleDown = ObjectAnimator.ofPropertyValuesHolder(imageView,
                PropertyValuesHolder.ofFloat("scaleX", 0.5f),
                PropertyValuesHolder.ofFloat("scaleY", 0.5f));
        scaleDown.setDuration(4000);

        ObjectAnimator scaleUp = ObjectAnimator.ofPropertyValuesHolder(imageView,
                PropertyValuesHolder.ofFloat("scaleX", 1f),
                PropertyValuesHolder.ofFloat("scaleY", 1f));
        scaleUp.setDuration(3000);

        ValueAnimator valAnim = ValueAnimator.ofFloat(0f, 11f);
        valAnim.setDuration(11000);
        valAnim.setRepeatCount(ValueAnimator.INFINITE);
        valAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = (float) animation.getAnimatedValue();
                if (value <= 4) {
                    txtGuide.setText("Exhale");
                } else if (value > 4 && value <= 7) {
                    txtGuide.setText("Inhale");
                } else if (value > 7) {
                    txtGuide.setText("Hold");
                    animationCount[0]++;
                }
            }
        });

        final AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(scaleDown).before(scaleUp);

        ObjectAnimator delay = ObjectAnimator.ofFloat(imageView,"alpha", 1f, 1f);
        delay.setDuration(11000);
        animatorSet.playTogether(delay);

        animatorSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                animatorSet.start();
            }
        });

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valAnim.start();
                animatorSet.start();
            }
        });
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent actChange = new Intent(breathing_exercise_calming.this, stretching1.class);

                startActivity(actChange);
            }
        });


    }
}