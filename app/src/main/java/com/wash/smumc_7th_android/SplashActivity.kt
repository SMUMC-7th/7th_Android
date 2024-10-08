package com.wash.smumc_7th_android

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView // Ensure you import this
import android.widget.TextView // Ensure you import this
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    private val splashTimeOut: Long = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val fadeIn: Animation = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        val slideUp: Animation = AnimationUtils.loadAnimation(this, R.anim.slide_up)
        val splashLogo = findViewById<ImageView>(R.id.splash_logo)
        val splashSlogan = findViewById<TextView>(R.id.splash_slogan)

        splashLogo.startAnimation(fadeIn)
        splashSlogan.startAnimation(slideUp)

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, splashTimeOut)
    }
}
