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
import android.widget.TextView;
import android.widget.Toast;

// volley
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// line chart
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;

// navigation
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // volley
    private RequestQueue mQueue;
    TextView confirmed, deaths, recovered, active;

    // line chart
    LineChart lineChart;
    ArrayList<Entry> data = new ArrayList<>();

    // exit app
    private long pressedTime;

    // navigation
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // volley
        mQueue = Volley.newRequestQueue(this);
        confirmed = findViewById(R.id.Confirmed);
        deaths = findViewById(R.id.Deaths);
        recovered = findViewById(R.id.Recovered);
        active = findViewById(R.id.Active);

        // line chart
        lineChart = findViewById(R.id.lineChart);

        //TODO: insert real data and chart should change acc. to chart type

        data.add(new Entry(1, 0));
        data.add(new Entry(2, 12));
        data.add(new Entry(3, 34));
        data.add(new Entry(4, 23));
        data.add(new Entry(5, 46));

        LineDataSet dataSet = new LineDataSet(data,"Active");

        dataSet.setLineWidth(4);

        LineData lineData = new LineData(dataSet);
        lineChart.setData(lineData);

        lineChart.getDescription().setEnabled(false);
        lineChart.getLegend().setEnabled(false);
        lineChart.getXAxis().setEnabled(false);
        lineChart.getXAxis().setDrawAxisLine(false);
        lineChart.getXAxis().setDrawGridLines(false);
        lineChart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        lineChart.getAxisRight().setEnabled(false);
        lineChart.getAxisLeft().setDrawAxisLine(false);
        lineChart.getXAxis().setSpaceMin(0.2f);
        lineChart.getXAxis().setSpaceMax(0.2f);

        // card data
        jsonParse();

        // navigation
        drawerLayout = findViewById(R.id.drawerLayout);

        navigationView = findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                Intent intent;
                switch (id) {
                    case R.id.vaccination_center:
                        intent = new Intent(getApplicationContext(), VaccinationCenterActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.vaccination:
                        intent = new Intent(getApplicationContext(), VaccinationActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.vaccination_history:
                        intent = new Intent(getApplicationContext(), VaccinationHistoryActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.vaccination_certificate:
                        intent = new Intent(getApplicationContext(), VaccinationCertificateActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.prevention:
                        intent = new Intent(getApplicationContext(), PreventionActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.symptoms:
                        intent = new Intent(getApplicationContext(), SymptomsActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.logout:
                        FirebaseAuth.getInstance().signOut();
                        intent = new Intent(getApplicationContext(), LoginActivity.class);
                        startActivity(intent);
                        break;
                    default:
                        break;
                }
                return true;
            }
        });

    }

    // volley state parser
    private void jsonParse() {
        final String url = "https://data.covid19india.org/data.json";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("statewise");
                            JSONObject jsonObject = jsonArray.getJSONObject(0);
                            confirmed.setText(jsonObject.getString("confirmed"));
                            deaths.setText(jsonObject.getString("deaths"));
                            recovered.setText(jsonObject.getString("recovered"));
                            active.setText(jsonObject.getString("active"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        mQueue.add(request);
    }

    // exit app
    @Override
    public void onBackPressed() {

        if (this.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            this.drawerLayout.closeDrawer(GravityCompat.START);
        }
        else{
            if (pressedTime + 2000 > System.currentTimeMillis()) {
                super.onBackPressed();
                finishAffinity();
            } else {
                Toast.makeText(getBaseContext(), "Press back again to exit", Toast.LENGTH_SHORT).show();
            }
            pressedTime = System.currentTimeMillis();
        }
    }

    // navigation
    public void menuEvent(View view) {

        TextView email;
        email = findViewById(R.id.emailText);
        String emailText = FirebaseAuth.getInstance().getCurrentUser().getEmail();
        email.setText(emailText);
        drawerLayout.openDrawer(GravityCompat.START);
    }

    //TODO: create district data activity

    // state data event
    public void stateDataEvent(View view) {

        Intent intent = new Intent(getApplicationContext(), StateActivity.class);
        startActivity(intent);
    }
}