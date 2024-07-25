package com.example.listview2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class Jnd : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jnd)

        var btn : Button = findViewById(R.id.button)
        var txt : TextView = findViewById(R.id.textView2)
        var img : ImageView = findViewById(R.id.imageView2)


        var i2 = intent
        var nm = i2.getStringExtra("value")
        txt.setText(nm)

        var imgs = nm.toString()

//        "Junagadh","Rajkot","Ahmadabad","Surat","Jamanagar"


        if(nm == "Junagadh")
        {
            img.setImageResource(R.drawable.junagadh)
            txt.setText("City iS Junagadh")
        }
        else if (nm == "Rajkot")
        {
            img.setImageResource(R.drawable.rajkot)
            txt.setText("City iS Rajkot")
        }
        else if (nm == "Ahmadabad")
        {
            img.setImageResource(R.drawable.ahmadabad)
            txt.setText("City is Ahmadabad")
        }
        else if (nm == "Surat")
        {
            img.setImageResource(R.drawable.surat)
            txt.setText("City is Surat")
        }
        else if(nm == "Jamanagar")
        {
            img.setImageResource(R.drawable.jamanagar)
            txt.setText("City is Jamanagar")
        }

        btn.setOnClickListener {
            var i = Intent(this,MainActivity::class.java)
            startActivity(i)
        }
    }
}