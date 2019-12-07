package com.example.studentpresence;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    FirebaseAuth mAuth;
    EditText email;
    EditText password;
    Button login_button;

    String checkNum;
    String checkFirst;
    String checkLast;
    String savedEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
        email = findViewById(R.id.input_email);
        password = findViewById(R.id.input_password);
        login_button = findViewById(R.id.login_button);

        login_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Sign in using the Firebase Method "signInWithEmailAndPassword after turning the Email and Password into strings.
                if (email.getText().length() > 0 && password.getText().length() > 0) {
                    mAuth.signInWithEmailAndPassword(email.getText().toString(), password.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override // Sign in with Firebase method.
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) { // If Sign In is successful, show confirmation to user and go to scanner screen.
                                Toast.makeText(MainActivity.this, "Login successful.", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(MainActivity.this,qractivity.class);startActivity(intent);
                            } else { Toast.makeText(MainActivity.this, "Authentication failed.", Toast.LENGTH_SHORT).show(); } //If Sign In fails, show to user. No action.
                        }
                    });
                }
                else { Toast.makeText(MainActivity.this, "Please fill in both fields.", Toast.LENGTH_SHORT).show(); }
            } // End of onClick
        });

        //Register
        Button registerbutton = findViewById(R.id.register_redirect_button);
        registerbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}
