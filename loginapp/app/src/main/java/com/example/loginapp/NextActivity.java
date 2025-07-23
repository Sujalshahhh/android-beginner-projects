package com.example.loginapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class NextActivity extends AppCompatActivity {

    TextView welcomeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        welcomeTextView = findViewById(R.id.welcomeTextView);

        // Get the username passed from MainActivity
        Intent intent = getIntent();
        String username = intent.getStringExtra("username");

        // Display the welcome message with the username
        if (username != null) {
            welcomeTextView.setText("Welcome, " + username + "!");
        }
    }
}
