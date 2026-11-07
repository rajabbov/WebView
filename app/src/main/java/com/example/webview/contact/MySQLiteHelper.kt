package com.example.webview.contact

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MySQLiteHelper(context: Context):SQLiteOpenHelper(context,"my.db",null,2) {
    companion object{
        const val TableName="People"
        const val id="_id"
        const val name="name"
        const val age="age"
        const val phone="phone"
        const val address="address"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("create table $TableName(" +
        "$id integer primary key autoincrement,"+
        "$name text,"+
        "$age integer,"+
         "$phone integer,"+
        "$address text)"
        )
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
     db?.execSQL("drop table if exists $TableName")
        onCreate(db)
    }
}