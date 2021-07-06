package com.example.covid19;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class SymptomsActivity extends AppCompatActivity {

    ViewPager2 viewPager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symptoms);

        viewPager2 = findViewById(R.id.viewPager2);

        ArrayList<SwipeCardClass> swipeCardClasses = new ArrayList<>();

        swipeCardClasses.add(new SwipeCardClass(R.drawable.cough, "Cough"));
        swipeCardClasses.add(new SwipeCardClass(R.drawable.chest_pain, "Chest Pain"));
        swipeCardClasses.add(new SwipeCardClass(R.drawable.fatigue, "Fatigue"));
        swipeCardClasses.add(new SwipeCardClass(R.drawable.fever_chills, "Fever/Chills"));
        swipeCardClasses.add(new SwipeCardClass(R.drawable.inability_to_stay_awake, "Inability to Stay Awake"));
        swipeCardClasses.add(new SwipeCardClass(R.drawable.loss_of_smell_and_test, "Loss of Smell and Taste"));

        SymptomsCardAdapterClass symptomsCardAdapterClass = new SymptomsCardAdapterClass(swipeCardClasses);
        viewPager2.setAdapter(symptomsCardAdapterClass);

        View child = viewPager2.getChildAt(0);
        if (child instanceof RecyclerView) {
            child.setOverScrollMode(View.OVER_SCROLL_NEVER);
        }

        CompositePageTransformer transformer = new CompositePageTransformer();
        transformer.addTransformer(new ViewPager2.PageTransformer() {

            @Override
            public void transformPage(@NonNull View page, float position) {
                float a = 1 - Math.abs(position);
                page.setScaleY(0.85f + a * 0.15f);
            }
        });

        viewPager2.setPageTransformer(transformer);
    }

    // back button
    public void backBtn(View view) {
        onBackPressed();
    }
}