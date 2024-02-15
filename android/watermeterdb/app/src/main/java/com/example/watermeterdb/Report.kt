package com.example.watermeterdb

import android.app.ListActivity
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SimpleCursorAdapter

class Report : ListActivity() {
 lateinit var DB:SQLiteDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_report)
        var conn=MyDatabase(this,"water.sqlite",null,1)
        DB=conn.writableDatabase
        FetchData()
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