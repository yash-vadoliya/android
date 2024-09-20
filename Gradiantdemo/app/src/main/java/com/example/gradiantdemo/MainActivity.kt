package com.example.gradiantdemo

import android.content.Context
import android.graphics.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        setContentView(Test(applicationContext))
    }

    inner class Test(context: Context) : View(context) {
        var p = Paint(Paint.ANTI_ALIAS_FLAG)
        override fun onDraw(canvas: Canvas?) {
            super.onDraw(canvas)

//            var lg = LinearGradient(0f,0f,45f,45f, Color.RED,Color.BLACK,Shader.TileMode.MIRROR)
//            p.shader = lg
//            canvas?.drawCircle(250f,250f,200f,p)

            var rg = RadialGradient(200f,600f,200f,Color.RED,Color.CYAN,Shader.TileMode.MIRROR)
            p.shader = rg
            val drawCircle = canvas?.drawCircle(250F, 750f, 200f, p)

            var sg = SweepGradient(200f,1500f, intArrayOf(Color.RED,Color.BLACK,Color.BLUE,Color.CYAN),null)
            p.shader = sg
            canvas?.drawCircle(250f,1500f, 200f,p)

            var rcg = LinearGradient(0f,0f,45f,45f, Color.WHITE,Color.BLACK,Shader.TileMode.MIRROR)
            p.shader = rcg
            canvas?.drawRect(100f, 100f, 1000f, 1000f, p)

            canvas?.drawDoubleRoundRect()

        }


    }

}



