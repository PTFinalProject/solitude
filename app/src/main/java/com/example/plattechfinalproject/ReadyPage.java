package com.example.plattechfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ReadyPage extends AppCompatActivity {

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ready_page);

        final Button nextBtn = findViewById(R.id.nextCtnRdyPg);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent actChange = new Intent(ReadyPage.this, breathing_exercise_calming.class);

                startActivity(actChange);
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