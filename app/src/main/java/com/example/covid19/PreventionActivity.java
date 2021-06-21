package com.example.covid19;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class PreventionActivity extends AppCompatActivity {

    ViewPager2 viewPager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prevention);

        viewPager2 = findViewById(R.id.viewPager2);

        ArrayList<PreventionCardClass> preventionCardClass = new ArrayList<>();

        preventionCardClass.add(new PreventionCardClass(R.drawable.wear_mask, "Wear Mask"));
        preventionCardClass.add(new PreventionCardClass(R.drawable.boost_immunity, "Boost Immunity"));
        preventionCardClass.add(new PreventionCardClass(R.drawable.wash_hand, "Wash Hand"));
        preventionCardClass.add(new PreventionCardClass(R.drawable.stay_home, "Stay Home"));
        preventionCardClass.add(new PreventionCardClass(R.drawable.social_distancing, "Social Distancing"));

        PreventionCardAdapterClass preventionCardAdapterClass = new PreventionCardAdapterClass(preventionCardClass);
        viewPager2.setAdapter(preventionCardAdapterClass);

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
}