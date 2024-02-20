package com.example.mysensors

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity(),AdapterView.OnItemSelectedListener,
SensorEventListener{
 lateinit var txtInfo:TextView
 lateinit var txtValue:TextView
 lateinit var manager:SensorManager
 lateinit var sensor:Sensor
 lateinit var allSensor: MutableList<Sensor>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
  txtInfo=findViewById(R.id.tInfo)
  txtValue=findViewById(R.id.tValue)
  val spinner=findViewById<Spinner>(R.id.spinner)
  manager=getSystemService(Context.SENSOR_SERVICE) as SensorManager
  allSensor=manager.getSensorList(Sensor.TYPE_ALL)
  var sensor_name= mutableListOf<String>()
   for(name in allSensor){sensor_name.add(name.name)}
   var adapter=ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
       sensor_name)
       spinner.adapter=adapter;spinner.onItemSelectedListener=this
       sensor=allSensor[0]
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
     if(sensor!=null)manager.unregisterListener(this,sensor)
        sensor=allSensor[position]
     txtInfo.text="Name:${sensor.name}\nVanter:${sensor.vendor}\nVersion:${sensor.version}\nMax:${sensor.maximumRange
     }\nResolution:${sensor.resolution}"
     manager.registerListener(this,sensor,SensorManager.SENSOR_DELAY_NORMAL)
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }

    override fun onPause() {
        super.onPause()
        manager.unregisterListener(this,sensor)
    }

    override fun onSensorChanged(event: SensorEvent?) {
var msg:String=""
        for((index,item) in event!!.values.withIndex())msg=msg+"parameter[$index]= $item\n"
 txtValue.text=msg
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }
}