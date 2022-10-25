package com.polish.alertnews.feature.data.network.api

import com.polish.alertnews.feature.data.network.model.newsarticle.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface BreakingNewsApi {
    @GET("v2/top-headlines")
    suspend fun getBreakingNews(
        @Query("country")
        countryCode: String = "us",
        @Query("page")
        pageNumber: Int = 1
    ): NewsResponse
}