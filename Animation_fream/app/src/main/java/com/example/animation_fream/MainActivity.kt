package com.example.animation_fream

import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var ad = AnimationDrawable()

        var f1 = resources.getDrawable(R.drawable.frame1,null)
        var f2 = resources.getDrawable(R.drawable.frame2,null)
        var f3 = resources.getDrawable(R.drawable.frame3,null)
        var f4 = resources.getDrawable(R.drawable.frame4,null)
        var f5 = resources.getDrawable(R.drawable.frame5,null)
        var f6 = resources.getDrawable(R.drawable.frame6,null)
        var f7 = resources.getDrawable(R.drawable.frame7,null)

        ad.addFrame(f1,144)
        ad.addFrame(f2,144)
        ad.addFrame(f3,144)
        ad.addFrame(f4,144)
        ad.addFrame(f5,144)
        ad.addFrame(f6,144)
        ad.addFrame(f7,144)

        var iv :ImageView = findViewById(R.id.imageview)
        iv.background = ad
        ad.start()

    }
}