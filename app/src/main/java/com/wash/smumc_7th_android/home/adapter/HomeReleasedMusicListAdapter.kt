package com.wash.smumc_7th_android.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.wash.smumc_7th_android.R
import com.wash.smumc_7th_android.databinding.ItemHomeReleasedmusicBinding
import com.wash.smumc_7th_android.home.ReleasedMusicItem

class HomeReleasedMusicListAdapter(
    private val onClickAlbum: (ReleasedMusicItem) -> Unit
) : ListAdapter<ReleasedMusicItem, HomeReleasedMusicListAdapter.ViewHolder>(HomeReleaseMusicDiffUtil()) {

    inner class ViewHolder(
        private val binding: ItemHomeReleasedmusicBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ReleasedMusicItem) = with(binding){
            val context = binding.root.context
            val resourceId = context.resources.getIdentifier(
                item.img,
                "drawable",
                context.packageName
            )
            if (resourceId != 0) {
                ivReleasedMusic.setImageDrawable(ContextCompat.getDrawable(context, resourceId))
            } else {
                ivReleasedMusic.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.img_album_exp)) // 기본 이미지로 대체
            }

            ivReleasedMusic.setOnClickListener {
                onClickAlbum(item)
            }

            tvReleasedMusicSinger.text = item.singer
            tvReleasedMusicTitle.text = item.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemHomeReleasedmusicBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}


class HomeReleaseMusicDiffUtil : DiffUtil.ItemCallback<ReleasedMusicItem>() {
    override fun areItemsTheSame(
        oldItem: ReleasedMusicItem,
        newItem: ReleasedMusicItem
    ): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(
        oldItem: ReleasedMusicItem,
        newItem: ReleasedMusicItem
    ): Boolean {
        return oldItem.title == newItem.title
    }
}