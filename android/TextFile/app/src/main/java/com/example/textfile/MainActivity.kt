package com.example.textfile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.widget.Button
import android.widget.EditText
import java.io.File
import java.io.FileOutputStream

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    val btnResource=findViewById<Button>(R.id.bResource)
    val btnAssets=findViewById<Button>(R.id.bAssets)
    val btnSaveSD=findViewById<Button>(R.id.bWriteSDCARD)
    val btnReadSD=findViewById<Button>(R.id.bReadSDCARD)
    val txtFilename=findViewById<EditText>(R.id.eFilename)
    val txtMessage=findViewById<EditText>(R.id.eMultiline)
 btnSaveSD.setOnClickListener {
 val file= File(Environment.getExternalStorageDirectory().absolutePath+"/"+
 Environment.DIRECTORY_DOCUMENTS+"/"+txtFilename.text.toString())
 var outputstream=FileOutputStream(file)
 outputstream.write(txtMessage.text.toString().toByteArray(Charsets.UTF_8))
 outputstream.flush()
 outputstream.close()
 }

btnReadSD.setOnClickListener {
    val file= File(Environment.getExternalStorageDirectory().absolutePath+"/"+
            Environment.DIRECTORY_DOCUMENTS+"/"+txtFilename.text.toString())
    val lines=file.bufferedReader(Charsets.UTF_8).readLines()
    var msg=""
    for(line in lines)msg=msg+line+"\n"
    txtMessage.setText(msg)
}

    btnResource.setOnClickListener {
var file=resources.openRawResource(R.raw.genesis01)
var lines=file.bufferedReader(Charsets.UTF_8).readLines()
        var msg=""
        for(line in lines)msg=msg+line+"\n"
    txtMessage.setText(msg)
    }
    btnAssets.setOnClickListener {
        var file=assets.open("data/pangram.txt")
        var lines=file.bufferedReader(Charsets.UTF_8).readLines()
        var msg=""
        for(line in lines)msg=msg+line+"\n"
        txtMessage.setText(msg)
    }
    }
}