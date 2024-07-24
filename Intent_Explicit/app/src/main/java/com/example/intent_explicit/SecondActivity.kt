package com.example.intent_explicit

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        var tnm : TextView = findViewById(R.id.name)
        var tsnm : TextView = findViewById(R.id.Sname)

        var i = intent
        var inm = i.getStringExtra("name")
        var isnm = i.getStringExtra("sname")

        tnm.setText("Name : " + inm)
        tsnm.setText("Surname : "+isnm)

        var web : EditText = findViewById(R.id.edit_web)
        var btnweb : Button = findViewById(R.id.btn_web)

        btnweb.setOnClickListener {
            var uri = Uri.parse(""+web.text.toString())
            var i = Intent(Intent.ACTION_VIEW,uri)
            startActivity(i)
        }

        var dial : EditText = findViewById(R.id.edit_dial)
        var btndial : Button = findViewById(R.id.btn_dial)

        btndial.setOnClickListener {
            var uri = Uri.parse("tel:"+dial.text.toString())
            var i = Intent(Intent.ACTION_DIAL,uri)
            startActivity(i)
        }

        var loc : Button = findViewById(R.id.btn_loc)

        loc.setOnClickListener {
            var uri = Uri.parse("geo:0,0=?"+"Junagadh")
            var i = Intent(Intent.ACTION_VIEW,uri)
            startActivity(i)
        }

    }
}