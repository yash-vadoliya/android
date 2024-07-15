package com.example.relative

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        var btn : Button = findViewById(R.id.button)
        var imgbtn : ImageButton = findViewById(R.id.imageButton)
        var togbtn : ToggleButton = findViewById(R.id.toggleButton)
        var imgview : ImageView = findViewById(R.id.imageView)
        var vidview : VideoView = findViewById(R.id.videoView)
        
        btn.setOnClickListener {
            Toast.makeText(applicationContext, "Simple Button Click", Toast.LENGTH_SHORT).show()
        }

        imgbtn.setOnClickListener {
            Toast.makeText(applicationContext,"Image Button Click",Toast.LENGTH_LONG).show()
        }

        togbtn.setOnClickListener {
            if (togbtn.text.equals("OFF"))
            {
                imgview.setImageResource(R.drawable.off)
            }else{
                imgview.setImageResource(R.drawable.on)
                vidview.setVideoPath("\"C:\\Users\\atmiya140\\Desktop\\fan.gif\"")
                vidview.start()

            }
        }

    }
}