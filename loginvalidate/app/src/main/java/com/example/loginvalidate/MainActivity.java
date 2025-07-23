package com.example.loginvalidate;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etEmail, etPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);

        // Initially disable the login button
        btnLogin.setEnabled(false);
        btnLogin.setBackgroundTintList(getResources().getColorStateList(android.R.color.darker_gray));

        etEmail.addTextChangedListener(textWatcher);
        etPassword.addTextChangedListener(textWatcher);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateCredentials();
            }
        });
    }

    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            toggleLoginButton();
        }

        @Override
        public void afterTextChanged(Editable s) { }
    };

    private void toggleLoginButton() {
        String emailInput = etEmail.getText().toString().trim();
        String passwordInput = etPassword.getText().toString().trim();

        // Check if both email and password are valid
        boolean isValid = isValidEmail(emailInput) && passwordInput.length() >= 6;

        // Enable or disable the login button based on validation
        if (isValid) {
            btnLogin.setEnabled(true);
            btnLogin.setBackgroundTintList(getResources().getColorStateList(android.R.color.holo_blue_dark));
        } else {
            btnLogin.setEnabled(false);
            btnLogin.setBackgroundTintList(getResources().getColorStateList(android.R.color.darker_gray));
        }
    }

    private void validateCredentials() {
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        // Predefined valid username and password for demonstration
        String validUsername = "test@example.com";
        String validPassword = "password123";

        if (!email.equals(validUsername)) {
            Toast.makeText(MainActivity.this, "Username is wrong", Toast.LENGTH_SHORT).show();
        } else if (!password.equals(validPassword)) {
            Toast.makeText(MainActivity.this, "Password is wrong", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, "Login Successful!", Toast.LENGTH_SHORT).show();
            btnLogin.setText("Success!");
            btnLogin.setBackgroundTintList(getResources().getColorStateList(android.R.color.holo_green_dark));
        }
    }

    private boolean isValidEmail(CharSequence email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}
