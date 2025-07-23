package com.example.togglebuttonq12;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.ToggleButton;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // on below line we are creating a variable.
    private ToggleButton toggleBtn;
    private TextView statusTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // on below line we are initializing our variables.
        toggleBtn = findViewById(R.id.idBtnToggle);
        statusTV = findViewById(R.id.idTVStatus);

        // on below line we are setting text view by
        // checking toggle button status.
        if (toggleBtn.isChecked()) {
            // if button is checked we are setting
            // text as Toggle Button is On
            statusTV.setText("Toggle Button is On");
        } else {
            // if button is unchecked we are setting
            // text as Toggle Button is Off
            statusTV.setText("Toggle Button is Off");
        }

        // on below line we are adding click listener for our toggle button
        toggleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // on below line we are checking if
                // toggle button is checked or not.
                if (toggleBtn.isChecked()) {
                    // on below line we are setting message
                    // for status text view if toggle button is checked.
                    statusTV.setText("Toggle Button is On");
                } else {
                    // on below line we are setting message for
                    // status text view if toggle button is un checked.
                    statusTV.setText("Toggle Button is Off");
                }
            }
        });

    }
}