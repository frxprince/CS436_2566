package com.example.smsremote

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    val btn=findViewById<Button>(R.id.button)
    btn.setOnClickListener { finish() }
if (checkSelfPermission(Manifest.permission.RECEIVE_SMS)!=PackageManager.PERMISSION_GRANTED)
 requestPermissions(arrayOf(Manifest.permission.RECEIVE_SMS),1234)
    }
}