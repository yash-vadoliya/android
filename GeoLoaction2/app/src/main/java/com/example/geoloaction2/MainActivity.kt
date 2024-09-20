package com.example.reversegeolocationapp

import android.location.Geocoder
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.Locale
import com.example.geoloaction2.R

class MainActivity : AppCompatActivity() {

    private lateinit var addressTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addressTextView = findViewById(R.id.tvLocation)

        // Example coordinates (latitude and longitude)
        val latitude = 37.7749
        val longitude = -122.4194

        getAddressFromLocation(latitude, longitude)
    }

    private fun getAddressFromLocation(lat: Double, lon: Double) {
        CoroutineScope(Dispatchers.IO).launch {
            val geocoder = Geocoder(this@MainActivity, Locale.getDefault())
            val addresses = geocoder.getFromLocation(lat, lon, 1)

            withContext(Dispatchers.Main) {
                addressTextView.text = if (addresses.isNotEmpty()) {
                    addresses[0].getAddressLine(0)
                } else {
                    "Address not found"
                }
            }
        }
    }
}
