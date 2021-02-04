package com.example.marmatsewa.Registration.WorkshopRegistrationDevelopment;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.marmatsewa.AdminInterface.SeviceDevelopment.Service;
import com.example.marmatsewa.AdminInterface.UploadImageDevelopment.ImageBLL;
import com.example.marmatsewa.R;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class UserServiceApdater extends RecyclerView.Adapter<UserServiceApdater.ServiceHolder> {

    private Context context;
    private List<Service> userServiceList;

    public UserServiceApdater(Context context, List<Service> userServiceList) {
        this.context = context;
        this.userServiceList = userServiceList;
    }

    @NonNull
    @Override
    public ServiceHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ServiceHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.garage_registration_service_card, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ServiceHolder holder, int position) {
        holder.ServiceName.setText(userServiceList.get(position).getFeature());

        //get image from server ...
        ImageBLL imageBLL = new ImageBLL();
        imageBLL.MakeStrict();
        String imagePath = com.example.marmatsewa.url.URL.BASE_URL +"uploads/" + userServiceList.get(position).getImage();
        try {
            URL url = new URL(imagePath);
            Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            holder.ServiceImage.setImageBitmap(bmp);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        holder.btnAddService.setOnClickListener(v -> {
            System.out.println(userServiceList.get(position).get_id());
            Features features = new Features(userServiceList.get(position).get_id(), com.example.marmatsewa.url.URL.user_id);
            AddFeaturesBLL addFeaturesBLL = new AddFeaturesBLL(features);
            com.example.marmatsewa.url.URL.getStrictMode();
            if (addFeaturesBLL.checkAddGarageFeatures()) {
                Toast.makeText(context, "Service Added", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(context, "error adding service", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return userServiceList.size();
    }

    public class ServiceHolder extends RecyclerView.ViewHolder {
        private TextView ServiceName;
        private ImageView ServiceImage, btnAddService;
        public ServiceHolder(@NonNull View itemView) {
            super(itemView);

            ServiceName = itemView.findViewById(R.id.ServiceName);
            ServiceImage = itemView.findViewById(R.id.ServiceImage);
            btnAddService = itemView.findViewById(R.id.btnAddService);
        }
    }
}
