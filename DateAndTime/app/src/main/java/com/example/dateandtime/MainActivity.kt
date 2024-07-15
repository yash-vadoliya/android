package com.example.dateandtime

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.DatePicker
import android.widget.EditText
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var date : EditText = findViewById(R.id.editTextDate)
        var c = Calendar.getInstance()

        date.setOnClickListener {
            DatePickerDialog(this,DatePickerDialog.OnDateSetListener { datePicker, day, month, year  ->
                date.setText("$day/${month+1}/$year")
            },
                c.get(Calendar.YEAR),c.get(Calendar.MONTH),c.get(Calendar.DAY_OF_MONTH)).show()
        }
    }
}