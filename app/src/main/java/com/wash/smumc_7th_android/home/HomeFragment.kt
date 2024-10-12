package com.wash.smumc_7th_android.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.wash.smumc_7th_android.R
import com.wash.smumc_7th_android.databinding.FragmentHomeBinding
import com.wash.smumc_7th_android.home.adapter.HomeBannerViewPagerAdapter
import com.wash.smumc_7th_android.home.adapter.HomeReleasedMusicListAdapter
import com.wash.smumc_7th_android.visible


class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val releasedMusicListAdapter: HomeReleasedMusicListAdapter by lazy {
        HomeReleasedMusicListAdapter(
            onClickAlbum = { releasedMusicItem ->
                val bundle = Bundle().apply {
                    putSerializable("albumItem", releasedMusicItem)
                }
                findNavController().navigate(
                    resId = R.id.action_home_to_album,
                    args = bundle
                )
            })
    }

    private lateinit var homeBannerViewPagerAdapter: HomeBannerViewPagerAdapter


    val todayAlbumList = listOf(
        ReleasedMusicItem(img = "img_album_exp", title = "title", singer = "singer"),
        ReleasedMusicItem(img = "img_album_exp2", title = "title2", singer = "singer2"),
        ReleasedMusicItem(img = "img_album_exp3", title = "title3", singer = "singer3"),
        ReleasedMusicItem(img = "img_album_exp4", title = "title4", singer = "singer4"),
        ReleasedMusicItem(img = "img_album_exp5", title = "title5", singer = "singer5"),
        ReleasedMusicItem(img = "img_album_exp6", title = "title6", singer = "singer6"),
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        homeBannerViewPagerAdapter = HomeBannerViewPagerAdapter(requireActivity())

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
    }

    fun initView() = with(binding) {
        fun initRecyclerView() {
            homeTodayMusicAlbumRv.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            homeTodayMusicAlbumRv.adapter = releasedMusicListAdapter
            releasedMusicListAdapter.submitList(todayAlbumList)
        }

        fun initViewPager() {
            homeBannerVp.adapter = homeBannerViewPagerAdapter
        }


        initRecyclerView()
        initViewPager()
    }


    override fun onResume() {
        super.onResume()
        activity?.visible()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}