package com.example.plattechfinalproject;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Stretching2 extends AppCompatActivity {

    private Button btnContinue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stretching2);

        // Initializing the textView
        TextView textView = findViewById(R.id.timerTextView);

        // Initializing the btnContinue
        btnContinue = findViewById(R.id.btnContinue);
        btnContinue.setVisibility(View.GONE); // hide the button initially

        new CountDownTimer(31000, 1000) {
            public void onTick(long millisUntilFinished) {
                // Used for formatting digit to be in 2 digits only
                NumberFormat f = new DecimalFormat("00");
                long min = (millisUntilFinished / 60000) % 60;
                long sec = (millisUntilFinished / 1000) % 60;
                textView.setText(f.format(min) + ":" + f.format(sec));
            }
            // When the task is over it will print 00:00:00 there
            public void onFinish() {
                textView.setText("00:00");
                btnContinue.setVisibility(View.VISIBLE); // show the button when timer finishes
            }
        }.start();

    }
}
