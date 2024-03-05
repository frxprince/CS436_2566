package com.example.primekcoroutine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {
    lateinit var btnCalculate:Button
    lateinit var txtInput:EditText
    lateinit var txtOutput:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnCalculate=findViewById(R.id.bCalculate)
        txtInput=findViewById(R.id.eInput)
        txtOutput=findViewById(R.id.tOutput)

        btnCalculate.setOnClickListener { worker()  }
    }
    fun worker()= runBlocking {
      val deferedResult:Deferred<Long> = async{
          Calculate(txtInput.text.toString().toLong())
    }
         var ans=deferedResult.await()
        txtOutput.text=ans.toString()
    }
    suspend fun Calculate(k:Long):Long{
        return  primeK(k)
    }
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