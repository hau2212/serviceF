package com.example.servicef;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

public class Myservice extends Service {
    String CHANLED_ID="Chanle_id";
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;

    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("AAA", "onCreate:  ");
        startForeground(1,creanotification(this,CHANLED_ID));
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("AAA", "onStartCommand  ");

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.d("AAA", "onDestroy  ");

        super.onDestroy();
    }
public Notification creanotification(Context context,String CHANLED_ID){
    NotificationCompat.Builder builder = new NotificationCompat.Builder(context,CHANLED_ID);
    builder.setSmallIcon(R.drawable.ic_launcher_background);
    builder.setContentTitle("hello");
    builder.setContentText("yexxxxx");
    builder.setShowWhen(true);
    builder.setPriority(Notification.PRIORITY_HIGH);


    NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.O){
        NotificationChannel notificationChannel = new NotificationChannel(CHANLED_ID,"hello",NotificationManager.IMPORTANCE_HIGH);
        notificationManager.createNotificationChannel(notificationChannel);

    }
    return builder.build();




}


}
