package com.example.android4_2.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android4_2.data.remote.models.DataItem
import com.example.android4_2.databinding.ItemAnimeBinding

class KitsuAdapter(val onItemClick: (id: String) -> Unit) :
    PagingDataAdapter<DataItem, KitsuAdapter.AnimeViewHolder>(diffUtil) {
    inner class AnimeViewHolder(private val binding: ItemAnimeBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                getItem(absoluteAdapterPosition)?.let {
                    onItemClick(it.id)
                }
            }
        }

        fun bind(item: DataItem) = with(binding) {
            with(item.attributes) {
                Glide.with(ivItem.context)
                    .load(posterImage.original)
                    .into(ivItem)
                if (!title.en.isNullOrEmpty()) {
                    textItem.text = title.en
                } else if (!title.enJp.isNullOrEmpty()) {
                    textItem.text = title.enJp
                } else if (!title.ja_jp.isNullOrEmpty()) {
                    textItem.text = title.ja_jp
                }
            }
        }
    }

    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder {
        return AnimeViewHolder(
            ItemAnimeBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<DataItem>() {
            override fun areItemsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {
                return oldItem == newItem
            }
        }
    }
}