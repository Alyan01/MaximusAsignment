package com.example.maximus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.maximus.R
import android.content.Intent
import com.example.maximus.MainActivity
import java.util.*

class Splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                val intent = Intent(this@Splash, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }, 2000)
    }
}