package com.example.metricconvert

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
      /*  val text1:TextView
        text1=findViewById(R.id.textView1)*/
        val text1=findViewById<TextView>(R.id.textView1)
        val btn1=findViewById<Button>(R.id.button1)
        val txtinput=findViewById<EditText>(R.id.inputnumber)
        val btn3=findViewById<Button>(R.id.button3).setOnClickListener { finish() }
        btn1.setOnClickListener {
             try {
                 text1.text = " ${"%.3f".format(txtinput.text.toString().toDouble() / 2.54)} inch"
             } catch (e: Exception) {
                 text1.text="invalid format"
             }
        }
     val btn2=findViewById<Button>(R.id.button2)
        btn2.setOnClickListener {
            text1.text=" ${txtinput.text.toString().toDouble()*2.54} cm"
        }
    }
}