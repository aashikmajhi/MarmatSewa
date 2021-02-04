package com.example.marmatsewa.UserInterface.Adapter;

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

public class FourWheelServiceAdapter extends RecyclerView.Adapter<FourWheelServiceAdapter.FourWheelServiceHolder> {
    private Context context;
    private List<Service> fourWheelServiceList;

    public FourWheelServiceAdapter(Context context, List<Service> fourWheelServiceList) {
        this.context = context;
        this.fourWheelServiceList = fourWheelServiceList;
    }

    @NonNull
    @Override
    public FourWheelServiceHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FourWheelServiceHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.user_four_wheel_service_card, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull FourWheelServiceHolder holder, int position) {
        holder.fourWheelServiceName.setText(fourWheelServiceList.get(position).getFeature());

        ImageBLL imageBLL = new ImageBLL();
        imageBLL.MakeStrict();
        String imagePath = com.example.marmatsewa.url.URL.BASE_URL +"/uploads/" + fourWheelServiceList.get(position).getImage();
        try {
            URL url = new URL(imagePath);
            Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            holder.fourWheelServiceImage.setImageBitmap(bmp);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return fourWheelServiceList.size();
    }

    public class FourWheelServiceHolder extends RecyclerView.ViewHolder {
        private TextView fourWheelServiceName;
        private ImageView fourWheelServiceImage;

        public FourWheelServiceHolder(@NonNull View itemView) {
            super(itemView);
            fourWheelServiceName = itemView.findViewById(R.id.fourWheelServiceName);
            fourWheelServiceImage = itemView.findViewById(R.id.fourWheelServiceImage);
        }
    }
}
