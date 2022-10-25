package com.polish.alertnews.feature.domain.repository

interface BreakingNewsRepository {
    suspend fun getAllBreakingNews()
}