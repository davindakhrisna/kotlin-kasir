package com.example.kasirr

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "kasir.db"
        private const val DATABASE_VERSION = 1
        private const val TABLE_NAME = "transactions"
        private const val COLUMN_ID = "id"
        private const val COLUMN_NAME = "name"
        private const val COLUMN_TABLE_NUMBER = "table_number"
        private const val COLUMN_ORDER = "order_detail"
        private const val COLUMN_TOTAL_PRICE = "total_price"
        private const val COLUMN_DATE_TIME = "date_time"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTable = "CREATE TABLE $TABLE_NAME ($COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT, $COLUMN_NAME TEXT, $COLUMN_TABLE_NUMBER TEXT, $COLUMN_ORDER TEXT, $COLUMN_TOTAL_PRICE INTEGER, $COLUMN_DATE_TIME TEXT)"
        db.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun addTransaction(name: String, tableNumber: String, orderDetail: String, totalPrice: Int, dateTime: String) {
        val db = this.writableDatabase
        val insertSQL = "INSERT INTO $TABLE_NAME ($COLUMN_NAME, $COLUMN_TABLE_NUMBER, $COLUMN_ORDER, $COLUMN_TOTAL_PRICE, $COLUMN_DATE_TIME) VALUES (?, ?, ?, ?, ?)"
        val statement = db.compileStatement(insertSQL)
        statement.bindString(1, name)
        statement.bindString(2, tableNumber)
        statement.bindString(3, orderDetail)
        statement.bindLong(4, totalPrice.toLong())
        statement.bindString(5, dateTime)
        statement.executeInsert()
        db.close()
    }
}
