package com.example.covid19;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

// firebase
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    // exit app
    private long pressedTime;

    EditText email;
    EditText password;

    // firebase
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        email = findViewById(R.id.emailEditText);
        password = findViewById(R.id.passwordEditText);

        // firebase instance
        firebaseAuth = FirebaseAuth.getInstance();
    }

    // exit app
    @Override
    public void onBackPressed() {

        if (pressedTime + 2000 > System.currentTimeMillis()) {
            super.onBackPressed();
            finishAffinity();
        } else {
            Toast.makeText(getBaseContext(), "Press back again to exit", Toast.LENGTH_SHORT).show();
        }
        pressedTime = System.currentTimeMillis();
    }

    // register event
    public void registerEvent(View view) {

        String getEmail = email.getText().toString();
        String getPassword = password.getText().toString();

        if(getEmail.length() != 0 && getPassword.length() != 0)

            // create new user with email and password
            firebaseAuth.createUserWithEmailAndPassword(getEmail, getPassword)
                    .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {
                            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                            startActivity(intent);
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(getApplicationContext(), "" + e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
        else{
            Toast.makeText(getApplicationContext(), "Enter Credentials Properly.", Toast.LENGTH_SHORT).show();
        }
    }

    // already have account event
    public void alreadyHaveAccountEvent(View view) {

        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(intent);
    }
}