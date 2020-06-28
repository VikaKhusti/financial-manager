package com.example.financialmanager

import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.content.Context
import android.content.ContentValues


class DBHandler(context: Context, name: String?,
                  factory: SQLiteDatabase.CursorFactory?, version: Int) :
    SQLiteOpenHelper(context, DATABASE_NAME,
        factory, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        val CREATE_USER_TABLE = ("CREATE TABLE " +
                TABLE_NAME + "("
                + COLUMN_BALANCE + " INTEGER," +
                COLUMN_INCOME
                + " INTEGER" + ")")
        db.execSQL(CREATE_USER_TABLE)

    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int,
                           newVersion: Int) {

    }

    companion object {

        private val DATABASE_VERSION = 1
        private val DATABASE_NAME = "user"
        val TABLE_NAME = "data"

        val COLUMN_BALANCE = "productname"
        val COLUMN_INCOME = "quantity"
    }

    fun addUser(userAccount: UserAccount) {
        val values = ContentValues()
        values.put(COLUMN_BALANCE, userAccount.balance)
        values.put(COLUMN_INCOME, userAccount.income)

        val db = this.writableDatabase

        db.insert(TABLE_NAME, null, values)
        db.close()
    }

    fun findProduct(record: String): UserAccount? {
        val query =
            "SELECT * FROM $TABLE_NAME"

        val db = this.writableDatabase

        val cursor = db.rawQuery(query, null)

        var record: UserAccount? = null

        if (cursor.moveToFirst()) {
            cursor.moveToFirst()

            val balance = Integer.parseInt(cursor.getString(0))
            val income = Integer.parseInt(cursor.getString(1))
            record = UserAccount(balance, income)
            cursor.close()
        }

        db.close()
        return record
    }
}

