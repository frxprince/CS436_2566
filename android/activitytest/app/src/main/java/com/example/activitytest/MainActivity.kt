package com.example.activitytest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
     Log.i("myactivity","onCreate!")
        val btn=findViewById<Button>(R.id.button)
        btn.setOnClickListener { finish() }
    }

    override fun onStart() {
        super.onStart()
        Log.i("myactivity","onStart!")
    }

    override fun onResume() {
        super.onResume()
        Log.i("myactivity","onResume!")
    }

    override fun onPause() {
        super.onPause()
        Log.i("myactivity","onPause!")
    }

    override fun onStop() {
        super.onStop()
        Log.i("myactivity","onStop!")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("myactivity","onRestart!")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("myactivity","onDestroy!")
    }
}