package com.example.covid19;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class VaccinationActivity extends AppCompatActivity {

    EditText addhaarnoEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccination);

        addhaarnoEditText = findViewById(R.id.addhaarnoEditText);
    }

    public void registerEvent(View view) {
        String number = addhaarnoEditText.getText().toString();
        if(number.length() < 12)
            // invalid Toast
            Toast.makeText(this, "Enter a valid addhaar number.", Toast.LENGTH_SHORT).show();
        else
            // successful register
            Toast.makeText(this, "Registered Successfully.", Toast.LENGTH_SHORT).show();
    }

    public void historyEvent(View view) {
        Toast.makeText(this, "Coming Soon.", Toast.LENGTH_SHORT).show();
    }
}