package com.wash.smumc_7th_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wash.smumc_7th_android.databinding.ActivityFirstBinding

class FirstActivity : AppCompatActivity() {
    private val binding: ActivityFirstBinding by lazy {
        ActivityFirstBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}