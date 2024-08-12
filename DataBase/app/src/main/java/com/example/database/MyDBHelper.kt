package com.example.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.security.AccessControlContext

class MyDBHelper(context: Context) : SQLiteOpenHelper(context,"STUDENT_DB", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE STUD (SID INTEGER PRIMARY KEY AUTOINCREMENT,SNAME TEXT,SEM NUMBER)")
        db?.execSQL("INSERT INTO STUD (SNAME, SEM) VALUES ('Yash',3)")
        db?.execSQL("INSERT INTO STUD (SNAME, SEM) VALUES ('Mukesh',3)")
        db?.execSQL("INSERT INTO STUD (SNAME, SEM) VALUES ('Rahul',3)")

    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }

}