package com.example.covid19;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class VaccinationCenterActivity extends AppCompatActivity {

    // volley
    private RequestQueue mQueue;

    TextView pincode;
    
    ListView vaccinationCenterListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccination_center);

        // volley
        mQueue = Volley.newRequestQueue(this);

        vaccinationCenterListView = findViewById(R.id.vaccinationCenterListView);

    }

    // back button
    public void backBtn(View view) {
        onBackPressed();
    }

    // search event
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void searchEvent(View view) {
        ArrayList<VaccinationCenterClass> vaccinationCenterClassArrayList = new ArrayList<>();

        pincode = findViewById(R.id.pincode);
        String pincodeText = pincode.getText().toString();
        if(pincodeText.length() < 6){
            Toast.makeText(getApplicationContext(), "Invalid Pincode", Toast.LENGTH_SHORT).show();
        }
        else{
            String date = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());

            String url = "https://cdn-api.co-vin.in/api/v2/appointment/sessions/public/findByPin?pincode="+pincodeText+"&date="+date;
            JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                JSONArray jsonArray = response.getJSONArray("sessions");
                                if(jsonArray.length() > 0){
                                    JSONObject jsonObject;
                                    for(int i=0;i<jsonArray.length();i++){
                                        jsonObject = jsonArray.getJSONObject(i);
                                        vaccinationCenterClassArrayList.add(
                                                new VaccinationCenterClass(jsonObject.getString("center_id"),
                                                        jsonObject.getString("state_name"),
                                                        jsonObject.getString("name"),
                                                        jsonObject.getString("address"),
                                                        jsonObject.getString("vaccine"),
                                                        jsonObject.getString("pincode"),
                                                        jsonObject.getString("available_capacity"),
                                                        jsonObject.getString("available_capacity_dose1"),
                                                        jsonObject.getString("available_capacity_dose2"),
                                                        jsonObject.getString("min_age_limit"),
                                                        jsonObject.getString("fee_type")));
                                    }
                                    VaccinationCenterAdapterClass vaccinationCenterAdapterClass = new VaccinationCenterAdapterClass(getApplicationContext(), R.layout.activity_vaccination_center_list_row,vaccinationCenterClassArrayList);
                                    vaccinationCenterListView.setAdapter(vaccinationCenterAdapterClass);
                                }
                                else{
                                    Toast.makeText(getApplicationContext(), "Data not available.", Toast.LENGTH_SHORT).show();
                                }
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
    }
}