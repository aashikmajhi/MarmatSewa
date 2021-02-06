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

public class GarageFourWheelServiceAdapter extends RecyclerView.Adapter<GarageFourWheelServiceAdapter.GarageFourWheelServiceHolder> {
    private Context context;
    private List<Service> garageFourWheelServiceList;

    public GarageFourWheelServiceAdapter(Context context, List<Service> garageFourWheelServiceList) {
        this.context = context;
        this.garageFourWheelServiceList = garageFourWheelServiceList;
    }

    @NonNull
    @Override
    public GarageFourWheelServiceHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new GarageFourWheelServiceHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.garage_four_wheel_service_card, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull GarageFourWheelServiceHolder holder, int position) {
        holder.fourWheelServiceName.setText(garageFourWheelServiceList.get(position).getFeature());

        ImageBLL imageBLL = new ImageBLL();
        imageBLL.MakeStrict();
        String imagePath = com.example.marmatsewa.url.URL.BASE_URL +"uploads/" + garageFourWheelServiceList.get(position).getImage();
        try {
            URL url = new URL(imagePath);
            Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            holder.fourWheelServiceImage.setImageBitmap(bmp);
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
        return garageFourWheelServiceList.size();
    }

    public class GarageFourWheelServiceHolder extends RecyclerView.ViewHolder {
        private TextView fourWheelServiceName;
        private ImageView fourWheelServiceImage, btnRemove;

        public GarageFourWheelServiceHolder(@NonNull View itemView) {
            super(itemView);

            fourWheelServiceName = itemView.findViewById(R.id.fourWheelServiceName);
            fourWheelServiceImage = itemView.findViewById(R.id.fourWheelServiceName);
            btnRemove = itemView.findViewById(R.id.btnRemove);
        }
    }
}
