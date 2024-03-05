package com.example.primekthread

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView

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
   var worker:PrimeKThread
   btnCalculate.setOnClickListener {
     // txtOutput.text= primeK(txtInput.text.toString().toLong()).toString()
      worker=object:PrimeKThread(txtInput.text.toString().toLong()){
          override fun ShowResult(ans: Long) {
             txtOutput.text=ans.toString()
          }
      }
       worker.start()
   }
    }
   abstract class PrimeKThread(val k:Long):Thread(){
       override fun run() {
           super.run()
           val ans=primeK(k)
       }
       abstract fun ShowResult(ans:Long)
       fun isPrime(x:Long):Boolean{

           for(i in 2..x-1)
               if ((x%i) == 0L)
                   return false
           return true
       }

       fun primeK(x:Long):Long{
           var i=3L
           var c=0L
           while(true){
               if(isPrime(i))
               {
                   c++
                   if(c==x)
                       return i
               }
               i++
           }
           return 0
       }
   }




}