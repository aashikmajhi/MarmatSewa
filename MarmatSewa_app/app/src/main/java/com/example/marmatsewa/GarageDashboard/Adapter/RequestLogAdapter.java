package com.example.marmatsewa.GarageDashboard.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.marmatsewa.GarageDashboard.GarageRequestDevelopment.GarageRequestBLL;
import com.example.marmatsewa.GarageDashboard.GarageRequestDevelopment.GarageRequestResponse;
import com.example.marmatsewa.GarageDashboard.GarageRequestDevelopment.RequestResponse;
import com.example.marmatsewa.R;

import java.util.List;

public class RequestLogAdapter extends RecyclerView.Adapter<RequestLogAdapter.RequestViewHolder> {


    private Context context;
    private List<RequestResponse> requestList;

    public RequestLogAdapter(Context context, List<RequestResponse> requestList) {
        this.context = context;
        this.requestList = requestList;
    }


    @NonNull
    @Override
    public RequestLogAdapter.RequestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RequestViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.request_log_card, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RequestLogAdapter.RequestViewHolder holder, int position) {
        holder.tvFullName.setText(requestList.get(position).getUser().getFullname());
        holder.tvNumber.setText(requestList.get(position).getUser().getPhoneNo());
        holder.tvAddress.setText(requestList.get(position).getUser().getAddress());

        holder.btnAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GarageRequestBLL bll = new GarageRequestBLL();
//                if (bll.putRequest(requestList.get(position).get_id(), "DONE")) {
//                    requestList.remove(position);
//                    notifyDataSetChanged();
//                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return requestList.size();
    }

    public class RequestViewHolder extends RecyclerView.ViewHolder {
        TextView tvFullName;
        TextView tvAddress;
        TextView tvNumber;
        ImageView btnAccept;
        public RequestViewHolder(@NonNull View itemView) {
            super(itemView);

            tvFullName = itemView.findViewById(R.id.tvFullname);
            tvAddress = itemView.findViewById(R.id.tvLocation);
            tvNumber = itemView.findViewById(R.id.tvNumber);
            btnAccept = itemView.findViewById(R.id.btnAccept);

        }
    }

    public void putRequestToDone() {

    }
}


