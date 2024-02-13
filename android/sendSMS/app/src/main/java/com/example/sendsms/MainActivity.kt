package com.example.sendsms

import android.Manifest
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
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
    
abstract class SMSSent:BroadcastReceiver(){
    override fun onReceive(context: Context?, intent: Intent?) {
     when(resultCode){
         RESULT_OK->show("SMS was sent")
         SmsManager.RESULT_ERROR_NO_SERVICE->show("No service")
         SmsManager.RESULT_ERROR_RADIO_OFF->show("Flight mode")
         else->show("Generic Error")
     }   
    }
   abstract fun show(msg:String)
}   
abstract  class SMSdelivered:BroadcastReceiver(){
    override fun onReceive(context: Context?, intent: Intent?) {
      if(resultCode== RESULT_OK){show("Message delivered")}else{show("Message Fail")}  
    }
    abstract fun show(msg:String)
    

}   
    
    
}