package com.polish.alertnews.feature.data.network.repository

import com.polish.alertnews.feature.data.network.api.BreakingNewsApi
import com.polish.alertnews.feature.data.network.model.newsarticle.NewsResponse
import com.polish.alertnews.feature.domain.repository.BreakingNewsRepository
import javax.inject.Inject

class BreakingNewsRepositoryImpl @Inject constructor(
    private val breakingNewsApi: BreakingNewsApi
) : BreakingNewsRepository {
    override suspend fun getAllBreakingNews(countryCode: String, pageNumber: Int): NewsResponse {
        return breakingNewsApi.getBreakingNews()
    }
}
