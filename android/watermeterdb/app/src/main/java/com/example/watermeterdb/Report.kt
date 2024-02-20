package com.example.watermeterdb

import android.app.ListActivity
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.SimpleCursorAdapter

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