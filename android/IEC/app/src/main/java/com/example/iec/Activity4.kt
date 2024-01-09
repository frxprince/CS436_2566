package com.example.iec

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Activity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_4)
     val i = Intent()
     val btnkiB=findViewById<Button>(R.id.bkiB)
     val btnMiB=findViewById<Button>(R.id.bMiB)
     val btnGiB=findViewById<Button>(R.id.bGiB)
     val btnTiB=findViewById<Button>(R.id.bTiB)
    btnkiB.setOnClickListener { i.putExtra("target",Math.pow(2.0,10.0));setResult(RESULT_OK,i);finish() }
    btnMiB.setOnClickListener {  i.putExtra("target",Math.pow(2.0,20.0));setResult(RESULT_OK,i);finish()  }
    btnGiB.setOnClickListener {  i.putExtra("target",Math.pow(2.0,30.0));setResult(RESULT_OK,i);finish()  }
    btnTiB.setOnClickListener {  i.putExtra("target",Math.pow(2.0,40.0));setResult(RESULT_OK,i);finish()  }
    }
}