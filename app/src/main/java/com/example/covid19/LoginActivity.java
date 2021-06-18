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

public class LoginActivity extends AppCompatActivity {

    EditText email;
    EditText password;

    // firebase
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.emailEditText);
        password = findViewById(R.id.passwordEditText);

        // firebase instance
        firebaseAuth = FirebaseAuth.getInstance();
    }

    // login event
    public void loginEvent(View view) {
        String getEmail = email.getText().toString();
        String getPassword = password.getText().toString();

        if(getEmail.length() != 0 && getPassword.length() != 0) {

            // sign in with email and password
            firebaseAuth.signInWithEmailAndPassword(getEmail, getPassword)
                    .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(LoginActivity.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
        }
        else{
            Toast.makeText(this, "Enter Credentials Properly.", Toast.LENGTH_SHORT).show();
        }
    }

    // forgot password event
    public void forgotPasswordEvent(View view) {
        Toast.makeText(this, "Coming Soon.", Toast.LENGTH_SHORT).show();
    }

    // create new account event
    public void createNewAccountEvent(View view) {
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intent);
    }
}