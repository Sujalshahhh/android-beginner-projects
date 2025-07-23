package com.example.registrationformq5;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editName, editAge, editCourse;
    private Button btnSubmit;
    private TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        editName = findViewById(R.id.editName);
        editAge = findViewById(R.id.editAge);
        editCourse = findViewById(R.id.editCourse);
        btnSubmit = findViewById(R.id.btnSubmit);
        txtResult = findViewById(R.id.txtResult);

        // Set onClickListener for the button
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get input values
                String name = editName.getText().toString();
                String age = editAge.getText().toString();
                String course = editCourse.getText().toString();

                // Display the result
                String result = "Student Information:\n" +
                        "Name: " + name + "\n" +
                        "Age: " + age + "\n" +
                        "Course: " + course;

                txtResult.setText(result);
            }
        });
    }
}
