package com.example.audioplayer

import android.Manifest
import android.content.pm.PackageManager
import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.widget.Button
import androidx.core.app.ActivityCompat

class MainActivity : AppCompatActivity() {
    lateinit var  Mp:MediaPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    val btnResource=findViewById<Button>(R.id.bResource)
    val btnPlay=findViewById<Button>(R.id.bPlay)
    val btnAssets=findViewById<Button>(R.id.bAsset)
        val btnPause=findViewById<Button>(R.id.bPause)
        val btnStop=findViewById<Button>(R.id.bStop)
    val btnInternet=findViewById<Button>(R.id.bInternet)
    val btnSDCARD=findViewById<Button>(R.id.bSDCARD)
        btnResource.setOnClickListener {
            Mp= MediaPlayer()
   Mp= MediaPlayer.create(this,R.raw.greeting)
    }
        btnAssets.setOnClickListener {
            Mp=MediaPlayer()
       var mp3file=assets.openFd("mp3/tada.mp3")
       Mp.setDataSource(mp3file.fileDescriptor,mp3file.startOffset,mp3file.length)
       Mp.prepare()
        }
  if(ActivityCompat.checkSelfPermission(this,Manifest.permission.INTERNET) !=
      PackageManager.PERMISSION_GRANTED)ActivityCompat.requestPermissions(this, arrayOf(
          Manifest.permission.INTERNET),12345)
   btnInternet.setOnClickListener {
   Mp= MediaPlayer()
   Mp.setDataSource(this, Uri.parse("http://112.121.150.133:9000/stream?type=http&nocache=160"))
   Mp.prepare()
   }
        btnPlay.setOnClickListener {  Mp.start() }
    btnPause.setOnClickListener { Mp.pause() }
    btnStop.setOnClickListener { Mp.stop() }

        if(ActivityCompat.checkSelfPermission(this,Manifest.permission.READ_MEDIA_AUDIO)!=
            PackageManager.PERMISSION_GRANTED)ActivityCompat.requestPermissions(this,
            arrayOf(Manifest.permission.READ_MEDIA_AUDIO),1234)

   btnSDCARD.setOnClickListener {
       Mp=MediaPlayer()
       Mp.setDataSource(Environment.getExternalStorageDirectory().absolutePath+"/song.mp3")
       Mp.prepare()
   }
    }
}