package com.example.rumahterbangkalai

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder

class MusicService : Service() {
    private var mediaPlayer: MediaPlayer? = null
    override fun onBind(intent: Intent?): IBinder? {
        return null 
    }
    
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer.create(this, R.raw.backsound)
            mediaPlayer?.isLooping = true
            mediaPlayer?.setVolume(0.4f, 0.4f)
        }
        
        if (mediaPlayer?.isPlaying == false) {
            mediaPlayer?.start()
        }
        
        return START_STICKY
    }

    override fun onCreate() {
        super.onCreate()
    }
    
    override fun onDestroy(){
        mediaPlayer?.stop()
        mediaPlayer?.release()
        mediaPlayer = null
        super.onDestroy()
    }
}