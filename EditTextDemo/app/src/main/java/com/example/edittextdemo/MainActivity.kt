package com.example.edittextdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var emailtext : EditText = findViewById(R.id.editTextTextEmailAddress)
        var btn : Button = findViewById(R.id.button)

        
        var acity:AutoCompleteTextView=findViewById(R.id.atcity)
        var city = arrayOf("rajkot","surat","bagodra")
        var adapter=ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,city)
        acity.setAdapter(adapter)


       var skill : MultiAutoCompleteTextView=findViewById(R.id.emu)
       var s= arrayOf("devloper","web","app devloper") var sk= ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,s)
        skill.setAdapter(sk)
        skill.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())

        btn.isEnabled = false;



        emailtext.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(char: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    if (android.util.Patterns.EMAIL_ADDRESS.matcher(char).matches()){
                    btn.isEnabled = true

                }
                else{
                    emailtext.setError("Invalid Email!")
                    btn.isEnabled = false
                }

            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })

    }
}