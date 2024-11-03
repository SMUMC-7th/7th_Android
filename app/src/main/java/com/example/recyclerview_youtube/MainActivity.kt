package com.example.recyclerview_youtube

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview_youtube.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val categoryListAdapter: MainCategoryListAdapter by lazy {
        MainCategoryListAdapter()
    }

    private val contentListAdapter: MainContentListAdapter by lazy {
        MainContentListAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initRecyclerviewAdapter()
    }

    private fun initRecyclerviewAdapter() {
        fun initCategoryAdapter() = with(binding.rvMainCategory) {
            adapter = categoryListAdapter
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
            categoryListAdapter.submitList(
                listOf(
                    "전체",
                    "게임",
                    "라이브",
                    "스케치 코미디",
                    "애니메이션",
                    "요리",
                    "최근 업로드된 동영상"
                )
            )
        }

        fun initContentAdapter() = with(binding.rvMainContent) {
            adapter = contentListAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
            contentListAdapter.submitList(
                listOf(
                    "creater1",
                    "creater2",
                    "creater3",
                    "creater4",
                    "creater5",
                    "creater6",
                    "creater7",
                    "creater8",
                )
            )
        }

        initCategoryAdapter()
        initContentAdapter()
    }
}