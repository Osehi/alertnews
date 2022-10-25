package com.polish.alertnews.feature.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.polish.alertnews.databinding.BreakingNewsItemBinding
import com.polish.alertnews.feature.data.network.model.newsarticle.Article

class BreakingNewsAdapter(var newsList: List<Article>): RecyclerView.Adapter<BreakingNewsAdapter.BreakingNewsListViewHolder>() {

    class BreakingNewsListViewHolder(private val binding: BreakingNewsItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(news: Article, context: Context) {
            // initialize the views and bind
            binding.breakingNewsItemNewsTitleTv.text = news.title
            binding.breakingNewsItemNewsDescriptionTv.text = news.description
            binding.breakingNewsItemNewsSourceTv.text = news.source?.name
            binding.breakingNewsItemPublishDateTv.text = news.publishedAt
            Glide.with(context).load(news.urlToImage).into(binding.breakingNewsItemPostImageIv)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BreakingNewsListViewHolder {
        val view = BreakingNewsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BreakingNewsListViewHolder(view)
    }

    override fun onBindViewHolder(holder: BreakingNewsListViewHolder, position: Int) {
        val currentItem = newsList[position]
        holder.bind(currentItem, holder.itemView.context)
    }

    override fun getItemCount(): Int {
        return newsList.size
    }
}
