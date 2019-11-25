package com.example.studentpresence;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    EditText email_reg;
    EditText password1;
    EditText password2;
    Button register;

    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        email_reg = findViewById(R.id.input_email_reg);
        password1 = findViewById(R.id.input_password_reg1);
        password2 = findViewById(R.id.input_password_reg2);
        register = findViewById(R.id.register_button);

        firebaseAuth = firebaseAuth.getInstance();

        register.setOnClickListener(new View.OnClickListener() { // On click function initiating the account registration.
            @Override
            public void onClick(View view) {
                if (email_reg.getText().length() > 0 && password1.getText().length() > 0 && password2.getText().length() > 0) { // Length Checker
                    if (password1.getText().toString().equals(password2.getText().toString())) { // Check if Passwords match.
                        firebaseAuth.createUserWithEmailAndPassword(email_reg.getText().toString(), password1.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) { // Call a firebase function to create an account.
                                if (task.isSuccessful()) {
                                    Toast.makeText(RegisterActivity.this, " Successfully Registered.", Toast.LENGTH_LONG).show();
                                } else {
                                    Toast.makeText(RegisterActivity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show(); // Exception message will be returned by Firebase in case of an error.
                                }
                            }
                        });
                    } else {
                        Toast.makeText(RegisterActivity.this, "Passwords do not match.", Toast.LENGTH_LONG).show();
                    }
                }
                else {
                    Toast.makeText(RegisterActivity.this, "Please fill in all fields.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
