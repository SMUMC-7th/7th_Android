package com.wash.smumc_7th_android.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.wash.smumc_7th_android.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val listAdapter by lazy {
        HomeListAdapter()
    }

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

    private fun initView() {
        fun initBottomSheetRecyclerView() = with(binding){
            rvHomeItemBotSheet.layoutManager = GridLayoutManager(requireContext(), 2)
            rvHomeItemBotSheet.adapter = listAdapter
            listAdapter.submitList(listOf(
                HomeListItem("", "1"),
                HomeListItem("", "2"),
                HomeListItem("", "3")
            ))
        }

        fun initPersistentBottomSheet() {
            val bottomSheet: View = binding.clHomeItemBotSheet
            bottomSheet.visibility = View.VISIBLE
            val bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet)

            // BottomSheet의 초기 상태 설정
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED

            // BottomSheet 이벤트 핸들링
            bottomSheetBehavior.addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
                override fun onStateChanged(bottomSheet: View, newState: Int) {
                    // 상태 변화에 따른 처리
                }

                override fun onSlide(bottomSheet: View, slideOffset: Float) {
                    // 슬라이딩 중에 필요한 처리
                }
            })
        }

        fun initModalBottomSheet(){
            val botFragment = HomeBottomSheetDialog()
            botFragment.show(parentFragmentManager, "")
        }

        initBottomSheetRecyclerView()
        initPersistentBottomSheet()
//        initModalBottomSheet()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}