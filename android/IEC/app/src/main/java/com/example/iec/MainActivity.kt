package com.example.iec

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.animation.AnimationUtils
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
   overridePendingTransition(R.anim.slide_up,R.anim.slide_down)
        setContentView(R.layout.activity_main)
    val txt=findViewById<TextView>(R.id.welcome)
    txt.startAnimation(AnimationUtils.loadAnimation(this,R.anim.blink))
    txt.setOnClickListener {
    val i= Intent(this,Activity2::class.java)
    Log.v("Intent",i.toString())
     startActivity(i)
    }
    }
    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.slide_up,R.anim.slide_down)
    }
}