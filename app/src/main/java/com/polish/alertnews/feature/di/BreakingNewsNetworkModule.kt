package com.polish.alertnews.feature.di

import com.polish.alertnews.feature.data.network.api.BreakingNewsApi
import com.polish.alertnews.feature.data.network.repository.BreakingNewsRepositoryImpl
import com.polish.alertnews.feature.domain.repository.BreakingNewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object BreakingNewsNetworkModule {

    @Provides
    @Singleton
    fun provideBreakingNewsApi(retrofit: Retrofit): BreakingNewsApi {
        return retrofit.create(BreakingNewsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideBreakingNewsRepository(breakingNewsApi: BreakingNewsApi): BreakingNewsRepository {
        return BreakingNewsRepositoryImpl(breakingNewsApi)
    }
}
