package com.example.iec

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import java.text.DecimalFormat

class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        overridePendingTransition(R.anim.slide_up,R.anim.slide_down)
        setContentView(R.layout.activity_2)
        val txttbase=findViewById<TextView>(R.id.tbase)
        val txtinput=findViewById<EditText>(R.id.eInput)
    val Activity3Result=registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        result:ActivityResult->if(result.resultCode== RESULT_OK){
            txttbase.text="%.4f".format(txtinput.text.toString().toDouble() *
                    result.data!!.getDoubleExtra("prefix",0.0))
        }
    }

     val bthPrefix=findViewById<Button>(R.id.bPrefix)
        bthPrefix.setOnClickListener {
val i =Intent(this,Activity3::class.java)
 Activity3Result.launch(i)
        }

    val btnconvert=findViewById<Button>(R.id.bConvert)
    val Activity4Result=registerForActivityResult( ActivityResultContracts.StartActivityForResult()){
    result:ActivityResult->if(result.resultCode== RESULT_OK){
   val res= txttbase.text.toString().toDouble()/ result.data!!.getDoubleExtra("target",1.0)
   Log.v("answer",res.toString())
   val i=Intent(this,Activity5::class.java)
   i.putExtra("result", DecimalFormat("#,###,###.###").format(res))
   startActivity(i)
    }
    }
   btnconvert.setOnClickListener { val i=Intent(this, Activity4::class.java)
   Activity4Result.launch(i)
   }
    }

    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.slide_up,R.anim.slide_down)
    }
}