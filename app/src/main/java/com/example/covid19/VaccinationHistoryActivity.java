package com.example.covid19;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;

public class VaccinationHistoryActivity extends AppCompatActivity {

    ListView vaccinationHistoryListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccination_history);

        vaccinationHistoryListView = findViewById(R.id.vaccinationHistoryListView);

        ArrayList<VaccinationHistoryClass> vaccinationHistoryClassArrayList = new ArrayList<>();

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("vaccinations")
                .child(FirebaseAuth.getInstance().getCurrentUser().getUid());
        databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        vaccinationHistoryClassArrayList.clear();
                        for(DataSnapshot dataSnapshot: snapshot.getChildren()) {
                            vaccinationHistoryClassArrayList.add(dataSnapshot.getValue(VaccinationHistoryClass.class));
                        }

                        Collections.reverse(vaccinationHistoryClassArrayList);

                        VaccinationHistoryAdapterClass vaccinationHistoryAdapterClass =
                                new VaccinationHistoryAdapterClass(getApplicationContext(),
                                        R.layout.activity_vaccination_history_list_row,vaccinationHistoryClassArrayList);
                        vaccinationHistoryListView.setAdapter(vaccinationHistoryAdapterClass);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
    }

    // back button
    public void backBtn(View view) {
        onBackPressed();
    }
}