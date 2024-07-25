package com.example.listview2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var list : ListView = findViewById(R.id.listview)
        var city = arrayOf("junagadh","rajkot","ahmadabad","surat","jamanagar")
        var adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,city)
        list.adapter = adapter

        list.setOnItemClickListener { adapterView, view, i, l ->
            var value = list.getItemAtPosition(i).toString()
//            Toast.makeText(applicationContext,value,Toast.LENGTH_LONG).show()

            var i = Intent(this,Jnd::class.java)
            i.putExtra("value",value.toString())
            startActivity(i)
        }


    }
}