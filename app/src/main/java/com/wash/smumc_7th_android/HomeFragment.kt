package com.wash.smumc_7th_android

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeFragment : Fragment(R.layout.fragment_home) {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)

        // 더미 데이터 생성
        val videoList = listOf(
            Video(
                title = "무한상사 #1",
                views = "10만회",
                date = "3주 전",
                thumbnail = R.drawable.sample_thumbnail_1
            ),
            Video(
                title = "무한상사 #2",
                views = "5만회",
                date = "1개월 전",
                thumbnail = R.drawable.sample_thumbnail_2
            ),
            Video(
                title = "무한상사 #3 전국 직장인 10:00~11:30 주업무 = 오늘 점심 메뉴정하기",
                views = "15만회",
                date = "2일 전",
                thumbnail = R.drawable.sample_thumbnail_3
            ),
            Video(
                title = "소문난 7공주",
                views = "350만회",
                date = "1개월 전",
                thumbnail = R.drawable.sample_thumbnail_4
            ),

        )

        // RecyclerView 설정
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = VideoAdapter(videoList)

        return view
    }
}
