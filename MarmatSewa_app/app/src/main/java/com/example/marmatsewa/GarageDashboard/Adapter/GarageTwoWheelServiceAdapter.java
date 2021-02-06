package com.example.marmatsewa.GarageDashboard.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.marmatsewa.AdminInterface.SeviceDevelopment.Service;
import com.example.marmatsewa.AdminInterface.UploadImageDevelopment.ImageBLL;
import com.example.marmatsewa.R;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class GarageTwoWheelServiceAdapter extends RecyclerView.Adapter<GarageTwoWheelServiceAdapter.GarageTwoWheelServiceHolder> {
    private Context context;
    private List<Service> garageTwoWheelServiceList;

    public GarageTwoWheelServiceAdapter(Context context, List<Service> garageTwoWheelServiceList) {
        this.context = context;
        this.garageTwoWheelServiceList = garageTwoWheelServiceList;
    }

    @NonNull
    @Override
    public GarageTwoWheelServiceHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new GarageTwoWheelServiceHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.garage_two_wheel_service_card, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull GarageTwoWheelServiceHolder holder, int position) {
        holder.twoWheelServiceName.setText(garageTwoWheelServiceList.get(position).getFeature());

        ImageBLL imageBLL = new ImageBLL();
        imageBLL.MakeStrict();
        String imagePath = com.example.marmatsewa.url.URL.BASE_URL +"uploads/" + garageTwoWheelServiceList.get(position).getImage();
        try {
            URL url = new URL(imagePath);
            Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            holder.twoWheelServiceImage.setImageBitmap(bmp);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        holder.btnRemove.setOnClickListener(v-> {

        });
    }

    @Override
    public int getItemCount() {
        return garageTwoWheelServiceList.size();
    }

    public class GarageTwoWheelServiceHolder extends RecyclerView.ViewHolder {
        private TextView twoWheelServiceName;
        private ImageView twoWheelServiceImage, btnRemove;

        public GarageTwoWheelServiceHolder(@NonNull View itemView) {
            super(itemView);

            twoWheelServiceName = itemView.findViewById(R.id.twoWheelServiceName);
            twoWheelServiceImage = itemView.findViewById(R.id.twoWheelServiceImage);
            btnRemove = itemView.findViewById(R.id.btnRemove);
        }
    }
}
