package com.example.boxpainter

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context) : SQLiteOpenHelper(context, "myDB", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(
            "CREATE TABLE rectangles(" +
                    "id integer primary key autoincrement," +
                    "left float not null," +
                    "right float not null," +
                    "top float not null," +
                    "bottom float not null)"
        )


    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

    fun addRow(left1: Float, right1: Float, top1: Float, bottom1: Float) {
        val values = ContentValues();
        values.put("left", left1)
        values.put("right", right1)
        values.put("top", top1)
        values.put("bottom", bottom1)
        writableDatabase.apply {
            insert("rectangles", null, values)
            close()
        }
    }

    fun getAllValues(): List<data> {
        readableDatabase.apply {
            val cursor = query("rectangles", null, null, null, null, null, "id")
            val result = mutableListOf<data>()
            with(cursor) {
                if (count > 0)
                    while (moveToNext())
                        result.add(
                            data(
                                getString(getColumnIndex("left")).toFloat(),
                                getString(getColumnIndex("right")).toFloat(),
                                getString(getColumnIndex("top")).toFloat(),
                                getString(getColumnIndex("bottom")).toFloat()
                            )
                        )
                close()
            }
            return result
        }
    }

    fun delete(db: SQLiteDatabase?) {
        writableDatabase.delete("rectangles", null, null)

        db?.execSQL(
            "DELETE FROM rectangles"
        )

    }
}

