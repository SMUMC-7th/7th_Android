package com.example.recyclerview_youtube

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview_youtube.databinding.ItemRvMainContentBinding

class MainContentListAdapter(
) : ListAdapter<String, MainContentListAdapter.ViewHolder>(
    object : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }

    }) {

    class ViewHolder(
        private val binding: ItemRvMainContentBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(title: String) = with(binding) {
            tvItemContentTitle.text = title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemRvMainContentBinding.inflate(
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