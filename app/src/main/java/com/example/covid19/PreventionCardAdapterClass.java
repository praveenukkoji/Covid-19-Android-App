package com.example.covid19;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PreventionCardAdapterClass extends RecyclerView.Adapter<PreventionCardAdapterClass.MyViewHolder> {

    ArrayList<PreventionCardClass> list;

    public PreventionCardAdapterClass(ArrayList<PreventionCardClass> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_prevention_card, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.imageView.setImageResource(list.get(position).getImage());
        holder.desc.setText(list.get(position).getDesc());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView desc;

        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            desc = itemView.findViewById(R.id.desc);
        }
    }
}
