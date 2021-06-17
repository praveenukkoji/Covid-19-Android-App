package com.example.covid19;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    BarChart barChart;
    private long pressedTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        BarData barData = new BarData(barDataSet);

        barChart.setData(barData);
    }

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

    // TODO: State List Event
    public void stateListEvent(View view) {
    }

    // TODO: Chart Type Event
    public void chartTypeEvent(View view) {
    }

    // TODO: Menu Event
    public void menuEvent(View view) {
    }
}