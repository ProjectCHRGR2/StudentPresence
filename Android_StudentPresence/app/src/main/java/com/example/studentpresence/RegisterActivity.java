package com.example.studentpresence;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class RegisterActivity extends AppCompatActivity {

    EditText email_reg;
    EditText password1;
    EditText password2;
    EditText studentNum;
    EditText firstName;
    EditText lastName;
    String userClass;
    Spinner dropDownMenu;
    Button register;

    FirebaseAuth mAuth;
    String[] classes;
    String tempClasses;

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
        dropDownMenu = findViewById(R.id.drop_down_menu);
        userClass = "";

        mAuth = mAuth.getInstance();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference dropDownRef1 = database.getReference(); // Set reference to the database.
        DatabaseReference dropDownRef2 = dropDownRef1.child("Classes"); // Set reference to the child in the database called "Classes".
        dropDownRef2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                tempClasses = dataSnapshot.getValue(String.class);
                classes = tempClasses.split(", ");

                //The source of these two lines is https://stackoverflow.com/questions/13377361/how-to-create-a-drop-down-list.
                //Consider reading it for a further explanation.
                ArrayAdapter<String> adapter = new ArrayAdapter<>(RegisterActivity.this, android.R.layout.simple_spinner_item, classes);
                dropDownMenu.setAdapter(adapter);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                dropDownMenu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        userClass = parent.getItemAtPosition(position).toString();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                        Toast.makeText(RegisterActivity.this, "Please fill in all fields.", Toast.LENGTH_SHORT).show();                    }
                });

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });


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
                                    //Prepare all values for sending below.
                                    UserProfile User = new UserProfile();
                                    User.setUserEmail(email_reg.getText().toString());
                                    User.setUserStudentNum(studentNum.getText().toString());
                                    User.setUserLastName(lastName.getText().toString());
                                    User.setUserFirstName(firstName.getText().toString());

                                    User.setUserClass(userClass);
                                    myRef.setValue(User); // Send values to Database.
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
