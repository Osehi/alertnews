package com.polish.alertnews.feature.data.network.model.newsarticle

data class NewsResponse(
    val articles: List<Article?>?,
    val status: String?,
    val totalResults: Int?
)
