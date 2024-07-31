package com.example.preference

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var unm : EditText = findViewById(R.id.ed_unm)
        var pass : EditText = findViewById(R.id.ed_pass)
        var save : Button = findViewById(R.id.btn_save)
        var view : Button = findViewById(R.id.btn_disp)

        var sp = application.getSharedPreferences("Login",Context.MODE_PRIVATE)
        var editor = sp.edit()

        save.setOnClickListener {
            editor.putString("uname",unm.text.toString())
            editor.putString("pass",pass.text.toString())
            editor.commit()
            Toast.makeText(applicationContext,"Data Save Success..",Toast.LENGTH_SHORT).show()
            unm.setText("")
            pass.setText("")
        }

        view.setOnClickListener {
            unm.setText(sp.getString("uname",""))
            pass.setText(sp.getString("pass",""))
        }
    }
}