package com.example.geolocation

import android.content.pm.PackageManager
import android.location.Geocoder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.app.ActivityCompat
import java.security.Permission
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var ed : EditText
    lateinit var btn : Button
    lateinit var tv : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ed = findViewById(R.id.edittext)
        btn = findViewById(R.id.button)
        tv = findViewById(R.id.text2)

        if(ActivityCompat.checkSelfPermission(this,android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION,android.Manifest.permission.ACCESS_COARSE_LOCATION),111)
        }else{
            btn.setOnClickListener{
                var city = ed.text.toString()
                forwardGeocode(city)
            }
        }

    }

    private fun forwardGeocode(city: String) {
        var gc = Geocoder(this, Locale.getDefault())
        var addresses = gc.getFromLocationName(city,2)
        var address = addresses.get(0)
        tv.setText("${address.longitude}\n${address.latitude}")

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode == 111 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            var city = ed.text.toString()
            forwardGeocode(city)
        }
    }
}