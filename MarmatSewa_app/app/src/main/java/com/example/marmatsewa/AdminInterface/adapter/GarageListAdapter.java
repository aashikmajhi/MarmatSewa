package com.example.marmatsewa.AdminInterface.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.marmatsewa.R;
import com.example.marmatsewa.Registration.WorkshopRegistrationDevelopment.Workshop;

import java.util.List;

public class GarageListAdapter extends RecyclerView.Adapter<GarageListAdapter.GarageListHolder> {
    private Context context;
    private List<Workshop> garageApproveList;

    public GarageListAdapter(Context context, List<Workshop> garageApproveList) {
        this.context = context;
        this.garageApproveList = garageApproveList;
    }

    @NonNull
    @Override
    public GarageListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new GarageListHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.admin_garage_card, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull GarageListHolder holder, int position) {
        holder.GName.setText(garageApproveList.get(position).getBusinessName());
        holder.GNumber.setText(garageApproveList.get(position).getContactNo());
        holder.GLocation.setText(garageApproveList.get(position).getAddress());
    }

    @Override
    public int getItemCount() {
        return garageApproveList.size();
    }

    public class GarageListHolder extends RecyclerView.ViewHolder {
        private TextView GName, GNumber, GLocation, linkMapView;
        private ImageView btnRemove;

        public GarageListHolder(@NonNull View itemView) {
            super(itemView);
            GName = itemView.findViewById(R.id.GName);
            GNumber = itemView.findViewById(R.id.GNumber);
            GLocation = itemView.findViewById(R.id.GLocation);
            linkMapView = itemView.findViewById(R.id.linkMapView);

            btnRemove = itemView.findViewById(R.id.btnRemove);
        }
    }
}
