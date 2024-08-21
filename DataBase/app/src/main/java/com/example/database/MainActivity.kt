package com.example.database

import android.content.ContentValues
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    lateinit var edit_sname : EditText
    lateinit var edit_sem : EditText
    lateinit var btn_insert : Button
    lateinit var btn_update : Button
    lateinit var btn_delete : Button
    lateinit var btn_clear : Button
    lateinit var btn_next : Button
    lateinit var btn_prev : Button
    lateinit var btn_first : Button
    lateinit var btn_last : Button
    lateinit var rs : Cursor
    lateinit var btn_show : Button
    lateinit var listView : ListView
    lateinit var serch : SearchView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edit_sname = findViewById(R.id.edit_sname)
        edit_sem = findViewById(R.id.edit_sem)
        btn_insert = findViewById(R.id.btn_insert)
        btn_update = findViewById(R.id.btn_update)
        btn_delete = findViewById(R.id.btn_delete)
        btn_clear = findViewById(R.id.btn_clear)
        btn_next = findViewById(R.id.btn_next)
        btn_prev = findViewById(R.id.btn_prev)
        btn_first = findViewById(R.id.btn_first)
        btn_last = findViewById(R.id.btn_last)
        btn_show = findViewById(R.id.btn_show)
        listView = findViewById(R.id.listview)
        serch = findViewById(R.id.serch)


        var helper = MyDBHelper(applicationContext)
        var db = helper.writableDatabase
        Toast.makeText(applicationContext, "Database and table cerated", Toast.LENGTH_SHORT).show()
        rs = db.rawQuery("Select SID _id , SNAME , SEM FROM STUD ",null)
        if(rs.moveToFirst())
        {
            edit_sname.setText(rs.getString(1))
            edit_sem.setText(rs.getString(2))
        }


        btn_insert.setOnClickListener {
            var cv = ContentValues()
            cv.put("SNAME",edit_sname.text.toString())
            cv.put("SEM",edit_sem.text.toString())
            db.insert("STUD",null,cv)
            rs = db.rawQuery("Select SID,SNAME,SEM from STUD",null)
            showMessage("Record Insert Successfully..")
        }

        btn_update.setOnClickListener {
            var cv = ContentValues()
            cv.put("SNAME",edit_sname.text.toString())
            cv.put("SEM",edit_sem.text.toString())
            db.update("STUD",cv,"SID = ?", arrayOf(rs.getString(0)))
            rs = db.rawQuery("Select SID,SNAME,SEM from STUD",null)
            showMessage("Record Updated Successfully..")
            Clear()
        }

        btn_delete.setOnClickListener {
            db.delete("STUD","SID = ?", arrayOf(rs.getString(0)))
            rs = db.rawQuery("Select SID,SNAME,SEM from STUD",null)
            showMessage("Record Delete Successfully..")
            Clear()
        }

        btn_clear.setOnClickListener {
            Clear()
        }

        btn_next.setOnClickListener {
            if(rs.moveToFirst())
            {
                edit_sname.setText(rs.getString(1))
                edit_sem.setText(rs.getString(2))
            }else{
                Toast.makeText(applicationContext,"Data Not Found",Toast.LENGTH_SHORT).show()
            }
        }

        btn_prev.setOnClickListener {
            if(rs.moveToPrevious())
            {
                edit_sname.setText(rs.getString(1))
                edit_sem.setText(rs.getString(2))
            }else if(rs.moveToFirst()){
                edit_sname.setText(rs.getString(1))
                edit_sem.setText(rs.getString(2))
            }else{
                Toast.makeText(applicationContext,"Data Not Found",Toast.LENGTH_SHORT).show()
            }
        }

        btn_first.setOnClickListener {
            if(rs.moveToFirst())
            {
                edit_sname.setText(rs.getString(1))
                edit_sem.setText(rs.getString(2))
            }else{
                Toast.makeText(applicationContext,"Data Not Found",Toast.LENGTH_SHORT).show()
            }
        }

        btn_last.setOnClickListener {
            if(rs.moveToLast())
            {
                edit_sname.setText(rs.getString(1))
                edit_sem.setText(rs.getString(2))
            }else{
                Toast.makeText(applicationContext,"Data Not Found",Toast.LENGTH_SHORT).show()
            }
        }

        btn_show.setOnClickListener {
            var adapter = SimpleCursorAdapter(applicationContext,R.layout.my_layout,rs,
                arrayOf("SNAME","SEM"),intArrayOf(R.id.text,R.id.text2))
            listView.adapter = adapter

            serch.setOnQueryTextListener( object : SearchView.OnQueryTextListener{
                override fun onQueryTextSubmit(p0: String?): Boolean {
                    return false
                }

                override fun onQueryTextChange(p0: String?): Boolean {
                    rs = db.rawQuery("SELECT SID _id,SNAME,SEM FROM STUD WHERE SNAME LIKE '%${p0}%'",null)
                    adapter.changeCursor(rs)
                    return false
                }

            })

        }

    }

    private fun Clear()
    {
        edit_sname.setText("")
        edit_sem.setText("")
        edit_sname.requestFocus()

    }

    private fun showMessage(s: String){
        AlertDialog.Builder(this)
            .setTitle("Message")
            .setMessage(s)
            .setPositiveButton("OK", {dialogInterface, i->
                if(rs.moveToFirst()){
                    edit_sname.setText(rs.getString(1))
                    edit_sem.setText(rs.getString(2))
                }else{
                    Toast.makeText(applicationContext,"Data Not Found..",Toast.LENGTH_SHORT).show()
                }
            }).show()
    }
}