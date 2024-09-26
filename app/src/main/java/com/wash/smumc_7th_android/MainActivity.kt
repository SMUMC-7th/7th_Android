package com.wash.smumc_7th_android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.wash.smumc_7th_android.databinding.ActivityMainBinding
import com.wash.smumc_7th_android.home.HomeFragment

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initView()
        setNavigation()
    }

    private fun initView() = with(binding){
        fun initHomeFragment(){
            setFragment(HomeFragment())
        }

        initHomeFragment()
    }


    private fun setNavigation() = with(binding){
        botNavMain.setOnItemSelectedListener { item ->
            when(item.itemId){
               R.id.nav_main_home ->{
                   setFragment(HomeFragment())
                   true
               }
               R.id.nav_main_profile ->{
                   true
               }
               R.id.nav_main_schedule -> {
                   true
               }
               R.id.nav_main_write ->{
                   true
               }
               else ->false
            }
        }
    }

    private fun setFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView_main, fragment)
            .addToBackStack(null)
            .commit()
    }
}