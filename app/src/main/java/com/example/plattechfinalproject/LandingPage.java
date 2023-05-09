package com.example.plattechfinalproject;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class LandingPage extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.landing_page);

        final Button start = findViewById(R.id.btnStart);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LandingPage.this, CheckingInPage.class);
                startActivity(intent);
            }
        });

        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.meditatemusic);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();

    }
    @Override
    protected void onPause() {
        super.onPause();
        mediaPlayer.pause();
    }
    @Override
    public void onResume() {
        super.onResume();
        mediaPlayer.start();
    }
}
