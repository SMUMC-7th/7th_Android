package com.wash.smumc_7th_android.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.wash.smumc_7th_android.databinding.FragmentHomeBinding
import com.wash.smumc_7th_android.visible


class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val releasedMusicListAdapter: HomeReleasedMusicListAdapter by lazy {
        HomeReleasedMusicListAdapter()
    }

    val todayAlbumList = listOf(
        ReleasedMusicItem(img = "img_album_exp", title = "title", singer = "singer"),
        ReleasedMusicItem(img = "img_album_exp1", title = "title1", singer = "singer1"),
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
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
    }

    fun initView() = with(binding) {
        fun initRecyclerView() = with(homeTodayMusicAlbumRv) {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = releasedMusicListAdapter
            releasedMusicListAdapter.submitList(todayAlbumList)
        }

        initRecyclerView()
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