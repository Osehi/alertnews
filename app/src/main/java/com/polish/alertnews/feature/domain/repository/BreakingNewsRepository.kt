package com.polish.alertnews.feature.domain.repository

import com.polish.alertnews.feature.data.network.model.newsarticle.NewsResponse

interface BreakingNewsRepository {
    suspend fun getAllBreakingNews(
        countryCode: String,
        pageNumber: Int
    ): NewsResponse
}