package com.example.covid19;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class VaccinationCertificateActivity extends AppCompatActivity {

    EditText beneficiaryIdEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccination_certificate);
    }

    // back button
    public void backBtn(View view) {
        onBackPressed();
    }

    // download event
    public void downloadCertificateEvent(View view) {

        beneficiaryIdEditText = findViewById(R.id.beneficiaryIdEditText);
        if(beneficiaryIdEditText.length() < 14) {
            Toast.makeText(getApplicationContext(), "Invalid Beneficiary Id.", Toast.LENGTH_SHORT).show();
            return;
        }

        Toast.makeText(getApplicationContext(), "Coming Soon.", Toast.LENGTH_SHORT).show();
    }
}