package com.example.primekthread

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import java.security.KeyStore.TrustedCertificateEntry
import kotlin.math.round

class MainActivity : AppCompatActivity() {
    lateinit var btnCalculate:Button
    lateinit var txtInput:EditText
    lateinit var txtOutput:TextView
    lateinit var progressbar:ProgressBar
  

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
   btnCalculate=findViewById(R.id.bCalculate)
   txtInput=findViewById(R.id.eInput)
   txtOutput=findViewById(R.id.tOutput)
   progressbar=findViewById(R.id.progressBar)
        val btnPause=findViewById<Button>(R.id.bPause)

progressbar.max=100
   var worker:PrimeKThread
   btnCalculate.setOnClickListener {
     // txtOutput.text= primeK(txtInput.text.toString().toLong()).toString()
      worker=object:PrimeKThread(txtInput.text.toString().toLong()){
          override fun ShowResult(ans: Long) {
              this@MainActivity.runOnUiThread(Runnable {txtOutput.text=ans.toString()})
          }
          override fun ShowProgress(progress: Int) {
  this@MainActivity.runOnUiThread(Runnable {progressbar.progress=progress})
          }
      }
       worker.start()

       btnPause.setOnClickListener {    worker.Pause()   }   }
    }
   abstract class PrimeKThread(val k:Long):Thread(){
       var running=true
       override fun run() {
           super.run()
           running=true
           val ans=primeK(k)
           ShowResult(ans)
       }
       fun Pause(){
           running=!running
       }
       abstract fun ShowResult(ans:Long)
       abstract fun ShowProgress(progress:Int)
       fun isPrime(x:Long):Boolean{
           for(i in 2..x-1)
               if ((x%i) == 0L)
                   return false
           return true
       }
       fun primeK(x:Long):Long{
           var i=3L
           var c=0L
           while(running){
               if(isPrime(i))
               {
                   c++
                   ShowProgress(round((c/x.toFloat())*100).toInt())
                   if(c==x)
                       return i
               }
               i++
           }
           return 0
       }
   }
}