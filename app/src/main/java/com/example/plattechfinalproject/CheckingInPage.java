package com.example.plattechfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class CheckingInPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checking_in_page);

        final ImageButton happyBtn = findViewById(R.id.happyBtn);
        final ImageButton neutralBtn = findViewById(R.id.neutralBtn);
        final ImageButton sadBtn = findViewById(R.id.sadBtn);

        happyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent happyChange = new Intent(CheckingInPage.this, ReadyPage.class);

                startActivity(happyChange);
            }
        });

        neutralBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent neutralChange = new Intent(CheckingInPage.this, memes.class);

                startActivity(neutralChange);
            }
        });

        sadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent sadChange = new Intent(CheckingInPage.this, journalEntry.class);

                startActivity(sadChange);
            }
        });
    }
}