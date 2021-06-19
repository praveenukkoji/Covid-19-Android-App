package com.example.covid19;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class VaccinationHistoryAdapterClass extends ArrayAdapter<VaccinationHistoryClass> {

    private Context mContext;
    private int mResource;

    public VaccinationHistoryAdapterClass(@NonNull Context context, int resource, @NonNull ArrayList<VaccinationHistoryClass> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(mContext);

        convertView = layoutInflater.inflate(mResource, parent, false);
        ImageView injection = convertView.findViewById(R.id.injectionImageView);
        TextView aadhaarCardNo = convertView.findViewById(R.id.aadhaarCardNoTextView);
        TextView registeredDate = convertView.findViewById(R.id.registeredDateTextView);

        injection.setImageResource(getItem(position).getInjectionImage());
        aadhaarCardNo.setText(getItem(position).getAadhaarCardNo());
        registeredDate.setText(getItem(position).getRegisteredDate());

        return convertView;
    }
}
