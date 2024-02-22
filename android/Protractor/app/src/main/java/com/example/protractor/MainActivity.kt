package com.example.protractor

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.TextView
import kotlin.math.PI
import kotlin.math.atan2

class MainActivity : AppCompatActivity(),SensorEventListener {
 lateinit var seekbar:SeekBar
 lateinit var txtDegree:TextView
 lateinit var txtData:TextView
 lateinit var manager:SensorManager
 lateinit var sensor:Sensor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        seekbar=findViewById(R.id.seekBar)
        txtDegree=findViewById(R.id.tDegree)
        txtData=findViewById(R.id.tData)
  manager=getSystemService(SENSOR_SERVICE) as SensorManager
  sensor=manager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER) as Sensor
        seekbar.max=180
seekbar.background=getDrawable(R.mipmap.fg)
seekbar.progressDrawable=getDrawable(R.mipmap.bg)
    }
    override fun onResume() { super.onResume(); manager.registerListener(this,sensor,SensorManager.SENSOR_DELAY_NORMAL)
    }
    override fun onPause() {  super.onPause();manager.unregisterListener(this,sensor)
    }

    override fun onSensorChanged(event: SensorEvent?) {
     txtData.text=" X:${event!!.values[0]}\nY:${event!!.values[1]} \nZ:${event!!.values[2]}     "
     var deg=180-((atan2(event.values[0],event.values[1])*180.0)/PI)-90
     txtDegree.text="$deg";  seekbar.progress=(90-deg).toInt()
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }
}