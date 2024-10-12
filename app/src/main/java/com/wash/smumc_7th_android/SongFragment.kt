package com.wash.smumc_7th_android

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.wash.smumc_7th_android.databinding.FragmentBannerBinding
import com.wash.smumc_7th_android.databinding.FragmentSongBinding
class SongFragment :Fragment(){
    lateinit var binding: FragmentSongBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSongBinding.inflate(inflater, container, false)
        binding.songMixoffTg.setOnClickListener {
            toggleMixMode(true)
        }
        binding.songMixonTg.setOnClickListener {
            toggleMixMode(false)
        }
        return binding.root
    }

    fun toggleMixMode(isMixMode : Boolean) {
        if (isMixMode) {
            binding.songMixoffTg.visibility = View.GONE
            binding.songMixonTg.visibility = View.VISIBLE
        } else {
            binding.songMixoffTg.visibility = View.VISIBLE
            binding.songMixonTg.visibility = View.GONE
        }
    }
}