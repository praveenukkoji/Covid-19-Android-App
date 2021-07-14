package com.example.covid19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class VaccinationActivity extends AppCompatActivity {

    EditText aadhaarNoEditText;

    // vaccine
    VaccinationHistoryClass vaccine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccination);

        aadhaarNoEditText = findViewById(R.id.aadhaarNoEditText);
    }

    // register event
    public void registerVaccinationEvent(View view) {

        String addhaarNumber = aadhaarNoEditText.getText().toString();
        //TODO: take input from user
        String vaccineType = "COVAXIN";
        String pincode = "590118";

        Date c = Calendar.getInstance().getTime();
        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault());
        String registeredDate = df.format(c);

        if (addhaarNumber.length() < 12)
            // invalid Toast
            Toast.makeText(getApplicationContext(), "Enter a valid aadhaar number.", Toast.LENGTH_SHORT).show();
        else {
            // successful register
            vaccine = new VaccinationHistoryClass(addhaarNumber, vaccineType, pincode, registeredDate);

            FirebaseDatabase.getInstance().getReference("vaccinations")
                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                    .push().setValue(vaccine);
            Toast.makeText(getApplicationContext(), "Registered Successfully.", Toast.LENGTH_SHORT).show();
        }
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