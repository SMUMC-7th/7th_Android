package com.wash.smumc_7th_android.album.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.wash.smumc_7th_android.album.AlbumFragmentTextItem
import com.wash.smumc_7th_android.album.song.SongFragment

class AlbumViewPagerAdapter(fragment: FragmentActivity) : FragmentStateAdapter(fragment) {
    private val list: ArrayList<AlbumFragmentTextItem> = arrayListOf(
        AlbumFragmentTextItem(SongFragment(), "수록곡"),
        AlbumFragmentTextItem(SongFragment(), "수록곡"),
        AlbumFragmentTextItem(SongFragment(), "수록곡")
    )

    override fun getItemCount(): Int {
        return list.size
    }

    override fun createFragment(position: Int): Fragment {
        return list[position].fragment
    }

    fun getTitle(position: Int): String = list[position].tabTitle
}