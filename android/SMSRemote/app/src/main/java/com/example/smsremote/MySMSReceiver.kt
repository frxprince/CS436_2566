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
    }
}