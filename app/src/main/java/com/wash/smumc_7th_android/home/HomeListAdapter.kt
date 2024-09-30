package com.wash.smumc_7th_android.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.wash.smumc_7th_android.databinding.FragmentHomeBinding
import com.wash.smumc_7th_android.databinding.RvHomeBottomsheetBinding

class HomeListAdapter(
) : ListAdapter<HomeListItem, HomeListAdapter.ViewHolder>(HomeDiffUtil()) {
    class ViewHolder(
        private val binding: RvHomeBottomsheetBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: HomeListItem) = with(binding) {
            tvHomeBottomSheet.text = item.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            RvHomeBottomsheetBinding.inflate(
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


class HomeDiffUtil : DiffUtil.ItemCallback<HomeListItem>() {
    override fun areItemsTheSame(oldItem: HomeListItem, newItem: HomeListItem): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: HomeListItem, newItem: HomeListItem): Boolean {
        return oldItem.title == newItem.title
    }
}