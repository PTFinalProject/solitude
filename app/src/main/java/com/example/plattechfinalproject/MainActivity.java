package com.example.plattechfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.landing_page);

        // Find the Button in your layout file and set an OnClickListener
        btnStart = findViewById(R.id.btnStart);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create a new Intent to start the MotivationalPage activity
                Intent intent = new Intent(MainActivity.this, MotivationalPage.class);
                startActivity(intent);
            }
        });
    }
}