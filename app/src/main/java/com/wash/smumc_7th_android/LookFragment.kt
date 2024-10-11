package com.wash.smumc_7th_android

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.wash.smumc_7th_android.databinding.FragmentLookBinding

class LookFragment : Fragment() {

    lateinit var binding: FragmentLookBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLookBinding.inflate(inflater, container, false)

        return binding.root
    }
}