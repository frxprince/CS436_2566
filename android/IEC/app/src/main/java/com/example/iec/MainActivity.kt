package com.example.iec

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    val txt=findViewById<TextView>(R.id.welcome)
    txt.setOnClickListener {
    val i= Intent(this,Activity2::class.java)
    Log.v("Intent",i.toString())
     startActivity(i)
    }

    }
}