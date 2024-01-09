package com.example.iec

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Activity5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_5)
   val txtoutput=findViewById<TextView>(R.id.tOutput)
   val btnBack=findViewById<Button>(R.id.bBack)
   btnBack.setOnClickListener { finish() }
   txtoutput.text=  intent.getStringExtra("result")

    }
}