package com.example.covid19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class VaccinationActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText aadhaarNoEditText;

    // vaccine
    VaccinationHistoryClass vaccine;

    // spinner
    Spinner vaccineTypeSpinner;
    String vaccineType;

    // pincode
    EditText pincodeEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccination);

        vaccineType = "";

        aadhaarNoEditText = findViewById(R.id.aadhaarNoEditText);
        pincodeEditText = findViewById(R.id.pincodeEditText);

        // spinner
        vaccineTypeSpinner = findViewById(R.id.vaccineTypeSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.vaccineType, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        vaccineTypeSpinner.setAdapter(adapter);
        vaccineTypeSpinner.setOnItemSelectedListener(this);
    }

    // register event
    public void registerVaccinationEvent(View view) {

        String addhaarNumber = aadhaarNoEditText.getText().toString();
        String pincode = pincodeEditText.getText().toString();

        Date c = Calendar.getInstance().getTime();
        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault());
        String registeredDate = df.format(c);

        if (addhaarNumber.length() < 12) {
            // invalid Toast
            Toast.makeText(getApplicationContext(), "Enter a valid aadhaar number.", Toast.LENGTH_SHORT).show();
        }
        else if (pincode.length() == 0) {

        }
        else if (vaccineType.length() == 0) {
            Toast.makeText(getApplicationContext(), "Select Vaccine Type.", Toast.LENGTH_SHORT).show();
        }
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

    // spinner
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        vaccineType = vaccineTypeSpinner.getSelectedItem().toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}