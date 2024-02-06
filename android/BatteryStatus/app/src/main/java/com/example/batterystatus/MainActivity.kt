package com.example.batterystatus

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    val progress=findViewById<ProgressBar>(R.id.progressBar)
    val txt=findViewById<TextView>(R.id.textView)
    progress.max=100
    var battery=object:MyReceiver(){
        override fun update(batteryLv: Float, USB: Int,temp:Float) {
          progress.progress=batteryLv.toInt()
          var usb_status=when(USB){
            BatteryManager.BATTERY_STATUS_CHARGING->"Charging"
              BatteryManager.BATTERY_STATUS_FULL->"Full"
              BatteryManager.BATTERY_STATUS_DISCHARGING->"Discharge"
              BatteryManager.BATTERY_STATUS_NOT_CHARGING->"Not charge"
              else->"I don't know"
          }
          txt.text="$USB  $temp \n$usb_status"
        }
    }
    registerReceiver(battery, IntentFilter(Intent.ACTION_BATTERY_CHANGED))
    }
 abstract class MyReceiver:BroadcastReceiver() {
     override fun onReceive(context: Context?, intent: Intent?) {
     var level=intent?.getIntExtra(BatteryManager.EXTRA_LEVEL,0)?:0
     var scale=intent?.getIntExtra(BatteryManager.EXTRA_SCALE,1)?:0
     var batteryLV=(level/scale.toFloat())*100
     var charging=intent?.getIntExtra(BatteryManager.EXTRA_STATUS,0)?:0
     var temp=intent?.getFloatExtra(BatteryManager.EXTRA_TEMPERATURE,0f) ?:0f
       update(batteryLV,charging,temp)
     }
     abstract fun update(batteryLv:Float,USB:Int,temp:Float)
 }
}