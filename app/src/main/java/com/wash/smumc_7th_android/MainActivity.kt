package com.wash.smumc_7th_android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import android.view.MenuItem

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        if (savedInstanceState == null) {
            loadFragment(HomeFragment(), false)
        }

        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.navigation_home -> {
                    loadFragment(HomeFragment(), true)
                    true
                }
                R.id.navigation_write -> {
                    loadFragment(WriteFragment(), true)
                    true
                }
                R.id.navigation_calendar -> {
                    loadFragment(CalendarFragment(), true)
                    true
                }
                R.id.navigation_person -> {
                    loadFragment(PersonFragment(), true)
                    true
                }
                else -> false
            }
        }
    }

    private fun loadFragment(fragment: Fragment, animate: Boolean) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()

        if (animate) {
            when (fragment) {
                is HomeFragment, is CalendarFragment -> {
                    fragmentTransaction.setCustomAnimations(
                        R.anim.slide_in_right,
                        R.anim.slide_out_left,
                        R.anim.fade_in,
                        R.anim.fade_out
                    )
                }
                is WriteFragment, is PersonFragment -> {
                    fragmentTransaction.setCustomAnimations(
                        R.anim.fade_in,
                        R.anim.fade_out,
                        R.anim.fade_in,
                        R.anim.fade_out
                    )
                }
            }
        }

        fragmentTransaction.replace(R.id.fragment_container, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
}
