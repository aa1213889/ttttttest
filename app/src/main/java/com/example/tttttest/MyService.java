package com.example.tttttest;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Binder;
import android.os.IBinder;
import android.support.v7.app.NotificationCompat;
import android.util.Log;

public class MyService extends Service {
    public MyService() {
    }
    public class DownloadBinder extends Binder{
        public void startDownload(){
            Log.d("MyService","startDownload executed!");
        }
        public int getProgress(){
            Log.d("MyService","getProgress executed!");
            return  0 ;
        }
    }
    private DownloadBinder downloadBinder = new DownloadBinder();
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return  downloadBinder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.d("MyService","onCreate executed!");
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                PendingIntent pi = PendingIntent.getActivity(getApplicationContext(),0,intent,0);
                Notification notification = new NotificationCompat.Builder(getApplicationContext())
                        .setContentTitle("this is content title")
                        .setContentText("this is content text")
                        .setWhen(System.currentTimeMillis())
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher_round))
                        .setContentIntent(pi)
                        .build();
                startForeground(1,notification);
                Log.d("MyService","onStartCommand executed!Thread id is"+Thread.currentThread().getId());
            }
        }).start();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("MyService","onStartCommand executed!");
        return super.onStartCommand(intent, flags, startId);


    }

    @Override
    public void onDestroy() {
        Log.d("MyService","onDestroy executed!");
        super.onDestroy();

    }

}
