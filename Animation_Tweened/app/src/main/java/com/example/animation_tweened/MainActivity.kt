package com.example.animation_tweened

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var img : ImageView = findViewById(R.id.image)

        var b1 : Button = findViewById(R.id.button1)

        b1.setOnClickListener {
            var an = AnimationUtils.loadAnimation(this, anim)
        }
    }
}