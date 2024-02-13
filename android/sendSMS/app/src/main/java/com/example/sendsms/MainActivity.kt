package com.example.sendsms

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.SmsManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnSend=findViewById<Button>(R.id.bSend)
        val txtMessage=findViewById<EditText>(R.id.eTxtMessage)
        val txtNumber=findViewById<EditText>(R.id.ePhoneNumber)
        val txtStatus=findViewById<TextView>(R.id.tStatus)
if (checkSelfPermission(Manifest.permission.SEND_SMS)!=PackageManager.PERMISSION_GRANTED)
 requestPermissions(arrayOf(Manifest.permission.SEND_SMS),1234)
if (checkSelfPermission(Manifest.permission.READ_PHONE_STATE)!=PackageManager.PERMISSION_GRANTED)
  requestPermissions(arrayOf(Manifest.permission.READ_PHONE_STATE),1234)

btnSend.setOnClickListener {
val smsmanager=getSystemService(SmsManager::class.java)
smsmanager.sendTextMessage(txtNumber.text.toString(),null,txtMessage.text.toString(),
    null,null)
}

    }
}