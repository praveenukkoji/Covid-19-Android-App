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
        ImageView injectionImageView = convertView.findViewById(R.id.injectionImageView);
        TextView aadhaarCardNo = convertView.findViewById(R.id.aadhaarCardNoTextView);
        TextView vaccineType = convertView.findViewById(R.id.vaccineTypeTextView);
        TextView pincode = convertView.findViewById(R.id.pincodeTextView);
        TextView registeredDate = convertView.findViewById(R.id.registeredDateTextView);

        injectionImageView.setImageResource(R.drawable.vaccination_history_injection);
        aadhaarCardNo.setText(getItem(position).getAadhaarCardNo());
        vaccineType.setText(getItem(position).getVaccineType());
        pincode.setText(getItem(position).getPincode());
        registeredDate.setText(getItem(position).getRegisteredDate());

        return convertView;
    }
}
