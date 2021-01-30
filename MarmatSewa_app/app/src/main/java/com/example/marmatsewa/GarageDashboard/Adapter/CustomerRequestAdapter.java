package com.example.marmatsewa.GarageDashboard.Adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CustomerRequestAdapter extends RecyclerView.Adapter<CustomerRequestAdapter.CustomerRequestHolder> {
    @NonNull
    @Override
    public CustomerRequestHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomerRequestHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class CustomerRequestHolder extends RecyclerView.ViewHolder {
        public CustomerRequestHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
