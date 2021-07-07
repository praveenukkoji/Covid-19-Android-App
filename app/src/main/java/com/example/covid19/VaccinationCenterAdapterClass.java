package com.example.covid19;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class VaccinationCenterAdapterClass extends ArrayAdapter<VaccinationCenterClass> {

    private Context mContext;
    private int mResource;

    public VaccinationCenterAdapterClass(@NonNull Context context, int resource, @NonNull ArrayList<VaccinationCenterClass> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(mContext);

        convertView = layoutInflater.inflate(mResource, parent, false);
        TextView centerId = convertView.findViewById(R.id.centerIdTextView);
        TextView stateName = convertView.findViewById(R.id.stateNameTextView);
        TextView centerName = convertView.findViewById(R.id.centerNameTextView);
        TextView address = convertView.findViewById(R.id.addressTextView);
        TextView vaccinationType = convertView.findViewById(R.id.vaccineTypeTextView);
        TextView pincode = convertView.findViewById(R.id.pincodeTextView);
        TextView availability = convertView.findViewById(R.id.availabilityTextView);
        TextView dose1 = convertView.findViewById(R.id.dose1TextView);
        TextView dose2 = convertView.findViewById(R.id.dose2TextView);
        TextView age = convertView.findViewById(R.id.ageTextView);
        TextView fee = convertView.findViewById(R.id.feeTextView);

        centerId.setText(getItem(position).getCenterId());
        stateName.setText(getItem(position).getStateName());
        centerName.setText(getItem(position).getCenterName());
        address.setText(getItem(position).getAddress());
        vaccinationType.setText(getItem(position).getVaccinationType());
        pincode.setText(getItem(position).getPincode());
        availability.setText(getItem(position).getAvailability());
        dose1.setText(getItem(position).getDose1());
        dose2.setText(getItem(position).getDose2());
        age.setText(getItem(position).getAge());
        fee.setText(getItem(position).getFee());

        return convertView;
    }
}
