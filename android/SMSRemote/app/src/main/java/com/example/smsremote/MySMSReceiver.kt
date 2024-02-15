package com.example.smsremote

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Telephony
import android.util.Log

class MySMSReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
 var message=Telephony.Sms.Intents.getMessagesFromIntent(intent)[0]
 Log.v("mySMS","From: ${message.displayOriginatingAddress} Msg:${message.displayMessageBody} ")
  var i=Intent(context,MainActivity::class.java)
  i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
  i.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
  if (message.displayMessageBody=="cat") {
      i.putExtra("data","cat")
      context.startActivity(i)
      Log.v("mySMS","CAT")
  }
        if (message.displayMessageBody=="alarm") {
            i.putExtra("data","alarm")
            context.startActivity(i)
        }
    }
}