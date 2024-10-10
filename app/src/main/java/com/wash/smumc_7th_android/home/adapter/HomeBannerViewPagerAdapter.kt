package com.wash.smumc_7th_android.home.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.wash.smumc_7th_android.home.HomeBannerFragment

class HomeBannerViewPagerAdapter(fragment: FragmentActivity) : FragmentStateAdapter(fragment) {
    private val fragments: ArrayList<Fragment> = arrayListOf(
        HomeBannerFragment("img_home_viewpager_exp"),
        HomeBannerFragment("img_home_viewpager_exp2")
    )

    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }

}