package com.example.covid19;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class VaccinationHistoryActivity extends AppCompatActivity {

    ListView vaccinationHistoryListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccination_history);

        vaccinationHistoryListView = findViewById(R.id.vaccinationHistoryListView);

        ArrayList<VaccinationHistoryClass> vaccinationHistoryClassArrayList = new ArrayList<>();

        vaccinationHistoryClassArrayList.add(new VaccinationHistoryClass(R.drawable.vaccination_history_injection,"123456789012", "20/12/2021"));
        vaccinationHistoryClassArrayList.add(new VaccinationHistoryClass(R.drawable.vaccination_history_injection,"123456789012", "20/12/2021"));
        vaccinationHistoryClassArrayList.add(new VaccinationHistoryClass(R.drawable.vaccination_history_injection,"123456789012", "20/12/2021"));
        vaccinationHistoryClassArrayList.add(new VaccinationHistoryClass(R.drawable.vaccination_history_injection,"123456789012", "20/12/2021"));
        vaccinationHistoryClassArrayList.add(new VaccinationHistoryClass(R.drawable.vaccination_history_injection,"123456789012", "20/12/2021"));
        vaccinationHistoryClassArrayList.add(new VaccinationHistoryClass(R.drawable.vaccination_history_injection,"123456789012", "20/12/2021"));
        vaccinationHistoryClassArrayList.add(new VaccinationHistoryClass(R.drawable.vaccination_history_injection,"123456789012", "20/12/2021"));
        vaccinationHistoryClassArrayList.add(new VaccinationHistoryClass(R.drawable.vaccination_history_injection,"123456789012", "20/12/2021"));
        vaccinationHistoryClassArrayList.add(new VaccinationHistoryClass(R.drawable.vaccination_history_injection,"123456789012", "20/12/2021"));
        vaccinationHistoryClassArrayList.add(new VaccinationHistoryClass(R.drawable.vaccination_history_injection,"123456789012", "20/12/2021"));
        vaccinationHistoryClassArrayList.add(new VaccinationHistoryClass(R.drawable.vaccination_history_injection,"123456789012", "20/12/2021"));
        vaccinationHistoryClassArrayList.add(new VaccinationHistoryClass(R.drawable.vaccination_history_injection,"123456789012", "20/12/2021"));
        vaccinationHistoryClassArrayList.add(new VaccinationHistoryClass(R.drawable.vaccination_history_injection,"123456789012", "20/12/2021"));
        vaccinationHistoryClassArrayList.add(new VaccinationHistoryClass(R.drawable.vaccination_history_injection,"123456789012", "20/12/2021"));
        vaccinationHistoryClassArrayList.add(new VaccinationHistoryClass(R.drawable.vaccination_history_injection,"123456789012", "20/12/2021"));
        vaccinationHistoryClassArrayList.add(new VaccinationHistoryClass(R.drawable.vaccination_history_injection,"123456789012", "20/12/2021"));

        VaccinationHistoryAdapterClass vaccinationHistoryAdapterClass = new VaccinationHistoryAdapterClass(this, R.layout.activity_vaccination_history_list_row,vaccinationHistoryClassArrayList);
        vaccinationHistoryListView.setAdapter(vaccinationHistoryAdapterClass);

    }
}