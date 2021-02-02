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
import java.util.zip.Inflater;

public class RequestListAdapter extends RecyclerView.Adapter<RequestListAdapter.RequestListHolder> {
    private Context context;
    private List<Workshop> garageList;

    public RequestListAdapter(Context context, List<Workshop> garageList) {
        this.context = context;
        this.garageList = garageList;
    }

    @NonNull
    @Override
    public RequestListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RequestListHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.request_card, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RequestListHolder holder, int position) {
        if (garageList.get(position).getStatus().equals("PENDING")) {
            holder.GarageName.setText(garageList.get(position).getOwnerName());
            holder.GarageNumber.setText(garageList.get(position).getContactNo());
            holder.garageLocation.setText(garageList.get(position).getAddress());
        }
    }

    @Override
    public int getItemCount() {
        return garageList.size();
    }

    public class RequestListHolder extends RecyclerView.ViewHolder {

        private TextView GarageName, GarageNumber, garageLocation, linkGarageMapView;
        private ImageView btnAcceptGarage, btnDeclineGarage;

        public RequestListHolder(@NonNull View itemView) {
            super(itemView);

            GarageName = itemView.findViewById(R.id.GarageName);
            GarageNumber = itemView.findViewById(R.id.GarageNumber);
            garageLocation = itemView.findViewById(R.id.garageLocation);
            linkGarageMapView = itemView.findViewById(R.id.linkGarageMapView);

            btnAcceptGarage = itemView.findViewById(R.id.btnAcceptGarage);
            btnDeclineGarage = itemView.findViewById(R.id.btnDeclineGarage);
        }
    }
}
