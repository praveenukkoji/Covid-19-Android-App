package com.example.covid19;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

// bar chart
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

//navigation
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    // bar chart
    BarChart barChart;

    // spinner
    Spinner chartTypeSpinner;
    Spinner stateSpinner;

    // exit app
    private long pressedTime;

    // navigation
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // bar chart
        barChart = findViewById(R.id.barChart);

        ArrayList<BarEntry> data = new ArrayList<>();
        data.add(new BarEntry(1, 1));
        data.add(new BarEntry(2, 2));
        data.add(new BarEntry(3, 3));
        data.add(new BarEntry(4, 4));
        data.add(new BarEntry(5, 5));
        data.add(new BarEntry(6, 1));
        data.add(new BarEntry(7, 2));
        data.add(new BarEntry(8, 3));
        data.add(new BarEntry(9, 4));
        data.add(new BarEntry(10, 5));
        data.add(new BarEntry(11, 1));
        data.add(new BarEntry(12, 2));
        data.add(new BarEntry(13, 3));
        data.add(new BarEntry(14, 4));
        data.add(new BarEntry(15, 5));
        data.add(new BarEntry(16, 1));
        data.add(new BarEntry(17, 2));
        data.add(new BarEntry(18, 3));
        data.add(new BarEntry(19, 4));
        data.add(new BarEntry(20, 5));

        BarDataSet barDataSet = new BarDataSet(data, "");
        barDataSet.setDrawValues(false);

        BarData barData = new BarData(barDataSet);

        barChart.setData(barData);

        barChart.getDescription().setEnabled(false);
        barChart.getLegend().setEnabled(false);

        barChart.getXAxis().setEnabled(false);
        barChart.getXAxis().setDrawAxisLine(false);
        barChart.getXAxis().setDrawGridLines(false);
        barChart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);

        barChart.getAxisRight().setEnabled(false);

        barChart.getAxisLeft().setDrawAxisLine(false);

        // spinner
        chartTypeSpinner = findViewById(R.id.chartTypeSpinner);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.chartType, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        chartTypeSpinner.setAdapter(adapter1);
        chartTypeSpinner.setOnItemSelectedListener(this);

        stateSpinner = findViewById(R.id.stateSpinner);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.states, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        stateSpinner.setAdapter(adapter2);
        stateSpinner.setOnItemSelectedListener(this);

        // navigation
        drawerLayout = findViewById(R.id.drawerLayout);

        navigationView = findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                Intent intent;
                switch (id) {
                    case R.id.home:
                        intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.vaccination:
                        intent = new Intent(getApplicationContext(), VaccinationActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.prevention:
                        intent = new Intent(getApplicationContext(), VaccinationHistoryActivity.class);
                        startActivity(intent);
                        break;
                    default:
                        break;
                }
                return true;
            }
        });

    }

    // spinner
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        String item = parent.getItemAtPosition(position).toString();
        Toast.makeText(getApplicationContext(), item, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
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

    // state event
    public void stateListEvent(View view) {
    }

    // chart type event
    public void chartTypeEvent(View view) {
    }

    // navigation
    public void menuEvent(View view) {

        drawerLayout.openDrawer(GravityCompat.START);
    }
}