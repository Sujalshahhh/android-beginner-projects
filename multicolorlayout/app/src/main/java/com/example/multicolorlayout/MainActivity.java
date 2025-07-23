package com.example.multicolorlayout;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private View layout; // Reference to the layout
    private Button buttonRed, buttonGreen, buttonBlue, buttonRainbow1, buttonRainbow2, buttonClean; // Buttons for colors

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize layout and buttons
        layout = findViewById(R.id.mainLayout);
        buttonRed = findViewById(R.id.buttonRed);
        buttonGreen = findViewById(R.id.buttonGreen);
        buttonBlue = findViewById(R.id.buttonBlue);
        buttonRainbow1 = findViewById(R.id.buttonRainbow1);
        buttonClean = findViewById(R.id.buttonClean);

        // Set listeners for each button
        buttonRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout.setBackgroundColor(Color.RED);
                buttonRed.setTextColor(Color.RED);
            }
        });

        buttonGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout.setBackgroundColor(Color.GREEN);
                buttonGreen.setTextColor(Color.GREEN);
            }
        });

        buttonBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout.setBackgroundColor(Color.BLUE);
                buttonBlue.setTextColor(Color.BLUE);
            }
        });

        buttonRainbow1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setRainbowBackground();
                buttonRainbow1.setTextColor(Color.MAGENTA);
            }
        });
        buttonClean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout.setBackgroundColor(Color.WHITE); // Reset to white
                resetButtonTextColors(); // Reset all button text colors to default
            }
        });
    }

    // Method to set rainbow gradient as background
    private void setRainbowBackground() {
        GradientDrawable rainbow = new GradientDrawable(
                GradientDrawable.Orientation.LEFT_RIGHT,
                new int[]{Color.RED, Color.YELLOW, Color.GREEN, Color.BLUE});
        layout.setBackground(rainbow);
    }

    // Method to reset all button text colors to default
    private void resetButtonTextColors() {
        buttonRed.setTextColor(Color.BLACK);
        buttonGreen.setTextColor(Color.BLACK);
        buttonBlue.setTextColor(Color.BLACK);
        buttonRainbow1.setTextColor(Color.BLACK);
        buttonClean.setTextColor(Color.BLACK);
    }
}
