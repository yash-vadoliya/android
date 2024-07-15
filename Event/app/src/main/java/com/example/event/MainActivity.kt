package com.example.event

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var text:TextView=findViewById(R.id.textView)
        text.setOnClickListener {
            Toast.makeText(applicationContext, "HALO DOSA KHAVA HALO", Toast.LENGTH_SHORT).show()
        }
    }
}