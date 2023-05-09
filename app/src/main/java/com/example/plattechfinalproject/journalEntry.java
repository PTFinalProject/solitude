package com.example.plattechfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class journalEntry extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journal_entry);

        final Button contButton = findViewById(R.id.contBtnJourn);
        final EditText journalEntry = findViewById(R.id.journalEntryText);
        final TextView journalTitle = findViewById(R.id.journalTitle);
        String editTextContent = journalEntry.getText().toString();

        contButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent actChange =new Intent(journalEntry.this, ReadyPage.class);

                startActivity(actChange);
            }
        });

    }
}