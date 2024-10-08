package com.wash.smumc_7th_android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import android.view.MenuItem
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

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
        val imageButton1 = findViewById<ImageButton>(R.id.imageButton1)
        val imageButton2 = findViewById<ImageButton>(R.id.imageButton2)
        val imageButton3 = findViewById<ImageButton>(R.id.imageButton3)
        val imageButton4 = findViewById<ImageButton>(R.id.imageButton4)
        val imageButton5 = findViewById<ImageButton>(R.id.imageButton5)
        val previous = findViewById<ImageButton>(R.id.pervious)

        imageButton1.setOnClickListener {
            val intent = Intent(this, Page1Activity::class.java)
            startActivity(intent)
        }
        imageButton2.setOnClickListener {
            val intent = Intent(this, Page2Activity::class.java)
            startActivity(intent)
        }
        imageButton3.setOnClickListener {
            val intent = Intent(this, Page3Activity::class.java)
            startActivity(intent)
        }
        imageButton4.setOnClickListener {
            val intent = Intent(this, Page4Activity::class.java)
            startActivity(intent)
        }
        imageButton5.setOnClickListener {
            val intent = Intent(this, Page5Activity::class.java)
            startActivity(intent)
        }
        previous.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
