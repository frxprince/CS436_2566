package com.example.smsremote

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
 lateinit var MpAlarm:MediaPlayer
 lateinit var MPCat:MediaPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    val btn=findViewById<Button>(R.id.button)
    btn.setOnClickListener { finish() }
if (checkSelfPermission(Manifest.permission.RECEIVE_SMS)!=PackageManager.PERMISSION_GRANTED)
 requestPermissions(arrayOf(Manifest.permission.RECEIVE_SMS),1234)
MpAlarm=MediaPlayer.create(this,R.raw.alarm)
MPCat=MediaPlayer.create(this,R.raw.cat)
        if(intent!!.getStringExtra("data")=="cat")
            MPCat.start()
        if(intent!!.getStringExtra("data")=="alarm")
            MpAlarm.start()
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
    if(intent!!.getStringExtra("data")=="cat")
        MPCat.start()
    if(intent!!.getStringExtra("data")=="alarm")
        MpAlarm.start()
    }
}