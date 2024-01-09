package com.example.iec

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Activity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_3)
        val btnkB=findViewById<Button>(R.id.bkB)
        val btnMB=findViewById<Button>(R.id.bMB)
        val btnGB=findViewById<Button>(R.id.bGB)
        val btnTB=findViewById<Button>(R.id.bTB)
        val i= Intent()
        btnkB.setOnClickListener{i.putExtra("prefix",Math.pow(10.0,3.0));setResult(RESULT_OK,i);finish() }
        btnMB.setOnClickListener{i.putExtra("prefix",Math.pow(10.0,6.0));setResult(RESULT_OK,i);finish() }
        btnGB.setOnClickListener{i.putExtra("prefix",Math.pow(10.0,9.0));setResult(RESULT_OK,i);finish() }
        btnTB.setOnClickListener{i.putExtra("prefix",Math.pow(10.0,12.0));setResult(RESULT_OK,i);finish() }
    }
}