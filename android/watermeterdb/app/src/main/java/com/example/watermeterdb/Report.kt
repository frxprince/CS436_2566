package com.example.watermeterdb

import android.app.ListActivity
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.SimpleCursorAdapter
import java.io.File
import java.io.FileOutputStream

class Report : ListActivity() {
 lateinit var DB:SQLiteDatabase
 var ID:String=""
    lateinit var  txtMeterID:EditText
    lateinit var txtMeterValue:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_report)
         txtMeterID=findViewById<EditText>(R.id.eReportMeterID)
         txtMeterValue=findViewById<EditText>(R.id.eReportMeterValue)
        val btnUpdate=findViewById<Button>(R.id.bUpdate)
        val btnDelete=findViewById<Button>(R.id.bDelete)
        val btnExport=findViewById<Button>(R.id.bExport)
        var conn=MyDatabase(this,"water.sqlite",null,1)
        DB=conn.writableDatabase
        FetchData()
        btnUpdate.setOnClickListener {
     DB.execSQL("update waterdata set meter_id=${txtMeterID.text.toString()}" +
             ", meter_value=${txtMeterValue.text.toString()} where id=$ID")
     FetchData()
        }
        btnDelete.setOnClickListener {
            DB.execSQL("delete from waterdata where id=$ID");FetchData()
        }
     btnExport.setOnClickListener {
         var file= File(Environment.getExternalStorageDirectory().absolutePath+"/"+
         Environment.DIRECTORY_DOCUMENTS+"/databaseExport.csv")
         file.createNewFile()
         var outputfile=FileOutputStream(file)
         var cursor=DB.rawQuery("select id,meter_id,meter_value,timestamp from waterdata",null)
         outputfile.write("ID,meter_id,meter_value,timestamp\n".toByteArray(Charsets.UTF_8))
         while (cursor.moveToNext()){
     outputfile.write("${cursor.getString(0)},${cursor.getString(1)
     },${cursor.getString(2)},${cursor.getString(3)}\n".toByteArray())
     outputfile.flush()
         }
         outputfile.close()
     }
    }
    override fun onListItemClick(l: ListView?, v: View?, position: Int, id: Long) {
        super.onListItemClick(l, v, position, id)
     var cursor=listAdapter.getItem(position) as Cursor
     txtMeterID.setText(cursor.getString(2))
     txtMeterValue.setText(cursor.getString(3))
     ID=cursor.getString(0)
    }

    fun FetchData(){
   var cursor=DB.rawQuery("select id as _id, id,meter_id,meter_value,timestamp " +
           "from waterdata",null)
   var column= arrayOf("id","meter_id","meter_value","timestamp")
   var map_to= intArrayOf(R.id.tID,R.id.tMeterID,R.id.tMeterValue,R.id.tTimestamp)
 val myAdapter=SimpleCursorAdapter(this,R.layout.listview_item,
     cursor,column,map_to,0)
 listAdapter=myAdapter
 }
}