package com.example.plattechfinalproject;

import android.app.Service;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.IBinder;

import java.io.IOException;

public class BackgroundSoundService extends Service {
    private MediaPlayer player;

    @Override
    public IBinder onBind(Intent arg0) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        try {
            AssetFileDescriptor afd = getApplicationContext().getAssets().openFd("backgroundsound1.wav");
            player = new MediaPlayer();
            player.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
            player.setLooping(true); // Set looping
            player.setVolume(100f, 100f);
            player.prepare();
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        player.start();
        return Service.START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        player.stop();
        player.release();
    }
}