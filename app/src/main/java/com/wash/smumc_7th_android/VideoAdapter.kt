package com.wash.smumc_7th_android

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class VideoAdapter(private val videoList: List<Video>) : RecyclerView.Adapter<VideoAdapter.VideoViewHolder>() {

    class VideoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val thumbnail: ImageView = view.findViewById(R.id.video_thumbnail)
        val title: TextView = view.findViewById(R.id.video_title)
        val info: TextView = view.findViewById(R.id.video_info)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_video, parent, false)
        return VideoViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        val video = videoList[position] // 현재 아이템의 Video 객체 가져옴

        // Video 객체의 데이터를 ViewHolder의 뷰에 설정
        holder.title.text = video.title // 제목 설정
        holder.info.text = "${video.views} • ${video.date}" // 조회수 및 날짜 설정
        holder.thumbnail.setImageResource(video.thumbnail) // 썸네일 이미지 설정
    }

    override fun getItemCount() = videoList.size
}