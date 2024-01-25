package com.example.videoplayer

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.MediaController
import android.widget.VideoView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnResource=findViewById<Button>(R.id.bResource)
        val btnInternet=findViewById<Button>(R.id.bInternet)
        val btnSDCARD=findViewById<Button>(R.id.bSDCARD)
        val btnPlay=findViewById<Button>(R.id.bPlay)
        val btnPause=findViewById<Button>(R.id.bPause)
        val btnStop=findViewById<Button>(R.id.bStop)
        val VideoPlayer=findViewById<VideoView>(R.id.video)

        btnResource.setOnClickListener {
    VideoPlayer.setVideoURI(Uri.parse("android.resource://"
    +packageName+"/"+R.raw.video2
    ))
        }
btnPlay.setOnClickListener { VideoPlayer.start() }
btnPause.setOnClickListener { VideoPlayer.pause() }
btnStop.setOnClickListener { VideoPlayer.stopPlayback() }
btnInternet.setOnClickListener {
 VideoPlayer.setVideoURI(Uri.parse(
     "https://www.drpaween.com/ohm/cs436/mv.mp4"))
}
VideoPlayer.setMediaController(MediaController(this))
    }
}