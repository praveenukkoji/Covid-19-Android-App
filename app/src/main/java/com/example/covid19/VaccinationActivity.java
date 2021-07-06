package com.example.covid19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class VaccinationActivity extends AppCompatActivity {

    EditText aadhaarNoEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccination);

        aadhaarNoEditText = findViewById(R.id.aadhaarNoEditText);
    }

    // register event
    public void registerVaccinationEvent(View view) {

        String number = aadhaarNoEditText.getText().toString();
        if(number.length() < 12)
            // invalid Toast
            Toast.makeText(getApplicationContext(), "Enter a valid aadhaar number.", Toast.LENGTH_SHORT).show();
        else
            // successful register
            Toast.makeText(getApplicationContext(), "Registered Successfully.", Toast.LENGTH_SHORT).show();
    }

    // history event
    public void historyEvent(View view) {

        Intent intent = new Intent(this, VaccinationHistoryActivity.class);
        startActivity(intent);
    }

    // back button
    public void backBtn(View view) {
        onBackPressed();
    }
}