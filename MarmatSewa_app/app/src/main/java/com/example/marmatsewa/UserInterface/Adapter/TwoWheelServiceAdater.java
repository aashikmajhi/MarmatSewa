package com.example.marmatsewa.UserInterface.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
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

public class TwoWheelServiceAdater extends RecyclerView.Adapter<TwoWheelServiceAdater.TwoWhellServiceHolder> {
    private Context context;
    private List<Service> userServiceList;

    public TwoWheelServiceAdater(Context context, List<Service> userServiceList) {
        this.context = context;
        this.userServiceList = userServiceList;
    }

    @NonNull
    @Override
    public TwoWhellServiceHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TwoWhellServiceHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.user_two_wheel_service_card, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull TwoWhellServiceHolder holder, int position) {
        holder.twoWheelServiceName.setText(userServiceList.get(position).getFeature());

        ImageBLL imageBLL = new ImageBLL();
        imageBLL.MakeStrict();
        String imagePath = com.example.marmatsewa.url.URL.BASE_URL +"/uploads/" + userServiceList.get(position).getImage();
        try {
            URL url = new URL(imagePath);
            Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            holder.twoWheelServiceImage.setImageBitmap(bmp);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return userServiceList.size();
    }

    public class TwoWhellServiceHolder extends RecyclerView.ViewHolder {

        private TextView twoWheelServiceName;
        private ImageView twoWheelServiceImage;

        public TwoWhellServiceHolder(@NonNull View itemView) {
            super(itemView);

            twoWheelServiceName = itemView.findViewById(R.id.twoWheelServiceName);
            twoWheelServiceImage = itemView.findViewById(R.id.twoWheelServiceImage);
        }
    }
}
