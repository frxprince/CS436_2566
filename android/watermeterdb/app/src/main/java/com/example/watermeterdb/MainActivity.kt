package com.example.watermeterdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    val txtMeterID=findViewById<EditText>(R.id.eMeterID)
    val txtMeterValue=findViewById<EditText>(R.id.eMeterValue)
    val btnSave=findViewById<Button>(R.id.bSave)
    val btnReport=findViewById<Button>(R.id.bReport)
    var conn=MyDatabase(this,"water.sqlite",null,1)
    var DB=conn.writableDatabase
btnSave.setOnClickListener {
DB.execSQL("insert into waterdata(meter_id,meter_value) " +
        " values(${txtMeterID.text.toString()},${txtMeterValue.text.toString()})")
    txtMeterID.setText("")
    txtMeterValue.setText("")
}

    }
}