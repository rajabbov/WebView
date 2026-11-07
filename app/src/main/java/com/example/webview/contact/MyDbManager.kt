package com.example.webview.contact

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase

class MyDbManager(val context: Context) {
    private lateinit var sqLiteHelper:MySQLiteHelper
    private lateinit var database :SQLiteDatabase

    fun onCreate() {
        sqLiteHelper= MySQLiteHelper(context)
        database=sqLiteHelper.writableDatabase
    }
    fun insert(contactModel: ContactModel){
        val contentValue=ContentValues()
        contentValue.put(MySQLiteHelper.name,contactModel.name)
        contentValue.put(MySQLiteHelper.age,contactModel.age)
        contentValue.put(MySQLiteHelper.address,contactModel.address)
        contentValue.put(MySQLiteHelper.phone,contactModel.phoneNumber)
        database.insert(MySQLiteHelper.TableName,null,contentValue)

    }
    fun fetch(): Cursor?{
        val cursor=database.query(MySQLiteHelper.TableName, arrayOf(MySQLiteHelper.id,
                                                                    MySQLiteHelper.name,
                                                                     MySQLiteHelper.age,
                                                                     MySQLiteHelper.phone,
                                                                    MySQLiteHelper.address,),
        null,
        null,
        null,
        null,
        null,
        null
        )
        return if (cursor.moveToNext()){
            cursor
        }else{
            null
        }
    }
}