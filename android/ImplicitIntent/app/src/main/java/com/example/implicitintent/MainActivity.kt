package com.example.implicitintent

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.ContactsContract
import android.util.Log
import android.widget.Button
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    val btnWeb=findViewById<Button>(R.id.bWebsite)
    val btnAlarm=findViewById<Button>(R.id.bAlarm)
    val btnMap=findViewById<Button>(R.id.bMap)
    val btnPhonebook=findViewById<Button>(R.id.bPhonebook)
    btnWeb.setOnClickListener {
       var i= Intent(Intent.ACTION_VIEW, Uri.parse("http://www.drpaween.com"))
      if (i.resolveActivity((packageManager))!=null) {
          startActivity(i)
      }else{
          btnWeb.text="No browser installed"
      }
    }
        btnAlarm.isEnabled=false
   if(ContextCompat.checkSelfPermission(this,Manifest.permission.SET_ALARM) !=
       PackageManager.PERMISSION_GRANTED) {
    ActivityCompat.requestPermissions( this,arrayOf(Manifest.permission.SET_ALARM),1234)
       Log.v("permission","no permission")
   }else{
       btnAlarm.isEnabled=true
   }

    btnAlarm.setOnClickListener {
val i =Intent(AlarmClock.ACTION_SET_TIMER)
    i.putExtra(AlarmClock.EXTRA_LENGTH,15)
    i.putExtra(AlarmClock.EXTRA_SKIP_UI,true)
    i.putExtra(AlarmClock.EXTRA_MESSAGE," Time up!!!!")
    startActivity(i)
    }
    btnMap.setOnClickListener {
  val i=Intent(Intent.ACTION_VIEW,Uri.parse("geo:13.7475593,100.4850394"))
        startActivity(i)
    }
btnPhonebook.setOnClickListener {
    val i=Intent(Intent.ACTION_PICK,ContactsContract.Contacts.CONTENT_URI)
    startActivityForResult(i,12324)
}
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.v("Phonebook",data.toString())
    }
}