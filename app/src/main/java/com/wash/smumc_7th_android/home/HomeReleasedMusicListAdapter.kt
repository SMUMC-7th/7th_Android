package com.wash.smumc_7th_android.home

import android.os.Parcel
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.wash.smumc_7th_android.databinding.ItemHomeReleasedmusicBinding

class HomeReleasedMusicListAdapter(
) : ListAdapter<ReleasedMusicItem, HomeReleasedMusicListAdapter.ViewHolder>(HomeReleaseMusicDiffUtil()) {

    class ViewHolder(
        binding: ItemHomeReleasedmusicBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ReleasedMusicItem){}
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