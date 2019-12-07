package com.example.studentpresence;


import android.content.Intent;
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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {

    EditText email_reg;
    EditText password1;
    EditText password2;
    EditText studentNum;
    EditText firstName;
    EditText lastName;
    Button register;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        email_reg = findViewById(R.id.input_email_reg);
        password1 = findViewById(R.id.input_password_reg1);
        password2 = findViewById(R.id.input_password_reg2);
        studentNum = findViewById(R.id.studentNum);
        firstName = findViewById(R.id.firstName);
        lastName = findViewById(R.id.lastName);
        register = findViewById(R.id.register_button);

        mAuth = mAuth.getInstance();

        register.setOnClickListener(new View.OnClickListener() { // On click function initiating the account registration.
            @Override
            public void onClick(View view) {
                if (email_reg.getText().length() > 0 && password1.getText().length() > 0 && password2.getText().length() > 0 && studentNum.getText().length() > 0 && firstName.getText().length() > 0 && lastName.getText().length() > 0) { // Length Checker to see if every field has been filled in.
                    if (password1.getText().toString().equals(password2.getText().toString())) { // Check if Passwords match.
                        mAuth.createUserWithEmailAndPassword(email_reg.getText().toString(), password1.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) { // Call a firebase function to create an account.
                                if (task.isSuccessful()) {
                                    Toast.makeText(RegisterActivity.this, " Successfully Registered.", Toast.LENGTH_LONG).show();
                                    FirebaseDatabase database = FirebaseDatabase.getInstance(); // If the Firebase function runs succesfully, enter following values into database.
                                    DatabaseReference myRef = database.getReference(mAuth.getUid());
                                    String student_id = studentNum.getText().toString();
                                    UserProfile User = new UserProfile();
                                    User.setUserEmail(email_reg.getText().toString());
                                    User.setUserStudentNum(studentNum.getText().toString());
                                    User.setUserLastName(lastName.getText().toString());
                                    User.setUserFirstName(firstName.getText().toString());
                                    myRef.setValue(User);
                                    Intent intent = new Intent(RegisterActivity.this, TakeSelfie.class);
                                    intent.putExtra("StudentId",student_id);
                                    startActivity(intent);
                                } else {Toast.makeText(RegisterActivity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();} // Exception message will be returned by Firebase in case of an error.
                            }
                        });
                    } else {Toast.makeText(RegisterActivity.this, "Passwords do not match.", Toast.LENGTH_LONG).show();}
                } else {Toast.makeText(RegisterActivity.this, "Please fill in all fields.", Toast.LENGTH_SHORT).show();}
            }
        });
    }

}
