package com.wash.smumc_7th_android.album.song

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.wash.smumc_7th_android.album.AlbumItem
import com.wash.smumc_7th_android.databinding.FragmentSongBinding

class SongFragment : Fragment() {
    private var _binding: FragmentSongBinding? = null
    private val binding get() = _binding!!

    private val albumListAdapter: AlbumListAdapter by lazy {
        AlbumListAdapter()
    }

    private val list = listOf(
        AlbumItem(img = "", title = "title A", singer = "top singer", isTitle = true),
        AlbumItem(img = "", title = "title A", singer = "top singer", isTitle = false),
        AlbumItem(img = "", title = "title A", singer = "top singer", isTitle = true),
        AlbumItem(img = "", title = "title A", singer = "top singer", isTitle = false),
        AlbumItem(img = "", title = "title A", singer = "top singer", isTitle = true),
        AlbumItem(img = "", title = "title A", singer = "top singer", isTitle = false),
        AlbumItem(img = "", title = "title A", singer = "top singer", isTitle = true),
        AlbumItem(img = "", title = "title A", singer = "top singer", isTitle = false),
        AlbumItem(img = "", title = "title A", singer = "top singer", isTitle = true),
        AlbumItem(img = "", title = "title A", singer = "top singer", isTitle = false),
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSongBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
    }

    private fun initView() = with(binding) {
        fun initRecyclerView() = with(rvSongList) {
            adapter = albumListAdapter
            layoutManager = LinearLayoutManager(requireContext())
            albumListAdapter.submitList(list)

        }

        initRecyclerView()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}