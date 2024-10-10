package com.wash.smumc_7th_android.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.wash.smumc_7th_android.databinding.ItemHomeBannerBinding

class HomeBannerFragment(
    private val bannerImg: String
) : Fragment() {
    private var _binding: ItemHomeBannerBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ItemHomeBannerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val resourceId = requireContext().resources.getIdentifier(
            bannerImg,
            "drawable",
            requireContext().packageName
        )
        if (resourceId != 0) {
            binding.ivHomeBanner.setImageDrawable(ContextCompat.getDrawable(requireContext(), resourceId))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}