package com.wash.smumc_7th_android.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.wash.smumc_7th_android.databinding.ItemHomebotsheetBinding

class HomeBottomSheetDialog: BottomSheetDialogFragment() {
    private var _binding: ItemHomebotsheetBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ItemHomebotsheetBinding.inflate(inflater, container, false)
        return binding.root
    }
}