package com.example.watermeterdb

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDatabase(
    context: Context?,
    name: String?,
    factory: SQLiteDatabase.CursorFactory?,
    version: Int
): SQLiteOpenHelper(context, name, factory, version) {
    override fun onCreate(db: SQLiteDatabase?) {
 var SQL="""
     CREATE TABLE "waterdata" (
         "id" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
         "meter_id" INTEGER NOT NULL,
         "meter_value" REAL NOT NULL,
         "timestamp" datetime default current_timestamp
     );
 """.trimIndent()
   db?.execSQL(SQL)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }
}