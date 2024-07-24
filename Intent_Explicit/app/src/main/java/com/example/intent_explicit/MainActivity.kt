package com.example.intent_explicit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btn : Button = findViewById(R.id.button)
        var nm : EditText = findViewById(R.id.editTextTextPersonName)
        var snm : EditText = findViewById(R.id.editTextTextPersonName2)

        btn.setOnClickListener {
            var i = Intent(this,SecondActivity::class.java)
            i.putExtra("name",nm.text.toString())
            i.putExtra("sname",snm.text.toString())
            startActivity(i)
        }
    }
}