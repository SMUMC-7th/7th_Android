package com.wash.smumc_7th_android.album

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.wash.smumc_7th_android.album.adapter.AlbumViewPagerAdapter
import com.wash.smumc_7th_android.databinding.FragmentAlbumBinding
import com.wash.smumc_7th_android.home.ReleasedMusicItem
import com.wash.smumc_7th_android.invisible
import com.wash.smumc_7th_android.visible

class AlbumFragment : Fragment() {
    private var _binding: FragmentAlbumBinding? = null
    private val binding get() = _binding!!

    private var albumItem: ReleasedMusicItem? = null

    private val albumViewPagerAdapter: AlbumViewPagerAdapter by lazy{
        AlbumViewPagerAdapter(requireActivity())
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        arguments?.let {
            albumItem = it.getSerializable("albumItem") as? ReleasedMusicItem
        }

        _binding = FragmentAlbumBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
    }

    private fun initView() = with(binding){
        fun initAlbumItem() {
            albumItem?.let {
                val context = binding.root.context
                val resourceId = context.resources.getIdentifier(
                    it.img,
                    "drawable",
                    context.packageName
                )
                if (resourceId != 0) {
                    albumAlbumIv.setImageDrawable(ContextCompat.getDrawable(context, resourceId))
                }
            }
        }

        fun initViewPager() = with(albumContentVp){
            adapter = albumViewPagerAdapter
            TabLayoutMediator(binding.albumContentTb, binding.albumContentVp){ tab, position ->
                tab.text = albumViewPagerAdapter.getTitle(position)
            }.attach()

        }

        initViewPager()
        initAlbumItem()
    }

    override fun onResume() {
        super.onResume()
        activity?.invisible()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        activity?.visible()
        _binding = null
    }
}