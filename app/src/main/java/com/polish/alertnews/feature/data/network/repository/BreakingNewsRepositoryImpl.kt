package com.polish.alertnews.feature.data.network.repository

import com.polish.alertnews.feature.data.network.model.newsarticle.NewsResponse
import com.polish.alertnews.feature.domain.repository.BreakingNewsRepository

class BreakingNewsRepositoryImpl: BreakingNewsRepository {
    override suspend fun getAllBreakingNews(countryCode: String, pageNumber: Int): NewsResponse {
        TODO("Not yet implemented")
    }
}