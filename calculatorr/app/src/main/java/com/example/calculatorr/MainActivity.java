package com.example.calculatorr;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.calculatorr.R;

public class MainActivity extends AppCompatActivity {

    private EditText number1, number2;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number1 = findViewById(R.id.number1);
        number2 = findViewById(R.id.number2);
        result = findViewById(R.id.result);

        Button addButton = findViewById(R.id.addButton);
        Button subtractButton = findViewById(R.id.subtractButton);
        Button multiplyButton = findViewById(R.id.multiplyButton);
        Button divideButton = findViewById(R.id.divideButton);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation('+');
            }
        });

        subtractButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation('-');
            }
        });

        multiplyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation('*');
            }
        });

        divideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation('/');
            }
        });
    }

    @SuppressLint("SetTextI18n")
    private void performOperation(char operation) {
        double num1 = Double.parseDouble(number1.getText().toString());
        double num2 = Double.parseDouble(number2.getText().toString());
        double resultValue = 0;

        switch (operation) {
            case '+':
                resultValue = num1 + num2;
                break;
            case '-':
                resultValue = num1 - num2;
                break;
            case '*':
                resultValue = num1 * num2;
                break;
            case '/':
                if (num2 != 0) {
                    resultValue = num1 / num2;
                } else {
                    result.setText("Error: Division by zero");
                    return;
                }
                break;
        }
        result.setText(String.valueOf(resultValue));
    }
}
