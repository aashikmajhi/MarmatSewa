package com.example.marmatsewa.GarageDashboard.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.marmatsewa.GarageDashboard.GarageRequestDevelopment.GarageRequestBLL;
import com.example.marmatsewa.GarageDashboard.GarageRequestDevelopment.GarageRequestResponse;
import com.example.marmatsewa.R;

import java.util.List;

public class CustomerRequestAdapter extends RecyclerView.Adapter<CustomerRequestAdapter.CustomerRequestHolder> {

    private Context context;
    private List<GarageRequestResponse> requestList;

    public CustomerRequestAdapter(Context context, List<GarageRequestResponse> requestList) {
        this.context = context;
        this.requestList = requestList;
    }

    @NonNull
    @Override
    public CustomerRequestHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomerRequestHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.request_card, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CustomerRequestHolder holder, int position) {
        holder.customerName.setText(requestList.get(position).getUser().getFullname());
        holder.customerNumber.setText(requestList.get(position).getUser().getPhoneNo());
        holder.customerLocation.setText(requestList.get(position).getUser().getAddress());
        holder.feature.setText(requestList.get(position).getFeature().getFeature());

        holder.btnAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //implementation of  put request to change status of request and send notification ...
                GarageRequestBLL garageRequestBLL = new GarageRequestBLL();
                garageRequestBLL.putRequest(requestList.get(position).get_id(), "APPROVED");
                //to refresh list ...
                requestList.remove(position);
                notifyDataSetChanged();

            }
        });

    }

    @Override
    public int getItemCount() {
        return requestList.size();
    }

    public class CustomerRequestHolder extends RecyclerView.ViewHolder {
        TextView customerName, customerNumber, customerLocation, feature;
        ImageView btnAccept;
        public CustomerRequestHolder(@NonNull View itemView) {
            super(itemView);
            customerName = itemView.findViewById(R.id.customerName);
            customerNumber = itemView.findViewById(R.id.customerNumber);
            customerLocation = itemView.findViewById(R.id.customerLocation);
            feature = itemView.findViewById(R.id.feature);
            btnAccept = itemView.findViewById(R.id.btnAccept);
        }
    }


}
