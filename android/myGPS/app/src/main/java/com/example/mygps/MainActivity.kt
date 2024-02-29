package com.example.mygps

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.location.OnNmeaMessageListener
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity(),LocationListener,OnNmeaMessageListener {
    lateinit var txtLatLong:TextView
    lateinit var txtNmea:TextView
    lateinit var gps:LocationManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnClear=findViewById<Button>(R.id.bClear)
        txtNmea=findViewById(R.id.tMmea)
        txtLatLong=findViewById(R.id.tLatLong)
        btnClear.setOnClickListener { txtNmea.setText("") }
if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION)!=PackageManager.PERMISSION_GRANTED)
requestPermissions(arrayOf(Manifest.permission.ACCESS_FINE_LOCATION,
    Manifest.permission.ACCESS_COARSE_LOCATION),1234)
gps=getSystemService(LOCATION_SERVICE) as LocationManager
gps.addNmeaListener(this)
    }
    override fun onNmeaMessage(message: String?, timestamp: Long) {
txtNmea.text= "$timestamp: $message \n"+ txtNmea.text.toString()
    }
    override fun onResume() {
        super.onResume()
    if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION)==PackageManager.PERMISSION_GRANTED)
    gps.requestLocationUpdates(LocationManager.GPS_PROVIDER,1000,10f,this)
    }
    override fun onPause() {
        super.onPause()
    gps.removeUpdates(this)
    }

    override fun onLocationChanged(location: Location) {
   txtLatLong.text="Lat:${location.latitude}\nLong:${location.longitude}\nAlt:${location.altitude
   }\nBearing${location.bearing}\nSpeed:${location.speed}\nClock:${location.time}      "
    }


}