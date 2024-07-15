package com.example.text

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var city : AutoCompleteTextView = findViewById(R.id.autoCompleteTextView)
        var arcity = arrayOf("Junagadh","Rajkot","Surat","Jamnager","Ahmadabad")
        var adapter = ArrayAdapter(this,android.R.layout.simple_selectable_list_item,arcity)
        city.setAdapter(adapter)

    }
}