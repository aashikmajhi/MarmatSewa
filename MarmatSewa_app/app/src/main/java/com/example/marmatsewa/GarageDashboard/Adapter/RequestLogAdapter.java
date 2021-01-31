package com.example.marmatsewa.GarageDashboard.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RequestLogAdapter extends RecyclerView.Adapter<RequestLogAdapter.RequestViewHolder> {

    Context context;

    public RequestLogAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public RequestLogAdapter.RequestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RequestLogAdapter.RequestViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class RequestViewHolder extends RecyclerView.ViewHolder {
        public RequestViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}


