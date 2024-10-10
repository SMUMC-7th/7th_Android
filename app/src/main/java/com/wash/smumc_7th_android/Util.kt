package com.wash.smumc_7th_android

import android.view.View
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavOptions
import com.google.android.material.bottomnavigation.BottomNavigationView

fun FragmentActivity.visible() {
    (this as? MainActivity)?.let {
        val layout = findViewById<BottomNavigationView>(R.id.botNav_main)
        layout.visibility = View.VISIBLE
    }
}

fun FragmentActivity.invisible() {
    (this as? MainActivity)?.let {
        val layout = findViewById<BottomNavigationView>(R.id.botNav_main)
        layout.visibility = View.GONE
    }
}