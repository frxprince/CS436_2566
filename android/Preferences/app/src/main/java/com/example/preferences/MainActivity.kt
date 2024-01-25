package com.example.preferences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.core.content.edit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnLoad=findViewById<Button>(R.id.bLoad)
        val btnSave=findViewById<Button>(R.id.bSave)
        val text=findViewById<EditText>(R.id.editTextTextMultiLine)
        val btnExit=findViewById<Button>(R.id.bExit)
btnExit.setOnClickListener { finish() }
btnLoad.setOnClickListener {
  var p=getSharedPreferences("my_preference", MODE_PRIVATE)
  val config=p.all
  text.setText(config.get("data")?.toString()?:"No data")
}
btnSave.setOnClickListener {
    var p=getSharedPreferences("my_preference", MODE_PRIVATE)
    p.edit {
     putString("data",text.text.toString())
     commit()
    }
}
    }
}