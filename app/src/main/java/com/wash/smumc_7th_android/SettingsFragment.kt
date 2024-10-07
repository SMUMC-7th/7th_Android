package com.wash.smumc_7th_android.com.wash.smumc_7th_android

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.wash.smumc_7th_android.R

class SettingsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // 프래그먼트와 연결된 레이아웃을 반환
        return inflater.inflate(R.layout.fragment_navi_settings, container, false)
    }
}