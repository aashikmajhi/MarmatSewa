package com.example.marmatsewa.AdminInterface.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.example.marmatsewa.AdminInterface.SeviceDevelopment.Service;
import com.example.marmatsewa.R;

import java.util.List;

public class ServiceAdapter extends RecyclerView.Adapter<ServiceAdapter.ServiceViewHolder> {

    private Context context;
    private List<Service> serviceList;

    public ServiceAdapter(Context context, List<Service> serviceList) {
        this.context = context;
        this.serviceList = serviceList;
    }

    @NonNull
    @Override
    public ServiceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ServiceViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.admin_2_wheel_card, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ServiceViewHolder serviceViewHolder, int position) {
        serviceViewHolder.twoWheelServiceName.setText(serviceList.get(position).getFeature());
    }

    @Override
    public int getItemCount() {
        return serviceList.size();
    }

    public class ServiceViewHolder extends ViewHolder {

        private TextView twoWheelServiceName;
        private ImageView twoWheelServiceImage;

        public ServiceViewHolder(@NonNull View itemView) {
            super(itemView);

            twoWheelServiceName = itemView.findViewById(R.id.twoWheelServiceName);
            twoWheelServiceImage = itemView.findViewById(R.id.twoWheelServiceImage);
        }
    }
}
