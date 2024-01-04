package com.example.convertor2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val input= findViewById<EditText>(R.id.tInput)
        val rCm=findViewById<RadioButton>(R.id.rCm)
        val rInch=findViewById<RadioButton>(R.id.rInch)
        val btn=findViewById<Button>(R.id.button)
        val output=findViewById<TextView>(R.id.tOutput)
        btn.setOnClickListener {
       var factor= if(rCm.isChecked) 1/2.54 else 2.54
        output.text="%.4f".format(input.text.toString().toDouble()*factor)+
                if(rCm.isChecked) resources.getString(R.string.inch) else
                    resources.getString(R.string.cm)

        }
    }
}