package com.wash.smumc_7th_android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.wash.smumc_7th_android.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initNavigation()
        initBotNav()
    }

    private fun initNavigation() {
        val navHostFragment = supportFragmentManager
            .findFragmentById(binding.fragmentContainerViewMain.id) as NavHostFragment
        navController = navHostFragment.navController
    }

    private fun initBotNav() {
        binding.botNavMain.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_main_home -> {
                    true
                }

                R.id.menu_main_looker -> {
                    true
                }


                R.id.menu_main_search -> {
                    true
                }

                R.id.menu_main_storage -> {
                    true
                }

                else -> false
            }
        }
    }
}