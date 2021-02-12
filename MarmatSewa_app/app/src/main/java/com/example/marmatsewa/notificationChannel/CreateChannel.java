package com.example.marmatsewa.notificationChannel;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;

public class CreateChannel {
    Context context;
    public final static String hire = "hire";
    public final static String approved = "approved";
    public final static String completed = "completed";

    //constructor
    public CreateChannel(Context context) {
        this.context = context;
    }

    public void createChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel HIRE = new NotificationChannel(hire, "hire", NotificationManager.IMPORTANCE_HIGH);
            HIRE.setDescription("New Request!!");

            NotificationChannel APPROVE = new NotificationChannel(approved, "approved", NotificationManager.IMPORTANCE_HIGH);
            APPROVE.setDescription("Your service request has been accepted!!");

            NotificationChannel COMPLETED = new NotificationChannel(completed, "completed", NotificationManager.IMPORTANCE_HIGH);
            APPROVE.setDescription("Your service is successfully completed!!");

            NotificationManager manager = context.getSystemService(NotificationManager.class);
            manager.createNotificationChannel(HIRE);
            manager.createNotificationChannel(APPROVE);
            manager.createNotificationChannel(COMPLETED);
        }
    }
}
