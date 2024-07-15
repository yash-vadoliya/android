package com.example.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var tx3 :  TextView = findViewById(R.id.textView3)

        tx3.setOnClickListener {
            Toast.makeText(applicationContext,"Hello Yash",Toast.LENGTH_LONG).show()
        }
    }
}