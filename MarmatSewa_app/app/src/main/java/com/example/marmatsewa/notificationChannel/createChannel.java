package com.example.marmatsewa.notificationChannel;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;

public class createChannel {
    Context context;
    public final static String hire = "hire";
    public final static String approved = "approved";
    public final static String completed = "completed";

    //constructor
    public createChannel(Context context) {
        this.context = context;
    }

    public void createChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel1 = new NotificationChannel(hire, "hire", NotificationManager.IMPORTANCE_HIGH);
            channel1.setDescription("New Request!!");

            NotificationChannel channel2 = new NotificationChannel(approved, "approved", NotificationManager.IMPORTANCE_HIGH);
            channel2.setDescription("Your service request has been accepted!!");

            NotificationChannel channel3 = new NotificationChannel(completed, "completed", NotificationManager.IMPORTANCE_HIGH);
            channel2.setDescription("Your service is successfully completed!!");

            NotificationManager manager = context.getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel1);
            manager.createNotificationChannel(channel2);
            manager.createNotificationChannel(channel3);
        }
    }
}
