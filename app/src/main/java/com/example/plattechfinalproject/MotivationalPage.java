package com.example.plattechfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MotivationalPage extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    private int currentQuoteIndex;
    private final String[] quotes = {"“Don’t let yesterday take up too much of today.”",
            "“You learn more from failure than from success. Don’t let it stop you. Failure builds character.”",
            "\"It is better to fail in originality than to succeed in imitation.\"",
            "\"The road to success and the road to failure are almost exactly the same.\"",
            "“Success is getting what you want, happiness is wanting what you get.”"};

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.motivational_page);

        final ImageView btnNext = findViewById(R.id.btnNext);
        final ImageView btnPrevious = findViewById(R.id.btnPrevious);
        final TextView myTextView = findViewById(R.id.textQuotes);

        currentQuoteIndex = new Random().nextInt(quotes.length);
        myTextView.setText(quotes[currentQuoteIndex]);
        Log.d("MyApp", "Initial quote: " + quotes[currentQuoteIndex]);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentQuoteIndex = (currentQuoteIndex + 1) % quotes.length;
                myTextView.setText(quotes[currentQuoteIndex]);
                Log.d("MyApp", "Next quote: " + quotes[currentQuoteIndex]);
            }
        });

        btnPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentQuoteIndex = (currentQuoteIndex - 1 + quotes.length) % quotes.length;
                myTextView.setText(quotes[currentQuoteIndex]);
                Log.d("MyApp", "Previous quote: " + quotes[currentQuoteIndex]);
            }
        });

        Button btnContinue2 = findViewById(R.id.btnContinue2);
        btnContinue2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create a new Intent to start the MotivationalPage activity
                Intent intent = new Intent(MotivationalPage.this, hotlinePage.class);
                startActivity(intent);
            }
        });

//      Code for playing audio
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.meditatemusic);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();
    }

    @Override
    public void onPause() {
        super.onPause();
        mediaPlayer.pause();
    }

    @Override
    public void onResume() {
        super.onResume();
        mediaPlayer.start();
    }
}
