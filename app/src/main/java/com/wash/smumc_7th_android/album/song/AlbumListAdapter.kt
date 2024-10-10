package com.wash.smumc_7th_android.album.song

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.wash.smumc_7th_android.album.AlbumItem
import com.wash.smumc_7th_android.databinding.ItemAlbumListBinding
import com.wash.smumc_7th_android.databinding.ItemAlbumTitlelistBinding

class AlbumListAdapter(
) : ListAdapter<AlbumItem, AlbumListAdapter.ViewHolder>(AlbumDiffUtil()) {

    abstract class ViewHolder(
        root: View
    ) : RecyclerView.ViewHolder(root) {
        abstract fun bind(item: AlbumItem)
    }

    enum class ViewType {
        TITLE, NORMAL
    }

    class TitleViewHolder(
        private val binding: ItemAlbumTitlelistBinding
    ) : ViewHolder(binding.root) {
        override fun bind(item: AlbumItem) = with(binding) {
            songListTitle01Tv.text = item.title
            songSingerName01Tv.text = item.singer
            songListOrder01Tv.text = (adapterPosition+1).toString().padStart(2, '0')
        }
    }

    class NormalViewHolder(
        private val binding: ItemAlbumListBinding
    ) : ViewHolder(binding.root) {
        override fun bind(item: AlbumItem) = with(binding) {
            songMusicTitle02Tv.text = item.title
            songSingerName02Tv.text = item.singer
            songListOrder02Tv.text =(adapterPosition+1).toString().padStart(2, '0')
        }
    }

    class UnknownViewHolder(
        private val binding: ItemAlbumTitlelistBinding
    ) : ViewHolder(binding.root) {
        override fun bind(item: AlbumItem) {
            binding.clListTitleParent.visibility = View.GONE
        }
    }

    override fun getItemViewType(position: Int): Int = when (getItem(position).isTitle) {
        true -> ViewType.TITLE.ordinal
        false -> ViewType.NORMAL.ordinal
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        when (viewType) {
            ViewType.TITLE.ordinal -> TitleViewHolder(
                ItemAlbumTitlelistBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )

            ViewType.NORMAL.ordinal -> NormalViewHolder(
                ItemAlbumListBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )

            else -> UnknownViewHolder(
                ItemAlbumTitlelistBinding.inflate(
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

class AlbumDiffUtil : DiffUtil.ItemCallback<AlbumItem>() {
    override fun areItemsTheSame(
        oldItem: AlbumItem,
        newItem: AlbumItem
    ): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(
        oldItem: AlbumItem,
        newItem: AlbumItem
    ): Boolean {
        return oldItem == newItem
    }

}