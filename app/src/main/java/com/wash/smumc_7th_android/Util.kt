package com.wash.smumc_7th_android

import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.FragmentActivity

fun FragmentActivity.visible() {
    (this as? MainActivity)?.let {
        val layout = findViewById<ConstraintLayout>(R.id.botNav_main)
        layout.visibility = View.VISIBLE
    }
}

fun FragmentActivity.invisible() {
    (this as? MainActivity)?.let {
        val layout = findViewById<ConstraintLayout>(R.id.botNav_main)
        layout.visibility = View.GONE
    }
}