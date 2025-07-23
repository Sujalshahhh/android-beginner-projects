package com.example.studentmarksheet;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText nameEditText, rollNoEditText, scienceEditText, mathsEditText, englishEditText;
    private TextView resultTextView;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the views
        nameEditText = findViewById(R.id.name);
        rollNoEditText = findViewById(R.id.rollno);
        scienceEditText = findViewById(R.id.sci);
        mathsEditText = findViewById(R.id.maths);
        englishEditText = findViewById(R.id.eng);
        submitButton = findViewById(R.id.submitbutton);
        resultTextView = findViewById(R.id.resulttextview);

        // Set a click listener for the submit button
        submitButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                // Get the input values
                String name = nameEditText.getText().toString().trim();
                String rollNo = rollNoEditText.getText().toString().trim();
                String scienceMarks = scienceEditText.getText().toString().trim();
                String mathsMarks = mathsEditText.getText().toString().trim();
                String englishMarks = englishEditText.getText().toString().trim();

                // Validate input fields
                if (name.isEmpty() || rollNo.isEmpty() || scienceMarks.isEmpty() || mathsMarks.isEmpty() || englishMarks.isEmpty()) {
                    resultTextView.setText(""); // Clear previous results
                    Toast.makeText(MainActivity.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Parse numeric fields
                double scienceMarksValue, mathsMarksValue, englishMarksValue;
                try {
                    scienceMarksValue = Double.parseDouble(scienceMarks);
                    mathsMarksValue = Double.parseDouble(mathsMarks);
                    englishMarksValue = Double.parseDouble(englishMarks);
                } catch (NumberFormatException e) {
                    resultTextView.setText(""); // Clear previous results
                    Toast.makeText(MainActivity.this, "Please enter valid numeric marks", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Calculate total marks and percentage
                double totalMarks = scienceMarksValue + mathsMarksValue + englishMarksValue;
                double percentage = (totalMarks / 300.0) * 100;

                // Display the marks and percentage in the TextView
                resultTextView.setText(
                        "Name: " + name + "\n" +
                                "Roll No: " + rollNo + "\n" +
                                "Science: " + scienceMarks + "\n" +
                                "Maths: " + mathsMarks + "\n" +
                                "English: " + englishMarks + "\n" +
                                "Total Marks: " + totalMarks + "\n" +
                                "Percentage: " + percentage + "%"
                );
            }
        });
    }
}
