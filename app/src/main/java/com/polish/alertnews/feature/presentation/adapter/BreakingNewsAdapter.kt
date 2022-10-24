package com.polish.alertnews.feature.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import com.polish.alertnews.databinding.BreakingNewsItemBinding

class BreakingNewsAdapter(var newsList: MutableList<Nothing>) {

    class BreakingNewsListViewHolder(private val binding: BreakingNewsItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind() {
        }
    }
}
